package com.example.order.fragment;

import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import com.example.base.BaseFragment;

public class OrderFragment extends BaseFragment {    //订单页面Fragment

    private static final String TAG = OrderFragment.class.getSimpleName();
    private TextView textView;
    @Override
    public View initView() {
        Log.e(TAG,"订单页面的Fragment的UI被初始化了");
        textView = new TextView(mContext);
        textView.setGravity(Gravity.CENTER);
        textView.setTextSize(25);
        return textView;
    }

    @Override
    public void initData() {
        super.initData();
        Log.e(TAG,"订单页面的Fragment的数据被初始化了");
        textView.setText("订单页面内容");
    }
}
