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
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
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
        String jsondata = loadJSONFromAsset("all_stocks.json");
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
                marketData.setDisplayVal1(data.getLivePriceDto().getLtp());
                marketData.setDisplayVal2(data.getLivePriceDto().getDayChange());
            }else if(filterId == 2){
                marketData.setDisplayVal1(data.getYearlyHighPrice());
                marketData.setDisplayVal2(null);
            }else if(filterId == 3){
                marketData.setDisplayVal1(data.getYearlyLowPrice());
                marketData.setDisplayVal2(null);
            }else if(filterId == 4){
                marketData.setDisplayVal1(getCapDataInCr(data.getMarketCap()));
                marketData.setDisplayVal2(null);
            }
            marketDataList.add(marketData);
        }
        return marketDataList;
    }

    private Double getCapDataInCr(Long marketCap) {
        Long amt = marketCap/10000000;
        return (double)amt;
    }

    public String loadJSONFromAsset(String fileName) {
        String json = null;
        try {
            InputStream is = getAssets().open(fileName);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}