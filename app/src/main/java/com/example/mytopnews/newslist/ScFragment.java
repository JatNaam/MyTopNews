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

public class ScFragment extends Fragment {

    private final List<News> newsList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sc_frag, container, false);
        initNews();
        RecyclerView newsListRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewForNewsList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        newsListRecyclerView.setLayoutManager(layoutManager);
        NewsAdapter adapter = new NewsAdapter(newsList);
        newsListRecyclerView.setAdapter(adapter);
        return view;
    }

    private void initNews() {
        News news1 = new News(R.drawable.pic_science1,
                "南京玄武湖畔繁花满枝“倾泻”而下似“瀑布”",
                "cnsphoto.com",
                "2022-04-11 20:20",
                "http://www.cnsphoto.com/newDetail/single/12036320?pictureId=31150656");
        newsList.add(news1);
        News news2 = new News(R.drawable.pic_science2,
                "广西融安：云雾绕城景色美",
                "cnsphoto.com",
                "2022-04-11 19:28",
                "http://www.cnsphoto.com/newDetail/single/12036052?pictureId=31148328");
        newsList.add(news2);
        News news3 = new News(R.drawable.pic_science3,
                "河北邯郸：春燕衔泥生态美",
                "cnsphoto.com",
                "2022-04-11 19:26",
                "http://www.cnsphoto.com/newDetail/single/12036078?pictureId=31148836");
        newsList.add(news3);
        News news4 = new News(R.drawable.pic_science4,
                "青海西宁遭遇沙尘天气",
                "cnsphoto.com",
                "2022-04-11 19:00",
                "http://www.cnsphoto.com/newDetail/single/12036168?pictureId=31149360");
        newsList.add(news4);
        News news5 = new News(R.drawable.pic_science5,
                "河南许昌：城水相依 风景迷人",
                "cnsphoto.com",
                "2022-04-11 18:53",
                "http://www.cnsphoto.com/newDetail/single/12036046?pictureId=31148482");
        newsList.add(news5);
        News news6 = new News(R.drawable.pic_science6,
                "浙江三门：油菜花开醉游人",
                "cnsphoto.com",
                "2022-04-11 18:51",
                "http://www.cnsphoto.com/newDetail/single/12036060?pictureId=31148740");
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



