package com.example.componentdemo.views;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.componentdemo.R;

/*************************************
 * @Author : liuxiangwang
 * @Date : 17:22  2020/9/2
 * @Email : liuxiangwang@vivo.com
 * @title : 
 * @Company : www.vivo.com
 * @Description : 
 ************************************/
public class homeDialog extends DialogFragment {
    private Context context;
    private View mRootView;
    private Button btn_cancel_high_opion;
    private Button btn_agree_high_opion;
    private EditText edit;

    private onChildListener mOnChildListener;

    public homeDialog(Context mContext){
        this.context = mContext;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(STYLE_NO_TITLE,R.style.HomeDialog);
    }



    public void setOnChildListener(onChildListener mOnChildListener){
        this.mOnChildListener = mOnChildListener;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView =inflater.inflate(R.layout.home_dialog_layout,container,false);
        setView(mRootView);
        return mRootView;
    }

    @Override
    public void onStart() {
        super.onStart();
        setLocation();
    }

    private void setView(View mView) {
        edit = mView.findViewById(R.id.edit);
        btn_cancel_high_opion = mView.findViewById(R.id.btn_cancel_high_opion);
        btn_agree_high_opion = mView.findViewById(R.id.btn_agree_high_opion);
        btn_cancel_high_opion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  if(mOnChildListener != null) {
                      mOnChildListener.onCancel();
                  }
            }
        });
        btn_agree_high_opion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edit.getText().toString().trim().equals("123")) {
                    if(mOnChildListener != null) {
                        mOnChildListener.onAgree();
                    }
                } else {
                    Toast.makeText(context,"验证码错误",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    /**
     * 设置dialog显示位置
     */
    private void setLocation() {
        Window window =getDialog().getWindow();
        WindowManager.LayoutParams wlp= window.getAttributes();
        wlp.gravity = Gravity.CENTER;

        wlp.width = WindowManager.LayoutParams.MATCH_PARENT;
        wlp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        window.setAttributes(wlp);
    }

    public interface onChildListener{
        void onCancel();
        void onAgree();
    }
}
