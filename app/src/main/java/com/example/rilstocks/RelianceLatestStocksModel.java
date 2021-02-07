package com.example.rilstocks;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RelianceLatestStocksModel {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("symbol")
    @Expose
    private String symbol;
    @SerializedName("open")
    @Expose
    private Double open;
    @SerializedName("high")
    @Expose
    private Integer high;
    @SerializedName("low")
    @Expose
    private Double low;
    @SerializedName("close")
    @Expose
    private Double close;
    @SerializedName("ltp")
    @Expose
    private Double ltp;
    @SerializedName("volume")
    @Expose
    private Integer volume;
    @SerializedName("tsInMillis")
    @Expose
    private Integer tsInMillis;
    @SerializedName("lowPriceRange")
    @Expose
    private Double lowPriceRange;
    @SerializedName("highPriceRange")
    @Expose
    private Double highPriceRange;
    @SerializedName("totalBuyQty")
    @Expose
    private Integer totalBuyQty;
    @SerializedName("totalSellQty")
    @Expose
    private Integer totalSellQty;
    @SerializedName("dayChange")
    @Expose
    private Double dayChange;
    @SerializedName("dayChangePerc")
    @Expose
    private Double dayChangePerc;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Double getOpen() {
        return open;
    }

    public void setOpen(Double open) {
        this.open = open;
    }

    public Integer getHigh() {
        return high;
    }

    public void setHigh(Integer high) {
        this.high = high;
    }

    public Double getLow() {
        return low;
    }

    public void setLow(Double low) {
        this.low = low;
    }

    public Double getClose() {
        return close;
    }

    public void setClose(Double close) {
        this.close = close;
    }

    public Double getLtp() {
        return ltp;
    }

    public void setLtp(Double ltp) {
        this.ltp = ltp;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public Integer getTsInMillis() {
        return tsInMillis;
    }

    public void setTsInMillis(Integer tsInMillis) {
        this.tsInMillis = tsInMillis;
    }

    public Double getLowPriceRange() {
        return lowPriceRange;
    }

    public void setLowPriceRange(Double lowPriceRange) {
        this.lowPriceRange = lowPriceRange;
    }

    public Double getHighPriceRange() {
        return highPriceRange;
    }

    public void setHighPriceRange(Double highPriceRange) {
        this.highPriceRange = highPriceRange;
    }

    public Integer getTotalBuyQty() {
        return totalBuyQty;
    }

    public void setTotalBuyQty(Integer totalBuyQty) {
        this.totalBuyQty = totalBuyQty;
    }

    public Integer getTotalSellQty() {
        return totalSellQty;
    }

    public void setTotalSellQty(Integer totalSellQty) {
        this.totalSellQty = totalSellQty;
    }

    public Double getDayChange() {
        return dayChange;
    }

    public void setDayChange(Double dayChange) {
        this.dayChange = dayChange;
    }

    public Double getDayChangePerc() {
        return dayChangePerc;
    }

    public void setDayChangePerc(Double dayChangePerc) {
        this.dayChangePerc = dayChangePerc;
    }
}
