package com.example.my_app3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int i = 0; // 记录打到地鼠的个数
    private ImageView mouse; // 定义mouse对象
    private Handler handler; // 声明一个Handler对象
    private TextView info1; // 方便获取洞穴位置
    // 地鼠位置的坐标
    public int[][] position = new int[][]{
            {362, 360}, {775, 369}, {1217, 378},
            {305, 551}, {770, 554}, {1237, 572},
            {296, 774}, {787, 793}, {1246, 789},
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 设置不显示顶部栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // 设置横屏显示
//        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
        // 绑定控件
        mouse = findViewById(R.id.imageView_1);
        info1 = findViewById(R.id.info_h);
        // 获取洞穴位置
        info1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        float x = event.getRawX();
                        float y = event.getRawY();
                        Log.i("x:" + x, "y:" + y);
                        break;
                    default:
                        break;
                }
                return false;
            }
        });


        // 实现地鼠的随机出现
        // 创建Handler消息处理机制
        handler = new Handler() {
            @Override
            public void handleMessage(@NonNull Message msg) {
                // 需要处理的消息
                int index;
                if (msg.what == 0x101) {
                    index = msg.arg1; // 获取位置索引值
                    mouse.setX(position[index][0]); // 设置X轴
                    mouse.setY(position[index][0]); // 设置Y轴
                    mouse.setVisibility(View.VISIBLE);
                }
                super.handleMessage(msg);
            }
        };
        // 创建线程
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                int index = 0;
                while (!Thread.currentThread().isInterrupted()) {
                    index = new Random().nextInt(position.length);//(产生一个随机整数范围0<=数组长度)
                    Message m = handler.obtainMessage(); // 创建对象
                    m.what = 0x101; // 设置消息标志
                    m.arg1 = index; // 保存地鼠位置的索引值
                    handler.sendMessage(m); // 发送消息通知Handler处理
                    try {
                        Thread.sleep(new Random().nextInt(500) + 500); // 休眠一段时间
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t.start();
        // 设置点击到地鼠后的方法
        mouse.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                v.setVisibility(View.INVISIBLE); // 设置地鼠不显示
                i++;
                Toast.makeText(MainActivity.this, "打到 " + i + " 只地鼠！", Toast.LENGTH_LONG).show();

                return false;
            }
        });
    }
}
