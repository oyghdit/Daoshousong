package com.example.home.fragment;

import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import com.example.base.BaseFragment;

public class HomeFragment extends BaseFragment {    //主页面Fragment

    private static final String TAG = HomeFragment.class.getSimpleName();
    private TextView textView;
    @Override
    public View initView() {
        Log.e(TAG,"主页面的Fragment的UI被初始化了");
        textView = new TextView(mContext);
        textView.setGravity(Gravity.CENTER);
        textView.setTextSize(25);
        return textView;
    }

    @Override
    public void initData() {
        super.initData();
        Log.e(TAG,"主页面的Fragment的数据被初始化了");
        textView.setText("主页面内容");
    }
}
