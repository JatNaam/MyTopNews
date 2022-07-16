package com.example.mytopnews.newslist;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mytopnews.News;
import com.example.mytopnews.R;
import com.example.mytopnews.Web;

import java.util.ArrayList;
import java.util.List;

public class EFragment extends Fragment {

    private final List<News> newsList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.e_frag, container, false);
        initNews();
        RecyclerView newsListRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewForNewsList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        newsListRecyclerView.setLayoutManager(layoutManager);
        NewsAdapter adapter = new NewsAdapter(newsList);
        newsListRecyclerView.setAdapter(adapter);
        return view;
    }

    private void initNews() {
        News news1 = new News(R.drawable.pic_entertainmet1,
                "天津自然博物馆",
                "cnsphoto.com",
                "2022-04-08 10:14",
                "http://www.cnsphoto.com/newDetail/single/12003176?pictureId=30869244");
        newsList.add(news1);
        News news2 = new News(R.drawable.pic_entertainmet2,
                "河北涿州：大漆髹饰技艺焕发新活力",
                "cnsphoto.com",
                "2022-04-08 09:43",
                "http://www.cnsphoto.com/newDetail/single/12031338?pictureId=31103344");
        newsList.add(news2);
        News news3 = new News(R.drawable.pic_entertainmet3,
                "安徽肥东：文化场馆建设忙",
                "cnsphoto.com",
                "2022-04-07 21:09",
                "http://www.cnsphoto.com/newDetail/single/12031098?pictureId=31102000");
        newsList.add(news3);
        News news4 = new News(R.drawable.pic_entertainmet4,
                "河北涿鹿：晋剧《劈山大渠》创排进行时",
                "cnsphoto.com",
                "2022-04-07 15:45",
                "http://www.cnsphoto.com/newDetail/single/12030522?pictureId=31097590");
        newsList.add(news4);
        News news5 = new News(R.drawable.pic_entertainmet5,
                "中国摄影报举办“大熊猫与自然”雅安摄影展在线新闻发布会",
                "cnsphoto.com",
                "2022-04-06 17:33",
                "http://www.cnsphoto.com/newDetail/single/12029506?pictureId=31089608");
        newsList.add(news5);
        News news6 = new News(R.drawable.pic_entertainmet6,
                "民众清明假期参观中国共产党历史展览馆",
                "cnsphoto.com",
                "2022-04-05 21:21",
                "http://www.cnsphoto.com/newDetail/single/12028706?pictureId=31083246");
        newsList.add(news6);
    }

    static class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
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
            holder.newsView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = holder.getAdapterPosition();
                    News news = mNewsList.get(position);
                    Intent intent;
                    if (position % 2 == 0) {
                        intent = new Intent(Intent.ACTION_VIEW);//隐式intent，使用Android自带浏览器打开
                        intent.setData(Uri.parse(news.getURL()));
                    } else {
                        intent = new Intent(v.getContext(), Web.class);//显式intent，使用内置浏览器WebView打开
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
            //用于对RecyclerView子项的数据进行赋值，会在每个子项滚动到屏幕内的时候执行，
            //这里我们通过position参数得到当前项的News实例，然后再将数据设置到ViewHolder的控件中
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
}



