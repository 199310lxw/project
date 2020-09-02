package com.example.componentdemo.fragments;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.componentdemo.R;
import com.example.componentdemo.adapters.DemoAdapter;
import com.example.componentdemo.views.StaggeredDividerItemDecoration;
import com.example.componentdemo.views.homeDialog;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;

/*************************************
 * @Author : liuxiangwang
 * @Date : 15:04  2020/9/1
 * @Email : liuxiangwang@vivo.com
 * @title : 
 * @Company : www.vivo.com
 * @Description : 
 ************************************/
public class HomeFragment extends Fragment implements homeDialog.onChildListener{
    private static HomeFragment mHomeFragment = null;
    private View mRootView;

    private ArrayList<Integer> imageIds = new ArrayList<>();
    private int[] ids = {R.mipmap.p1,R.mipmap.p2,R.mipmap.p3,R.mipmap.p4,R.mipmap.p5,R.mipmap.p6,R.mipmap.p7,
            R.mipmap.p8,R.mipmap.p9,R.mipmap.p10};

    private RecyclerView rv_waterfall;
    private DemoAdapter adapter;

    private SmartRefreshLayout refreshlayout;

    private homeDialog mHomeDialog;

    public static HomeFragment newInstance(String tag) {
        if(mHomeFragment == null) {
            mHomeFragment =new HomeFragment();
        }
        return mHomeFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView =inflater.inflate(R.layout.fragment_home,container,false);
        initView(mRootView);
        return mRootView;
    }

    private void initView(View mView) {

        mHomeDialog =new homeDialog(getActivity());
        mHomeDialog.show(getActivity().getSupportFragmentManager(),"home");
        mHomeDialog.setOnChildListener(this);

        refreshlayout = mView.findViewById(R.id.refreshlayout);
        rv_waterfall = mView.findViewById(R.id.rv_waterfall);
        rv_waterfall.setHasFixedSize(true);
        rv_waterfall.setItemAnimator(null);

        //垂直方向的2列
        final StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        //防止Item切换
        layoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);
        rv_waterfall.setLayoutManager(layoutManager);
        final int spanCount = 2;

        rv_waterfall.addItemDecoration(new StaggeredDividerItemDecoration(getActivity(),20,spanCount));

        //解决底部滚动到顶部时，顶部item上方偶尔会出现一大片间隔的问题
        rv_waterfall.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                int[] first = new int[spanCount];
                layoutManager.findFirstCompletelyVisibleItemPositions(first);
                if (newState == RecyclerView.SCROLL_STATE_IDLE && (first[0] == 1 || first[1] == 1)) {
                    layoutManager.invalidateSpanAssignments();
                }
            }
        });

        //设置Adapter
        for(int i = 0 ; i < ids.length;i++){
            imageIds.add(ids[i]);
            Log.e("TAG",imageIds.get(i).toString());
        }
        adapter = new DemoAdapter(getActivity());

        rv_waterfall.setAdapter(adapter);
        adapter.replaceAll(imageIds);

        //设置下拉刷新和上拉加载监听
        refreshlayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull final RefreshLayout refreshLayout) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        adapter.replaceAll(getData());
                        refreshLayout.finishRefresh();
                    }
                },2000);
            }
        });

    }

    private ArrayList<Integer>  getData() {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < ids.length;i++){
            list.add(ids[i]);
        }
        return list;
    }

    @Override
    public void onPause() {
        super.onPause();
        imageIds.clear();
    }

    @Override
    public void onCancel() {
        getActivity().finish();
    }

    @Override
    public void onAgree() {
        mHomeDialog.dismiss();
    }
}
