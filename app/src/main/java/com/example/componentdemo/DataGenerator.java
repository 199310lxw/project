package com.example.componentdemo;

import androidx.fragment.app.Fragment;

import com.example.componentdemo.fragments.DynamicFragment;
import com.example.componentdemo.fragments.HomeFragment;
import com.example.componentdemo.fragments.MessageFragment;
import com.example.componentdemo.fragments.UserFragment;


/*************************************
 * @Author : liuxiangwang
 * @Date : 15:00  2020/9/1
 * @Email : liuxiangwang@vivo.com
 * @title : 
 * @Company : www.vivo.com
 * @Description : 
 ************************************/
public class DataGenerator {

    public static Fragment[] getFragments(String from){
        Fragment fragments[] = new Fragment[4];
        fragments[0] = HomeFragment.newInstance(from);
        fragments[1] = DynamicFragment.newInstance(from);
        fragments[2] = MessageFragment.newInstance(from);
        fragments[3] = UserFragment.newInstance(from);
        return fragments;
    }
}
