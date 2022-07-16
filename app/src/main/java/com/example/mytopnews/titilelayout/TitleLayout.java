package com.example.mytopnews.titilelayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.mytopnews.MainActivity;
import com.example.mytopnews.R;

import java.util.ArrayList;
import java.util.List;

public class TitleLayout extends LinearLayout {

    private final List<NewsType> newsTypeList = new ArrayList<>();

    public TitleLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.title, this);

        initNewsType();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerViewForTitle);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context); //将RecyclerView指定为LinerLayout布局（线性）
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL); //将布局设为横向排列
        recyclerView.setLayoutManager(layoutManager);

        NewsTypeAdapter adapter = new NewsTypeAdapter(newsTypeList);
        recyclerView.setAdapter(adapter);
    }

    private void initNewsType() {
        NewsType business = new NewsType("Business", R.drawable.tab_business);
        newsTypeList.add(business);
        NewsType entertainment = new NewsType("Entertainment", R.drawable.tab_entertainment);
        newsTypeList.add(entertainment);
        NewsType health = new NewsType("Health", R.drawable.tab_health);
        newsTypeList.add(health);
        NewsType science = new NewsType("Science", R.drawable.tab_science);
        newsTypeList.add(science);
        NewsType sport = new NewsType("Sport", R.drawable.tab_sport);
        newsTypeList.add(sport);
    }

    class NewsTypeAdapter extends RecyclerView.Adapter<NewsTypeAdapter.ViewHolder> {

        private final List<NewsType> mNewsTypeList;

        class ViewHolder extends RecyclerView.ViewHolder {
            View newsType;
            ImageView newsTypeImage;
            TextView newsTypeName;

            public ViewHolder(View view) {
                super(view);
                newsType = view;
                newsTypeImage = (ImageView) view.findViewById(R.id.newsTypeImage);
                newsTypeName = (TextView) view.findViewById(R.id.newsTypeName);
            }
        }

        public NewsTypeAdapter(List<NewsType> newsTypeList) {
            mNewsTypeList = newsTypeList;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            // 用于创建一个ViewHolder实例，将news_type_item布局加载进来。
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_type_item, parent, false);
            final ViewHolder holder = new ViewHolder(view);

            holder.newsType.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = holder.getAdapterPosition();
                    MainActivity mainActivity = (MainActivity) getContext();//与主活动通信
                    NewsType newsType = mNewsTypeList.get(position);
                    switch (newsType.getName()) {
                        case "Business":
//                            Toast.makeText(view.getContext(),
//                                    "你点击的是：" + newsType.getName(), Toast.LENGTH_LONG).show();
                            mainActivity.refresh(1);
                            break;
                        case "Entertainment":
//                            Toast.makeText(view.getContext(),
//                                    "你点击的是：" + newsType.getName(), Toast.LENGTH_LONG).show();
                            mainActivity.refresh(2);
                            break;
                        case "Health":
//                            Toast.makeText(view.getContext(),
//                                    "你点击的是：" + newsType.getName(), Toast.LENGTH_LONG).show();
                            mainActivity.refresh(3);
                            break;
                        case "Science":
//                            Toast.makeText(view.getContext(),
//                                    "你点击的是：" + newsType.getName(), Toast.LENGTH_LONG).show();
                            mainActivity.refresh(4);
                            break;
                        case "Sport":
//                            Toast.makeText(view.getContext(),
//                                    "你点击的是：" + newsType.getName(), Toast.LENGTH_LONG).show();
                            mainActivity.refresh(5);
                            break;
                        default:
                            break;
                    }
                }
            });

            return holder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            //用于对RecyclerView子项的数据进行赋值，会在每个子项滚动到屏幕内的时候执行，
            //这里我们通过position参数得到当前项的newType实例，然后再将数据设置到ViewHolder的控件中
            NewsType newsType = mNewsTypeList.get(position);
            holder.newsTypeImage.setImageResource(newsType.getImageId());
            holder.newsTypeName.setText(newsType.getName());
        }

        @Override
        public int getItemCount() {
            return mNewsTypeList.size();
        }

    }
}
