package com.example.mytopnews.newstypelist;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mytopnews.ContentFragment;
import com.example.mytopnews.R;

import java.util.List;

public class NewsTypeAdapter extends RecyclerView.Adapter<NewsTypeAdapter.ViewHolder> {

    private final List<NewsType> mNewsTypeList;

    private ContentFragment contentFragment;

    static class ViewHolder extends RecyclerView.ViewHolder {
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

    public NewsTypeAdapter(ContentFragment contentFragment, List<NewsType> newsTypeList) {
        this.contentFragment = contentFragment;
        mNewsTypeList = newsTypeList;
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

        holder.newsType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                NewsType newsType = mNewsTypeList.get(position);
                switch (newsType.getName()) {
                    case "Business":
                        contentFragment.refresh(0);
                        break;
                    case "Entertainment":
                        contentFragment.refresh(1);
                        break;
                    case "Health":
                        contentFragment.refresh(2);
                        break;
                    case "Science":
                        contentFragment.refresh(3);
                        break;
                    case "Sport":
                        contentFragment.refresh(4);
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