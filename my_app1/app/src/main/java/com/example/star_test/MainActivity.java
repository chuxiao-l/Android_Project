package com.example.star_test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    // 1)定义对象
    Button btn_search;
    EditText edit_inputname;
    DatePicker date_birth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 2)绑定控件
        btn_search = findViewById(R.id.button_search);
        edit_inputname = findViewById(R.id.edit_inputname);
        date_birth = findViewById(R.id.datePicker_birth);
        // 3)按钮单击事件
        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("name", edit_inputname.getText().toString());
                intent.putExtra("year", date_birth.getYear());
                intent.putExtra("month", date_birth.getMonth());
                intent.putExtra("day", date_birth.getDayOfMonth());
                startActivity(intent);
            }
        });
    }
}
