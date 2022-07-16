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

public class BFragment extends Fragment {

    private final List<News> newsList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.b_frag, container, false);
        initNews();
        RecyclerView newsListRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewForNewsList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        newsListRecyclerView.setLayoutManager(layoutManager);
        NewsAdapter adapter = new NewsAdapter(newsList);
        newsListRecyclerView.setAdapter(adapter);
        return view;
    }

    private void initNews() {
        News news1 = new News(R.drawable.pic_business1,
                "四川仁寿：水稻秧苗管护忙",
                "cnsphoto.com",
                "2022-04-11 19:27:53",
                "http://www.cnsphoto.com/newDetail/single/12036076?pictureId=31148810");
        newsList.add(news1);
        News news2 = new News(R.drawable.pic_business2,
                "今年首季山东签发RCEP原产证2.4万份 数量居中国首位",
                "cnsphoto.com",
                "2022-04-11 18:59:21",
                "http://www.cnsphoto.com/newDetail/single/12036152?pictureId=31149292");
        newsList.add(news2);
        News news3 = new News(R.drawable.pic_business3,
                "河北涿州：梨花飘香春管忙",
                "cnsphoto.com",
                "2022-04-11 18:55:53",
                "http://www.cnsphoto.com/newDetail/single/12036038?pictureId=31148118");
        newsList.add(news3);
        News news4 = new News(R.drawable.pic_business4,
                "3月份中国CPI同比涨1.5% 鲜菜价格上涨17.2%",
                "cnsphoto.com",
                "2022-04-11 18:54:36",
                "http://www.cnsphoto.com/newDetail/single/12036138?pictureId=31149240");
        newsList.add(news4);
        News news5 = new News(R.drawable.pic_business5,
                "香港恒生指数大跌663点",
                "cnsphoto.com",
                "2022-04-11 17:47:52",
                "http://www.cnsphoto.com/newDetail/single/12036014?pictureId=31148072");
        newsList.add(news5);
        News news6 = new News(R.drawable.pic_business6,
                "安徽芜湖：服装企业生产忙",
                "cnsphoto.com",
                "2022-04-11 17:44:23",
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



