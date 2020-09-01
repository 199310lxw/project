package com.example.componentdemo;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity {
    private RadioGroup mRadioGroup;
    private RadioButton mRadioButton_Home;
    private Fragment []mFragments;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFragments =DataGenerator.getFragments("home");
        initView();
    }
    private void initView() {
        mRadioGroup = (RadioGroup) findViewById(R.id.radiogroup);
        mRadioButton_Home = (RadioButton) findViewById(R.id.radio_button_home);
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            Fragment mFragment = null;
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId){
                    case R.id.radio_button_home:
                        mFragment = mFragments[0];
                        break;
                    case R.id.radio_button_dynamic:
                        mFragment = mFragments[1];
                        break;
                    case R.id.radio_button_message:
                        mFragment = mFragments[2];
                        break;
                    case R.id.radio_button_user:
                        mFragment = mFragments[3];
                        break;
                }
                if(mFragments!=null){
                    getSupportFragmentManager().beginTransaction().replace(R.id.home_container,mFragment).commit();
                }
            }
        });
        // 保证第一次会回调OnCheckedChangeListener
        mRadioButton_Home.setChecked(true);
    }
}