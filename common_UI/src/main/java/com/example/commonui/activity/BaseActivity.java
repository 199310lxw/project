package com.example.commonui.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.commonui.R;
import com.gyf.immersionbar.ImmersionBar;

/*************************************
 * @Author : liuxiangwang
 * @Date : 16:04  2020/8/31
 * @Email : liuxiangwang@vivo.com
 * @title : 
 * @Company : www.vivo.com
 * @Description : 
 ************************************/
public class BaseActivity  extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initBar();
    }
   private void initBar() {
       ImmersionBar
               .with(this)
               .fullScreen(true)                     //有导航栏的情况下，Activity是否全屏显示
               .statusBarDarkFont(true)              //状态栏字体深色或亮色
               .statusBarColor(R.color.white)        //状态栏颜色
//               .navigationBarColor(R.color.white)    //导航栏颜色
               .init();
   }
}
