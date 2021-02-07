package com.example.rilstocks;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.rilstocks.model.DailyStocksCandleModel;
import com.example.rilstocks.utils.AppUtils;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.google.android.material.slider.LabelFormatter;
import com.google.android.material.slider.Slider;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.Locale;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class StockDetailActivity extends AppCompatActivity {

    LineChart chartView;
    ViewPager pager_chart;
    TabLayout tab_chart;
    SeekBar sb_performance_low,sb_performance_52w_low;
    TextView tv_low_price,tv_high_price,tv_52w_low_price,tv_52w_high_price,tv_company_gain;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock_detail);
//        chartView = findViewById(R.id.chartView);
        pager_chart = findViewById(R.id.pager_chart);
        tab_chart = findViewById(R.id.tab_chart);
        tv_company_gain = findViewById(R.id.tv_company_gain);
        tv_52w_low_price = findViewById(R.id.tv_52w_low_price);
        tv_52w_high_price = findViewById(R.id.tv_52w_high_price);
        sb_performance_low = findViewById(R.id.sb_performance_low);
        tv_low_price = findViewById(R.id.tv_low_price);
        tv_high_price = findViewById(R.id.tv_high_price);
        sb_performance_52w_low = findViewById(R.id.sb_performance_52w_low);
        setupGraphPager();
        String jsonData = AppUtils.loadJSONFromAsset("reliance_stocks_latest_prices.json",this);
        RelianceLatestStocksModel relianceLatestStocksModel = new Gson().fromJson(jsonData, RelianceLatestStocksModel.class);
        tv_company_gain.setText(relianceLatestStocksModel.getDayChange()+"("+ AppUtils.round(relianceLatestStocksModel.getDayChangePerc(),2)+"%)");

        tv_low_price.setText(getResources().getString(R.string.rupees)+"867.43");
        tv_high_price.setText(getResources().getString(R.string.rupees)+"2369.45");
        tv_52w_low_price.setText(getResources().getString(R.string.rupees)+"867.43");
        tv_52w_high_price.setText(getResources().getString(R.string.rupees)+"2369.45");
        sb_performance_low.setProgress(80);
        sb_performance_52w_low.setProgress(70);
        pager_chart.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });

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
