package com.example.mytopnews.Content;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mytopnews.R;
import com.example.mytopnews.WebActivity;

import java.util.List;

public  class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    private final List<News> mNewsList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        View newsView;
        ImageView newsImage;
        TextView newsTitle, newsURL, newsTime;

        public ViewHolder(View view) {
            super(view);
            newsView = view;
            newsImage = (ImageView) view.findViewById(R.id.newsImage);
            newsTitle = (TextView) view.findViewById(R.id.newsTitle);
            newsURL = (TextView) view.findViewById(R.id.newsURL);
            newsTime = (TextView) view.findViewById(R.id.newsTime);
        }
    }

    public NewsAdapter(List<News> newsList) {
        mNewsList = newsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // 用于创建一个ViewHolder实例，将news_item布局加载进来。
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        // 给recycleView的item绑定点击事件
        holder.newsView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                News news = mNewsList.get(position);
                Intent intent;
                // 奇数item使用WebView打开，偶数item使用手机浏览器打开
                if (position % 2 == 0) {
                    //隐式intent，使用手机浏览器打开
                    intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(news.getURL()));
                } else {
                    //显式intent，使用WebView控件打开
                    intent = new Intent(v.getContext(), WebActivity.class);
                    String data = news.getURL();
                    intent.putExtra("extra_data", data);
                }
                v.getContext().startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // 用于对RecyclerView子项的数据进行赋值，会在每个子项滚动到屏幕内的时候执行，
        // 这里我们通过position参数得到当前项的News实例，然后再将数据设置到ViewHolder的控件中
        News news = mNewsList.get(position);
        holder.newsImage.setImageResource(news.getImageId());
        holder.newsTitle.setText(news.getNewsTitle());
        holder.newsURL.setText(news.getNewsURL());
        holder.newsTime.setText(news.getNewsTime());
    }

    @Override
    public int getItemCount() {
        return mNewsList.size();
    }
}
