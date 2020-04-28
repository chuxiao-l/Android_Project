package com.example.star_test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    // 1)定义对象
    TextView txt_getname, txt_getbirth, txt_contentstar;
    ImageView img_imgstar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        // 2)绑定控件
        txt_getname = findViewById(R.id.textView_getname);
        txt_getbirth = findViewById(R.id.textView_getbirth);
        txt_contentstar = findViewById(R.id.textView_contentstar);
        img_imgstar = findViewById(R.id.imageView_imgstar);

        // 3)接受数据
        String str1 = getIntent().getStringExtra("name");
        int my_year = getIntent().getIntExtra("year", 0);
        int my_month = getIntent().getIntExtra("month", 0);
        my_month += 1;
        int my_day = getIntent().getIntExtra("day", 0);
        txt_getname.setText("Hi!  " + str1);
        txt_getbirth.setText("你的出生日期为：" + my_year + "年" + my_month + "月" + my_day + "日");
        int[] imgarr = {R.drawable.baiyang, R.drawable.jinniu, R.drawable.shuangzi, R.drawable.juxie, R.drawable.shizi, R.drawable.chunv, R.drawable.tiancheng, R.drawable.tianxie, R.drawable.sheshou, R.drawable.mojie, R.drawable.shuiping, R.drawable.shuangyu};
        int[] contentarr = {R.string.白羊座, R.string.金牛座, R.string.双子座, R.string.巨蟹座, R.string.狮子座, R.string.处女座, R.string.天枰座, R.string.天蝎座, R.string.射手座, R.string.摩羯座, R.string.水瓶座, R.string.双鱼座};

        int i = find(my_month, my_day);
        img_imgstar.setImageResource(imgarr[i]);
        txt_contentstar.setText(contentarr[i]);
    }

    private int find(int mymonth, int myday) {
        int i = 0;
        if (mymonth == 3 && myday >= 21 || mymonth == 4 && myday <= 19) {
            i = 0;
        }
        if (mymonth == 4 && myday >= 20 || mymonth == 5 && myday <= 20) {
            i = 1;
        }
        if ((mymonth == 5 && myday >= 21) || mymonth == 6 && myday <= 21) {
            i = 2;
        }

        if ((mymonth == 6 && myday >= 22) || mymonth == 7 && myday <= 22) {
            i = 3;
        }
        if ((mymonth == 7 && myday >= 23) || mymonth == 8 && myday <= 22) {
            i = 4;
        }
        if ((mymonth == 8 && myday >= 23) || mymonth == 9 && myday <= 22) {
            i = 5;
        }

        if ((mymonth == 9 && myday >= 23) || mymonth == 10 && myday <= 23) {
            i = 6;
        }
        if ((mymonth == 10 && myday >= 24) || mymonth == 11 && myday <= 22) {
            i = 7;
        }
        if ((mymonth == 11 && myday >= 23) || mymonth == 12 && myday <= 21) {
            i = 8;
        }

        if ((mymonth == 12 && myday >= 22) || mymonth == 1 && myday <= 19) {
            i = 9;
        }
        if ((mymonth == 1 && myday >= 20) || mymonth == 2 && myday <= 18) {
            i = 10;
        }
        if ((mymonth == 2 && myday >= 19) || mymonth == 3 && myday <= 20) {
            i = 11;
        }
        return i;
    }
}
