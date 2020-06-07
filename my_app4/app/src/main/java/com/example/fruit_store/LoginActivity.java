package com.example.fruit_store;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    //  定义对象
    EditText editText_user, editText_pwd;
    CheckBox checkBox_rem;
    Button button_login, button_cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // 绑定控件
        initView();
        // 登录按钮的单击事件
        btnLoginClick();
        // 显示用户名和密码
        displayInfo();
    }

    private void displayInfo() {
        String strname = getSharedPreferences("myinfo", 0).getString("name", "");
        String strpwd = getSharedPreferences("myinfo", 0).getString("pwd", "");
        boolean status = getSharedPreferences("myinfo", 0).getBoolean("st", false);
        if (status == true) {
            editText_user.setText(strname);
            editText_pwd.setText(strpwd);
            checkBox_rem.setChecked(true);
        } else {
            editText_user.setText("");
            editText_pwd.setText("");
            checkBox_rem.setChecked(false);
        }
    }

    private void btnLoginClick() {
        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 保存用户名和密码的保存
                SharedPreferences.Editor editor = getSharedPreferences("myinfo", 0).edit();
                editor.putString("name", editText_user.getText().toString());
                editor.putString("pwd", editText_pwd.getText().toString());
                editor.putBoolean("st", checkBox_rem.isChecked());
                editor.commit();
                // 跳转到主页面
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        editText_user = findViewById(R.id.edittext_user);
        editText_pwd = findViewById(R.id.edittext_pwd);
        checkBox_rem = findViewById(R.id.checkbox_rem);
        button_login = findViewById(R.id.btn_login);
        button_cancel = findViewById(R.id.btn_cancel);
    }
}