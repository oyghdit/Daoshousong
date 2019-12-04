package com.example.foodcircle.fragment;

import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import com.example.base.BaseFragment;

public class FoodcircleFragment extends BaseFragment {  //美食圈的Fragment

    private static final String TAG = FoodcircleFragment.class.getSimpleName();
    private TextView textView;
    @Override
    public View initView() {
        Log.e(TAG,"美食圈的Fragment的UI被初始化了");
        textView = new TextView(mContext);
        textView.setGravity(Gravity.CENTER);
        textView.setTextSize(25);
        return textView;
    }

    @Override
    public void initData() {
        super.initData();
        Log.e(TAG,"美食圈的Fragment的数据被初始化了");
        textView.setText("美食圈内容");
    }
}
