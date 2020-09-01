package com.example.componentdemo.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.componentdemo.R;

/*************************************
 * @Author : liuxiangwang
 * @Date : 15:04  2020/9/1
 * @Email : liuxiangwang@vivo.com
 * @title : 
 * @Company : www.vivo.com
 * @Description : 
 ************************************/
public class UserFragment extends Fragment {
    private static UserFragment mUserFragment = null;
    private View mRootView;
    public static UserFragment newInstance (String tag) {
        if(mUserFragment == null) {
            mUserFragment =new UserFragment();
        }
        return mUserFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView =inflater.inflate(R.layout.fragment_user,container,false);
        return mRootView;
    }
}
