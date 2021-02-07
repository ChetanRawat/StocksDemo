package com.example.rilstocks;

import android.content.Context;

import com.example.rilstocks.fragments.DailyGraphFragment;
import com.example.rilstocks.fragments.MonthlyGraphFragments;
import com.example.rilstocks.fragments.ThreeYearGraphCandleFragment;
import com.example.rilstocks.fragments.WeeklyGraphFragment;
import com.example.rilstocks.fragments.YearlyGraphFragment;
import com.example.rilstocks.model.GraphPagerModel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class GraphAdapter extends FragmentPagerAdapter {

    private static int NUM_ITEMS = 6;
    private Context mContext;
    public GraphAdapter(@NonNull FragmentManager fm,Context context) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mContext = context;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new DailyGraphFragment();
            case 1:
                return new WeeklyGraphFragment();
            case 2:
                return new MonthlyGraphFragments();
            case 3:
                return new YearlyGraphFragment();
            case 4:
                return new ThreeYearGraphCandleFragment();
            case 5:
                return new YearlyGraphFragment();
            case 6:
                return new YearlyGraphFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        GraphPagerModel dashboardPagerModel= GraphPagerModel.values()[position];
        return  mContext.getString(dashboardPagerModel.getTitleResId());
    }
}
