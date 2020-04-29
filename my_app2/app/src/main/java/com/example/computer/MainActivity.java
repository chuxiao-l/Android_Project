package com.example.computer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // 定义对象
    TextView txt_result;
    Button btn_7;
    Button btn_8;
    Button btn_9;
    Button btn_add;
    Button btn_4;
    Button btn_5;
    Button btn_6;
    Button btn_minus;
    Button btn_1;
    Button btn_2;
    Button btn_3;
    Button btn_multiply;
    Button btn_0;
    Button btn_clear;
    Button btn_equal;
    Button btn_divide;
    double num1 = 0, num2 = 0;
    double result = 0; //运算结果
    Boolean isClickdeng = false; //判断是否单击=号
    String op = "%"; //运算符

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 绑定控件
        txt_result = findViewById(R.id.txt_result);
        btn_7 = findViewById(R.id.btn_7);
        btn_8 = findViewById(R.id.btn_8);
        btn_9 = findViewById(R.id.btn_9);
        btn_add = findViewById(R.id.btn_add);
        btn_4 = findViewById(R.id.btn_4);
        btn_5 = findViewById(R.id.btn_5);
        btn_6 = findViewById(R.id.btn_6);
        btn_minus = findViewById(R.id.btn_minus);
        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);
        btn_multiply = findViewById(R.id.btn_multiply);
        btn_0 = findViewById(R.id.btn_0);
        btn_clear = findViewById(R.id.btn_clear);
        btn_equal = findViewById(R.id.btn_equal);
        btn_divide = findViewById(R.id.btn_divide);
        // 按钮单击事件
        btn_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isClickdeng) {
                    txt_result.setText("");
                    isClickdeng = false;
                }
                txt_result.setText(txt_result.getText().toString() + "7");
            }
        });
        btn_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isClickdeng) {
                    txt_result.setText("");
                    isClickdeng = false;
                }
                txt_result.setText(txt_result.getText().toString() + "8");
            }
        });
        btn_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isClickdeng) {
                    txt_result.setText("");
                    isClickdeng = false;
                }
                txt_result.setText(txt_result.getText().toString() + "9");
            }
        });
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str1 = txt_result.getText().toString();
                if (str1.equals("")) {
                    return;
                }
                num1 = Double.parseDouble(str1);
                txt_result.setText("");
                op = "+";
                isClickdeng = false;
            }
        });
        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isClickdeng) {
                    txt_result.setText("");
                    isClickdeng = false;
                }
                txt_result.setText(txt_result.getText().toString() + "4");
            }
        });
        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isClickdeng) {
                    txt_result.setText("");
                    isClickdeng = false;
                }
                txt_result.setText(txt_result.getText().toString() + "5");
            }
        });
        btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isClickdeng) {
                    txt_result.setText("");
                    isClickdeng = false;
                }
                txt_result.setText(txt_result.getText().toString() + "6");
            }
        });
        btn_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str1 = txt_result.getText().toString();
                if (str1.equals("")) {
                    return;
                }
                num1 = Double.parseDouble(str1);
                txt_result.setText("");
                op = "-";
                isClickdeng = false;
            }
        });
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isClickdeng) {
                    txt_result.setText("");
                    isClickdeng = false;
                }
                txt_result.setText(txt_result.getText().toString() + "1");
            }
        });
        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isClickdeng) {
                    txt_result.setText("");
                    isClickdeng = false;
                }
                txt_result.setText(txt_result.getText().toString() + "2");
            }
        });
        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isClickdeng) {
                    txt_result.setText("");
                    isClickdeng = false;
                }
                txt_result.setText(txt_result.getText().toString() + "3");
            }
        });
        btn_multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str1 = txt_result.getText().toString();
                if (str1.equals("")) {
                    return;
                }
                num1 = Double.parseDouble(str1);
                txt_result.setText("");
                op = "*";
                isClickdeng = false;
            }
        });
        btn_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isClickdeng) {
                    txt_result.setText("");
                    isClickdeng = false;
                }
                txt_result.setText(txt_result.getText().toString() + "0");
            }
        });
        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_result.setText("");
            }
        });
        btn_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str2 = txt_result.getText().toString();
                if (str2.equals("")) {
                    return;
                }
                num2 = Double.parseDouble(str2);
                txt_result.setText("");
                switch (op) {
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                    case "/":
                        result = num1 / num2;
                        break;
                    case "%":
                        result = num2;
                        break;
                    default:
                        result = 0.0;
                }
                txt_result.setText(result + "");
                op = "%";
                isClickdeng = true;
            }
        });
        btn_divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str1 = txt_result.getText().toString();
                if (str1.equals("")) {
                    return;
                }
                num1 = Double.parseDouble(str1);
                txt_result.setText("");
                op = "/";
                isClickdeng = false;
            }
        });
    }
}
