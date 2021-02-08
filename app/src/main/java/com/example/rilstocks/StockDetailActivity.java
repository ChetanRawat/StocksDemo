package com.example.rilstocks;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Switch;
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
import androidx.appcompat.widget.SwitchCompat;
import androidx.viewpager.widget.ViewPager;

public class StockDetailActivity extends AppCompatActivity {

    ViewPager pager_chart;
    TabLayout tab_chart;
    SeekBar sb_performance_low,sb_performance_52w_low;
    TextView tv_low_price,tv_high_price,tv_52w_low_price,tv_52w_high_price,tv_company_gain,tv_company_price;
    TextView tv_nse,tv_bse;
    SwitchCompat sw_company_reg_in;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock_detail);
        pager_chart = findViewById(R.id.pager_chart);
        tab_chart = findViewById(R.id.tab_chart);
        tv_company_gain = findViewById(R.id.tv_company_gain);
        tv_company_price = findViewById(R.id.tv_company_price);
        tv_52w_low_price = findViewById(R.id.tv_52w_low_price);
        tv_52w_high_price = findViewById(R.id.tv_52w_high_price);
        sb_performance_low = findViewById(R.id.sb_performance_low);
        tv_low_price = findViewById(R.id.tv_low_price);
        tv_high_price = findViewById(R.id.tv_high_price);
        sb_performance_52w_low = findViewById(R.id.sb_performance_52w_low);
        sw_company_reg_in = findViewById(R.id.sw_company_reg_in);
        tv_nse = findViewById(R.id.tv_nse);
        tv_bse = findViewById(R.id.tv_bse);
        setupGraphPager();
        String jsonData = AppUtils.loadJSONFromAsset("reliance_stocks_latest_prices.json",this);
        RelianceLatestStocksModel relianceLatestStocksModel = new Gson().fromJson(jsonData, RelianceLatestStocksModel.class);
        tv_company_gain.setText("+"+relianceLatestStocksModel.getDayChange()+"("+ AppUtils.round(relianceLatestStocksModel.getDayChangePerc(),2)+"%)");
        tv_company_price.setText(getResources().getString(R.string.rupees)+" 1,925.80");
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

        sw_company_reg_in.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    tv_bse.setTextColor(getResources().getColor(R.color.green));
                    tv_nse.setTextColor(getResources().getColor(R.color.dark_grey));
                }else{
                    tv_nse.setTextColor(getResources().getColor(R.color.green));
                    tv_bse.setTextColor(getResources().getColor(R.color.dark_grey));
                }
            }
        });

    }

    private void setupGraphPager() {
       GraphAdapter graphAdapter = new GraphAdapter(getSupportFragmentManager(),this);
        pager_chart.setAdapter(graphAdapter);
        tab_chart.setupWithViewPager(pager_chart);
    }
}
