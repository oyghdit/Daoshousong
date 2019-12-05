package com.example.home.fragment;

import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.example.base.BaseFragment;
import com.example.daoshousong.R;

import static android.content.ContentValues.TAG;

public class HomeFragment extends BaseFragment {    //主页面Fragment

    private TextView btn_search_home;

    @Override
    public View initView() {
        Log.e(TAG,"主页面的Fragment的UI被初始化了");
        View view = View.inflate(mContext,R.layout.fragment_home,null);
        btn_search_home = (TextView) view.findViewById(R.id.btn_search_home);
        //设置点击事件
        initListener();
        return view;
    }
    @Override
    public void initData() {
        super.initData();
        Log.e(TAG, "主页数据被初始化了");
    }
    private void initListener() {
        //搜索的监听
        btn_search_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "搜索",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
