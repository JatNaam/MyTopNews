package com.example.mytopnews;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.example.mytopnews.Tab.NewsTypeStateAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.Business, R.string.Entertainment,
            R.string.Health, R.string.Science, R.string.Sport,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*将UI与系统状态栏融合*/
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        getWindow().setStatusBarColor(Color.TRANSPARENT);

        drawerLayout = findViewById(R.id.drawerLayout);

        Toolbar toolbar = findViewById(R.id.Toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        //获取ActionBar的实例，这个ActionBar的具体实现是由Toolbar完成的
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);//显示导航按钮
            //实际上Toolbar最左侧的这个按钮叫做"Home按钮"，默认图标是一个返回箭头，含义是返回上一个Activity
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);//给导航按钮重新设置图标
        }

        /*ViewPager2的使用，实现滑动切换UI*/
        // 从布局文件挂载TabLayout和ViewPager2
        ViewPager2 viewPager2 = findViewById(R.id.view_pager);
        TabLayout tabs = findViewById(R.id.tabs);
        // 创建Viewpager2的Adapter对象
        NewsTypeStateAdapter newsTypeStateAdapter = new NewsTypeStateAdapter(this);
        // 使用Adapter对象
        viewPager2.setAdapter(newsTypeStateAdapter);
        // 将TabLayout和Viewpager2联合
        new TabLayoutMediator(tabs,viewPager2,new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                // 从xml文件中读取数据，在app创建Activity时动态给tab设置Text
                tab.setText(TAB_TITLES[position]);
            }
        }).attach();
        // Objects.requireNonNull()为对tab可能为空的处理，在app创建Activity时动态给tab设置图标
        Objects.requireNonNull(tabs.getTabAt(0)).setIcon(R.drawable.business);
        Objects.requireNonNull(tabs.getTabAt(1)).setIcon(R.drawable.entertainment);
        Objects.requireNonNull(tabs.getTabAt(2)).setIcon(R.drawable.health);
        Objects.requireNonNull(tabs.getTabAt(3)).setIcon(R.drawable.science);
        Objects.requireNonNull(tabs.getTabAt(4)).setIcon(R.drawable.sport);
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