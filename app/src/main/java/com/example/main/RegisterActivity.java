package com.example.main;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import com.example.dao.CustomerDao;
import com.example.dao.DBOpenHelper;
import com.example.daoshousong.R;
import com.example.modle.Tb_customerinfo;

public class RegisterActivity extends AppCompatActivity {
    private Button btnregister;
    private Button btncancel;
    private EditText usernameET;
    private EditText userpwdET;
    private Spinner sexSP;
    private EditText cteleET;
    private EditText cschoolET;
    private EditText cbuildingET;
    private EditText cdormitoryET;
    private DBOpenHelper helper;// 创建DBOpenHelper对象
    private SQLiteDatabase db;// 创建SQLiteDatabase对象

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        btnregister=(Button)findViewById(R.id.button1);
        btncancel = (Button)findViewById(R.id.button2);
        usernameET=(EditText)findViewById(R.id.editText1);
        userpwdET=(EditText)findViewById(R.id.editText2);
        sexSP= (Spinner) findViewById(R.id.spinner3);
        cteleET = (EditText) findViewById(R.id.editText4);
        cschoolET=(EditText)findViewById(R.id.editText5);
        cbuildingET=(EditText)findViewById(R.id.editText6);
        cdormitoryET=(EditText)findViewById(R.id.editText7);

        //注册按钮
        btnregister.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                if(!(usernameET.getText().toString().equals("")||userpwdET.getText().toString().equals("")))
                {
                    //创建数据库连接
                    CustomerDao cdao=new CustomerDao(RegisterActivity.this);
                    // 创建tb_customerinfo对象
                    Tb_customerinfo tb_customerinfo = new Tb_customerinfo(usernameET.getText().toString(),
                            userpwdET.getText().toString(), sexSP.getSelectedItem().toString(),
                            cteleET.getText().toString(),cschoolET.getText().toString(),
                            cbuildingET.getText().toString(),cdormitoryET.getText().toString());
                    cdao.add(tb_customerinfo);
                    // 弹出信息提示
                    Toast.makeText(RegisterActivity.this, "注册成功！", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(intent);
                }else{

                    Toast.makeText(RegisterActivity.this, "请输入用户名和密码", Toast.LENGTH_SHORT).show();
                }

            }
        });

        //取消按钮
        btncancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        /**
         * 设置为竖屏
         */
        if(getRequestedOrientation()!= ActivityInfo.SCREEN_ORIENTATION_PORTRAIT){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
        super.onResume();
    }
}
