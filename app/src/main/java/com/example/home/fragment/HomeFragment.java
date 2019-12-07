package com.example.home.fragment;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import com.example.base.BaseFragment;
import com.example.daoshousong.R;

import static android.content.ContentValues.TAG;

public class HomeFragment extends BaseFragment {    //主页面Fragment

    private RecyclerView rvHome;
    private ImageView ib_top;
    private Button btn_search_home;

    @Override
    public View initView() {
        Log.e(TAG, "主页视图被初始化了");
        View view = View.inflate(mContext, R.layout.fragment_home,
                null);
        rvHome = (RecyclerView) view.findViewById(R.id.rv_home);
        ib_top = (ImageView) view.findViewById(R.id.ib_top);
        btn_search_home = (Button) view.findViewById(R.id.btn_search_home);
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
        //置顶的监听
        ib_top.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //回到顶部
                rvHome.scrollToPosition(0);
            }
        });
        //搜素的监听
        btn_search_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "搜索",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
