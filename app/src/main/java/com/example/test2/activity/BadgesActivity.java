package com.example.test2.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.test2.R;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.badge.BadgeUtils;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
public class BadgesActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private BadgeDrawable badgeDrawable;
    private int count = 0; // 将count声明为类成员变量

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_badges);

        FloatingActionButton btn1 = findViewById(R.id.button1);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        btn1.post(new Runnable() {
            @Override
            public void run() {
                showBadge();
            }
        });

//        showBadge();



        // 在按钮点击事件中更新Badge数量
        btn1.setOnClickListener(view -> {
            count++;
            showBadge(); // 更新Badge显示的数量
        });
    }

    @SuppressLint("UnsafeOptInUsageError")
    private void showBadge() {
        FloatingActionButton btn1 = findViewById(R.id.button1);
        badgeDrawable = BadgeDrawable.create(this);
        badgeDrawable.setNumber(count); // 使用更新后的count值来设置Badge的数量
        badgeDrawable.setBackgroundColor(ContextCompat.getColor(this, R.color.red));
        badgeDrawable.setBadgeTextColor(ContextCompat.getColor(this, R.color.white));
        badgeDrawable.setVerticalOffset(20);
        badgeDrawable.setHorizontalOffset(8);
//        badgeDrawable.setBadgeGravity(BadgeDrawable.TOP_START);

        BadgeUtils.attachBadgeDrawable(badgeDrawable, btn1, null);
//        BadgeUtils.attachBadgeDrawable(badgeDrawable,toolbar,R.menu.menu_item);
    }

    @SuppressLint("UnsafeOptInUsageError")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem notificationMenuItem = menu.findItem(R.id.action_notification);
        MenuItem notificationMenuItem1 = menu.findItem(R.id.action_notification1);
        MenuItem notificationMenuItem2 = menu.findItem(R.id.action_notification2);

        // 为每个 MenuItem 创建独立的 BadgeDrawable 实例
        BadgeDrawable badgeDrawable1 = BadgeDrawable.create(this);
        badgeDrawable1.setNumber(42);
        badgeDrawable1.setVerticalOffset(20);
        badgeDrawable1.setHorizontalOffset(8);
        BadgeUtils.attachBadgeDrawable(badgeDrawable1, toolbar, notificationMenuItem.getItemId());

        BadgeDrawable badgeDrawable2 = BadgeDrawable.create(this);
        badgeDrawable2.setNumber(44);
        badgeDrawable2.setVerticalOffset(20);
        badgeDrawable2.setHorizontalOffset(8);
        BadgeUtils.attachBadgeDrawable(badgeDrawable2, toolbar, notificationMenuItem1.getItemId());

        BadgeDrawable badgeDrawable3 = BadgeDrawable.create(this);
        badgeDrawable3.setNumber(1000);
        badgeDrawable3.setVerticalOffset(20);
        badgeDrawable3.setHorizontalOffset(8);
        BadgeUtils.attachBadgeDrawable(badgeDrawable3, toolbar, notificationMenuItem2.getItemId());

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        // 处理 Toolbar 上的 MenuItem 点击事件
        return super.onOptionsItemSelected(item);
    }
}
