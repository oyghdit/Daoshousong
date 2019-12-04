package com.example.user.fragment;

import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import com.example.base.BaseFragment;

public class UserFragment extends BaseFragment {    //用户页面Fragment

    private static final String TAG = UserFragment.class.getSimpleName();
    private TextView textView;
    @Override
    public View initView() {
        Log.e(TAG,"用户页面的Fragment的UI被初始化了");
        textView = new TextView(mContext);
        textView.setGravity(Gravity.CENTER);
        textView.setTextSize(25);
        return textView;
    }

    @Override
    public void initData() {
        super.initData();
        Log.e(TAG,"用户页面的Fragment的数据被初始化了");
        textView.setText("用户页面内容");
    }
}
