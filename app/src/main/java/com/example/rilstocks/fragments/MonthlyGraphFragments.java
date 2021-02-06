package com.example.rilstocks.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rilstocks.R;
import com.example.rilstocks.model.DailyStocksCandleModel;
import com.example.rilstocks.utils.AppUtils;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MonthlyGraphFragments extends Fragment {

    LineChart daily_lc;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_daily_graph, container, false);
        daily_lc = view.findViewById(R.id.daily_lc);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initGraph();
        String jsonData = AppUtils.loadJSONFromAsset("reliance_candle_monthly.json",getContext());
        DailyStocksCandleModel dailyStocksData = new Gson().fromJson(jsonData, DailyStocksCandleModel.class);
        setDailyChartData(dailyStocksData);
    }

    private void setDailyChartData(DailyStocksCandleModel dailyStocksData) {
        List<Entry> entries = new ArrayList<>();
        List<List<Float>> entryVal  = dailyStocksData.getCandles();
        for(List<Float> data :entryVal){
            if(data.get(0) != null && data.get(2) != null){
                Entry entry = new Entry(data.get(0),data.get(2));
                entries.add(entry);
            }
        }
        LineDataSet dataset = new LineDataSet(entries, "Unused label");
        dataset.setColor(getResources().getColor(R.color.green));
        dataset.setValueTextColor(getResources().getColor(R.color.green));
        dataset.setHighLightColor(getResources().getColor(R.color.green));
        dataset.setDrawValues(false);
        dataset.setDrawCircleHole(false);
        dataset.setDrawCircles(false);
        dataset.setLineWidth(2f);
        dataset.setHighlightEnabled(false);
        dataset.setDrawHighlightIndicators(false);
        daily_lc.setData(new LineData(dataset));
        daily_lc.invalidate();
    }

    private void initGraph() {
        daily_lc.getAxisLeft().setEnabled(false);
        daily_lc.getAxisRight().setEnabled(false);
        daily_lc.getXAxis().setEnabled(false);
        daily_lc.getLegend().setEnabled(false);
        daily_lc.getDescription().setEnabled(false);
        daily_lc.setTouchEnabled(true);
        daily_lc.setDragEnabled(true);
        daily_lc.setScaleEnabled(false);
        daily_lc.setViewPortOffsets(0f, 0f, 0f, 0f);
        daily_lc.getAxisLeft().setDrawAxisLine(false);
        daily_lc.getAxisRight().setDrawAxisLine(false);
        daily_lc.setPinchZoom(false);
    }
}
