package com.example.mytopnews;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.mytopnews.newslist.BFragment;
import com.example.mytopnews.newslist.EFragment;
import com.example.mytopnews.newslist.HFragment;
import com.example.mytopnews.newslist.ScFragment;
import com.example.mytopnews.newslist.SpFragment;


public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private BFragment bFragment;
    private EFragment eFragment;
    private HFragment hFragment;
    private ScFragment scFragment;
    private SpFragment spFragment;
    int currentPage = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //隐藏自带的菜单栏
//        ActionBar actionbar = getSupportActionBar();
//        if (actionbar != null) {
//            actionbar.hide();
//        }
        drawerLayout = findViewById(R.id.drawerLayout);
        Button titleMenu = (Button) findViewById(R.id.titleMenuButton);
        titleMenu.setOnClickListener(new View.OnClickListener() {
            //点击菜单项显示个人信息
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "You clicked Menu button",
                        Toast.LENGTH_SHORT).show();
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        bFragment=new BFragment();
        fragmentTransaction.add(R.id.newsList,bFragment);
        fragmentTransaction.commit();
    }

    public void refresh(int flag) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (flag == currentPage) {
            fragmentTransaction.commit();
            return;
        }
        hideFragment();
        currentPage = flag;
        switch (flag) {
            case 1:
                if (bFragment != null) {
                    fragmentTransaction.show(bFragment);
                    break;
                }
                bFragment = new BFragment();
                fragmentTransaction.add(R.id.newsList, bFragment);
                break;
            case 2:
                if (eFragment != null) {
                    fragmentTransaction.show(eFragment);
                    break;
                }
                eFragment = new EFragment();
                fragmentTransaction.add(R.id.newsList, eFragment);
                break;
            case 3:
                if (hFragment != null) {
                    fragmentTransaction.show(hFragment);
                    break;
                }
                hFragment = new HFragment();
                fragmentTransaction.add(R.id.newsList, hFragment);
                break;
            case 4:
                if (scFragment != null) {
                    fragmentTransaction.show(scFragment);
                    break;
                }
                scFragment = new ScFragment();
                fragmentTransaction.add(R.id.newsList, scFragment);
                break;
            case 5:
                if (spFragment != null) {
                    fragmentTransaction.show(spFragment);
                    break;
                }
                spFragment = new SpFragment();
                fragmentTransaction.add(R.id.newsList, spFragment);
                break;
            default:
                break;
        }
        //提交事务
        fragmentTransaction.commit();
    }

    public void hideFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (bFragment != null) {
            fragmentTransaction.hide(bFragment);
        }
        if (eFragment != null) {
            fragmentTransaction.hide(eFragment);
        }
        if (hFragment != null) {
            fragmentTransaction.hide(hFragment);
        }
        if (scFragment != null) {
            fragmentTransaction.hide(scFragment);
        }
        if (spFragment != null) {
            fragmentTransaction.hide(spFragment);
        }
        //提交事务
        fragmentTransaction.commit();
    }
}