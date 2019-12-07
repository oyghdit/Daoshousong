package com.example.user.fragment;

import android.content.Intent;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.base.BaseFragment;
import com.example.daoshousong.R;
import com.example.main.LoginActivity;

public class UserFragment extends BaseFragment {    //用户页面Fragment

    private static final String TAG = UserFragment.class.getSimpleName();
    private Button btn_login_user;

    @Override
    public View initView() {
        Log.e(TAG,"用户页面的Fragment的UI被初始化了");
        View view = View.inflate(mContext, R.layout.fragment_user, null);
        btn_login_user = (Button)view.findViewById(R.id.btn_login_user);
        btn_login_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }

    @Override
    public void initData() {
        super.initData();
        Log.e(TAG,"用户页面的Fragment的数据被初始化了");

    }
}
