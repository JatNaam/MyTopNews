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

public class HFragment extends Fragment {

    private final List<News> newsList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.h_frag, container, false);
        initNews();
        RecyclerView newsListRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewForNewsList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        newsListRecyclerView.setLayoutManager(layoutManager);
        NewsAdapter adapter = new NewsAdapter(newsList);
        newsListRecyclerView.setAdapter(adapter);
        return view;
    }

    private void initNews() {
        News news1 = new News(R.drawable.pic_health1,
                "（抗击新冠肺炎）天津增派中医医疗队驰援上海",
                "cnsphoto.com",
                "2022-04-11 16:39",
                "http://www.cnsphoto.com/newDetail/single/12036076?pictureId=31148810");
        newsList.add(news1);
        News news2 = new News(R.drawable.pic_health2,
                "山东枣庄：核酸检测快速有序推进",
                "cnsphoto.com",
                "2022-04-11 16:32",
                "http://www.cnsphoto.com/newDetail/single/12036152?pictureId=31149292");
        newsList.add(news2);
        News news3 = new News(R.drawable.pic_health3,
                "江苏苏州：有序开展核酸检测",
                "cnsphoto.com",
                "2022-04-11 16:28",
                "http://www.cnsphoto.com/newDetail/single/12036038?pictureId=31148118");
        newsList.add(news3);
        News news4 = new News(R.drawable.pic_health4,
                "江苏南通：崇川区开展第9次全员核酸检测",
                "cnsphoto.com",
                ":2022-04-11 15:21",
                "http://www.cnsphoto.com/newDetail/single/12036138?pictureId=31149240");
        newsList.add(news4);
        News news5 = new News(R.drawable.pic_health5,
                "山西盐湖：中小学有序复学复课",
                "cnsphoto.com",
                "2022-04-11 15:04",
                "http://www.cnsphoto.com/newDetail/single/12036014?pictureId=31148072");
        newsList.add(news5);
        News news6 = new News(R.drawable.pic_health6,
                "河南洛阳：共享“城市绿肺”",
                "cnsphoto.com",
                "2022-04-11 14:59",
                "http://www.cnsphoto.com/newDetail/single/12035932?pictureId=31147532");
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



