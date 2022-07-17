package com.example.mytopnews;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.Toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawerLayout);
        ActionBar actionBar = getSupportActionBar();//获取ActionBar的实例，这个ActionBar的具体实现是由Toolbar完成的
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);//显示导航按钮
            //实际上Toolbar最左侧的这个按钮叫做Home按钮，默认图标是一个返回箭头，含义是返回上一个Activity
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);//给导航按钮重新设置图标
        }
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //处理Toolbar各个按钮的点击事件
        if (item.getItemId() == android.R.id.home) {//Home按钮的id永远都是android.R.id.home
            drawerLayout.openDrawer(GravityCompat.START);
        }
        return true;
    }

}