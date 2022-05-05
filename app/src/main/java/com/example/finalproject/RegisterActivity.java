package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private String realCode;
    private DatabaseHelper mDatabaseHelper;
    private Button mBtRegisteractivityRegister;
    private ImageView mIvRegisteractivityBack;
    private EditText mEtRegisteractivityUsername;
    private EditText mEtRegisteractivityPassword1;
    private EditText mEtRegisteractivityPassword2;
    private EditText mEtRegisteractivityPhonecodes;
    private ImageView mIvRegisteractivityShowcode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initView();

        mDatabaseHelper = new DatabaseHelper(this);

        //将验证码用图片的形式显示出来
        mIvRegisteractivityShowcode.setImageBitmap(Code.getInstance().createBitmap());
        realCode = Code.getInstance().getCode().toLowerCase();
    }

    private void initView(){

        // 初始化控件
        mBtRegisteractivityRegister = findViewById(R.id.registeractivity_btn_register);
        mIvRegisteractivityBack = findViewById(R.id.registeractivity_iv_back);
        mEtRegisteractivityUsername = findViewById(R.id.registeractivity_et_username);
        mEtRegisteractivityPassword1 = findViewById(R.id.registeractivity_et_password1);
        mEtRegisteractivityPassword2 = findViewById(R.id.registeractivity_et_password2);
        mEtRegisteractivityPhonecodes = findViewById(R.id.registeractivity_et_phoneCodes);
        mIvRegisteractivityShowcode = findViewById(R.id.registeractivity_iv_showCode);

        // 设置点击事件监听器
        mIvRegisteractivityBack.setOnClickListener(this);
        mIvRegisteractivityShowcode.setOnClickListener(this);
        mBtRegisteractivityRegister.setOnClickListener(this);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.registeractivity_iv_back: //返回登录页面
                Intent intent1 = new Intent(this, LoginActivity.class);
                startActivity(intent1);
                finish();
                break;
            case R.id.registeractivity_iv_showCode:    //改变随机验证码的生成
                mIvRegisteractivityShowcode.setImageBitmap(Code.getInstance().createBitmap());
                realCode = Code.getInstance().getCode().toLowerCase();
                break;
            case R.id.registeractivity_btn_register:    //注册按钮
                //获取用户输入的用户名、密码、验证码
                String username = mEtRegisteractivityUsername.getText().toString().trim();
                String password = mEtRegisteractivityPassword1.getText().toString().trim();
                String password2 = mEtRegisteractivityPassword2.getText().toString().trim();
                String phoneCode = mEtRegisteractivityPhonecodes.getText().toString().toLowerCase();
                //注册验证
                if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password) && !TextUtils.isEmpty(phoneCode) ) {
                    if (password.equals(password2)){
                        if (phoneCode.equals(realCode)) {
                            //将用户名和密码加入到数据库中
                            mDatabaseHelper.add(username, password);
                            startActivity(new Intent(this, HomeActivity.class));
                            finish();
                            Toast.makeText(this,  "验证通过，注册成功", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(this, "验证码错误", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(this, "两次密码不一致", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(this, "信息未完善", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}

