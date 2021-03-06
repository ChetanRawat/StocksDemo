package com.example.rilstocks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.rilstocks.model.MarketUiData;
import com.example.rilstocks.model.Record;
import com.example.rilstocks.model.StocksData;
import com.example.rilstocks.utils.AppUtils;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView tv_market_filter;
    RecyclerView rv_stocks;
    private int clickCount = 1;
    List<MarketUiData> marketData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_market_filter = findViewById(R.id.tv_market_filter);
        tv_market_filter.setTag(1);
        rv_stocks = findViewById(R.id.rv_stocks);
        String jsondata = AppUtils.loadJSONFromAsset("all_stocks.json",this);
        StocksData stocksData = new Gson().fromJson(jsondata,StocksData.class);
        marketData = getMarketData(stocksData.getRecords(),1);
        StockListAdapter adapter = new StockListAdapter(marketData,MainActivity.this);
        rv_stocks.setHasFixedSize(true);
        rv_stocks.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        rv_stocks.setAdapter(adapter);
        tv_market_filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(clickCount == 5){
                    clickCount = 1;
                }
                tv_market_filter.setText(getTextFromCount(clickCount));
                List<MarketUiData> refreshData = getMarketData(stocksData.getRecords(),clickCount);
                marketData.clear();
                marketData.addAll(refreshData);
                rv_stocks.getAdapter().notifyDataSetChanged();
                clickCount +=1;
            }
        });
    }

    private String getTextFromCount(int clickCount) {
        String tvName = "";
        if(clickCount ==1){
            tvName = "Market Price";
        }else if(clickCount ==2){
            tvName = "52w High";
        }else if(clickCount ==3){
            tvName = "52w Low";
        }else if(clickCount ==4){
            tvName = "Market Cap (Cr)";
        }
        return tvName;
    }

    private List<MarketUiData> getMarketData(List<Record> records,int filterId) {
        List<MarketUiData> marketDataList = new ArrayList<>();
        for(Record data:records){
            MarketUiData marketData  = new MarketUiData();
            marketData.setCompanyName(data.getCompanyShortName());
            if(filterId == 1){
                marketData.setDisplayVal1(""+data.getLivePriceDto().getLtp());
                marketData.setDisplayVal2(data.getLivePriceDto().getDayChange());
                marketData.setPercentageChange(data.getLivePriceDto().getDayChangePerc());
            }else if(filterId == 2){
                marketData.setDisplayVal1(""+data.getYearlyHighPrice());
            }else if(filterId == 3){
                marketData.setDisplayVal1(""+data.getYearlyLowPrice());
            }else if(filterId == 4){
                marketData.setDisplayVal1(""+getCapDataInCr(data.getMarketCap()));
            }
            marketDataList.add(marketData);
        }
        return marketDataList;
    }

    private BigDecimal getCapDataInCr(BigDecimal marketCap) {
        BigDecimal amt = marketCap.divide(new BigDecimal(1000000000));
        return amt.setScale(2, RoundingMode.HALF_UP);
    }
}