package com.example.rilstocks;

import android.os.Bundle;
import android.widget.SeekBar;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class StockDetailActivity extends AppCompatActivity {

    LineChart chartView;
    ViewPager pager_chart;
    TabLayout tab_chart;
    SeekBar sb_value;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock_detail);
//        chartView = findViewById(R.id.chartView);
        pager_chart = findViewById(R.id.pager_chart);
        tab_chart = findViewById(R.id.tab_chart);
        sb_value = findViewById(R.id.sb_value);
        setupGraphPager();
//        initChartView();
//        setChartData();
    }

    private void setupGraphPager() {
       GraphAdapter graphAdapter = new GraphAdapter(getSupportFragmentManager(),this);
        // Set the adapter onto the view pager
        pager_chart.setAdapter(graphAdapter);
        tab_chart.setupWithViewPager(pager_chart);
    }

    private void setChartData() {
        List<Entry> entries = new ArrayList<>();
        Entry entry1 = new Entry(1f,1f);
        Entry entry2 = new Entry(2f,2f);
        Entry entry3 = new Entry(3f,3f);
        Entry entry4 = new Entry(4f,4f);
        entries.add(entry1);
        entries.add(entry2);
        entries.add(entry3);
        entries.add(entry4);
        LineDataSet dataset = new LineDataSet(entries, "Unused label");
        dataset.setColor(getResources().getColor(R.color.black));
        dataset.setValueTextColor(getResources().getColor(R.color.black));
        dataset.setHighLightColor(getResources().getColor(R.color.black));
        dataset.setDrawValues(false);
        dataset.setLineWidth(1f);
        dataset.setHighlightEnabled(true);
        dataset.setDrawHighlightIndicators(false);
        chartView.setData(new LineData(dataset));
        chartView.invalidate();
    }

    private void initChartView() {
        chartView.getAxisLeft().setEnabled(false);
        chartView.getAxisLeft().setEnabled(false);
        chartView.getXAxis().setEnabled(false);
        chartView.getLegend().setEnabled(false);
        chartView.getDescription().setEnabled(false);
        chartView.setTouchEnabled(true);
        chartView.setDragEnabled(true);
        chartView.setScaleEnabled(false);
        chartView.setPinchZoom(false);
    }
}
