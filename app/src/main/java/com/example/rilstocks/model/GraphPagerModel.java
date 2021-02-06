package com.example.rilstocks.model;

import com.example.rilstocks.R;

public enum GraphPagerModel {

    ONE(R.string.one_day,R.layout.fragment_daily_graph),
    TWO(R.string.one_week, R.layout.fragment_daily_graph),
    THREE(R.string.one_month,R.layout.fragment_daily_graph),
    FOUR(R.string.one_year, R.layout.fragment_daily_graph),
    FIVE(R.string.three_year, R.layout.fragment_daily_graph),
    SIX(R.string.five_year, R.layout.fragment_daily_graph);

    private int mTitleResId;
    private int mLayoutResId;

    GraphPagerModel(int titleResId, int layoutResId) {
        mTitleResId = titleResId;
        mLayoutResId = layoutResId;
    }

    public int getTitleResId() {
        return mTitleResId;
    }

    public int getLayoutResId() {
        return mLayoutResId;
    }
}
