package com.example.rilstocks.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DailyStocksCandleModel {

    @SerializedName("candles")
    @Expose
    private List<List<Float>> candles = null;
    @SerializedName("changeValue")
    @Expose
    private Object changeValue;
    @SerializedName("changePerc")
    @Expose
    private Object changePerc;

    public List<List<Float>> getCandles() {
        return candles;
    }

    public void setCandles(List<List<Float>> candles) {
        this.candles = candles;
    }

    public Object getChangeValue() {
        return changeValue;
    }

    public void setChangeValue(Object changeValue) {
        this.changeValue = changeValue;
    }

    public Object getChangePerc() {
        return changePerc;
    }

    public void setChangePerc(Object changePerc) {
        this.changePerc = changePerc;
    }

}
