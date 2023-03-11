package com.example.mytopnews.Tab;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.example.mytopnews.Content.ContentFragment;

public class NewsTypeStateAdapter extends FragmentStateAdapter {
    /**
     * 因为fragment必须要依赖于Activity才可以使用，所以需要一个Avtivity的对象
     */
    public NewsTypeStateAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }
    /**
     * 动态创建fragment，滑动切换页面就是通过这个方法来实现页面变化的
     */
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return ContentFragment.newInstance(position);
    }
    /**
     * TabLayout有5个tab，所以Viewpager2的item也对应有5个
     */
    @Override
    public int getItemCount() {
        return 5;
    }
}