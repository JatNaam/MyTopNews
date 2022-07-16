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

public class SpFragment extends Fragment {

    private final List<News> newsList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sp_frag, container, false);
        initNews();
        RecyclerView newsListRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewForNewsList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        newsListRecyclerView.setLayoutManager(layoutManager);
        NewsAdapter adapter = new NewsAdapter(newsList);
        newsListRecyclerView.setAdapter(adapter);
        return view;
    }

    private void initNews() {
        News news1 = new News(R.drawable.pic_sport1,
                "美国高尔夫球大师赛：舍夫勒首次夺冠 “老虎”伍兹名列第47（配文）",
                "cnsphoto.com",
                "2022-04-11 18:56",
                "http://www.cnsphoto.com/newDetail/single/12036144?pictureId=31149256");
        newsList.add(news1);
        News news2 = new News(R.drawable.pic_sport2,
                "2022 F1澳大利亚大奖赛：勒克莱尔夺冠 周冠宇列第11名",
                "cnsphoto.com",
                "2022-04-10 21:39",
                "http://www.cnsphoto.com/newDetail/single/12034696?pictureId=31133514");
        newsList.add(news2);
        News news3 = new News(R.drawable.pic_sport3,
                "第十三届亚运会：中国女子体操队获得团体金牌",
                "cnsphoto.com",
                "2022-04-10 17:51",
                "http://www.cnsphoto.com/newDetail/single/11996892?pictureId=30817554");
        newsList.add(news3);
        News news4 = new News(R.drawable.pic_sport4,
                "浙江农林大学：志愿者学礼仪迎亚运",
                "cnsphoto.com",
                "2022-04-10 16:04",
                "http://www.cnsphoto.com/newDetail/single/12034156?pictureId=31128478");
        newsList.add(news4);
        News news5 = new News(R.drawable.pic_sport5,
                "2022年浙江省青少年武术（套路、散打）锦标赛甲组比赛举行",
                "cnsphoto.com",
                "2022-04-09 15:20",
                "http://www.cnsphoto.com/newDetail/single/12033152?pictureId=31119428");
        newsList.add(news5);
        News news6 = new News(R.drawable.pic_sport6,
                "中国车手周冠宇征战F1澳大利亚大奖赛",
                "cnsphoto.com",
                "2022-04-08 17:51",
                "http://www.cnsphoto.com/newDetail/single/12031950?pictureId=31109186");
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



