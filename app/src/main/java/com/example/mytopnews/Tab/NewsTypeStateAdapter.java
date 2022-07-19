package com.example.mytopnews.Tab;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.example.mytopnews.Content.ContentFragment;

public class NewsTypeStateAdapter extends FragmentStateAdapter {

    public NewsTypeStateAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return ContentFragment.newInstance(position);
    }

    @Override
    public int getItemCount() {
        return 5;
    }
}