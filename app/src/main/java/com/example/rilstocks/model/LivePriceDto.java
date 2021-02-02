package com.example.rilstocks.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LivePriceDto {
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("symbol")
    @Expose
    private String symbol;
    @SerializedName("tsInMillis")
    @Expose
    private Integer tsInMillis;
    @SerializedName("open")
    @Expose
    private Double open;
    @SerializedName("high")
    @Expose
    private Double high;
    @SerializedName("low")
    @Expose
    private Double low;
    @SerializedName("close")
    @Expose
    private Double close;
    @SerializedName("ltp")
    @Expose
    private Double ltp;
    @SerializedName("dayChange")
    @Expose
    private Double dayChange;
    @SerializedName("dayChangePerc")
    @Expose
    private Double dayChangePerc;
    @SerializedName("lowPriceRange")
    @Expose
    private Double lowPriceRange;
    @SerializedName("highPriceRange")
    @Expose
    private Double highPriceRange;
    @SerializedName("volume")
    @Expose
    private Integer volume;
    @SerializedName("totalBuyQty")
    @Expose
    private Double totalBuyQty;
    @SerializedName("totalSellQty")
    @Expose
    private Double totalSellQty;

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

    public Integer getTsInMillis() {
        return tsInMillis;
    }

    public void setTsInMillis(Integer tsInMillis) {
        this.tsInMillis = tsInMillis;
    }

    public Double getOpen() {
        return open;
    }

    public void setOpen(Double open) {
        this.open = open;
    }

    public Double getHigh() {
        return high;
    }

    public void setHigh(Double high) {
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

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public Double getTotalBuyQty() {
        return totalBuyQty;
    }

    public void setTotalBuyQty(Double totalBuyQty) {
        this.totalBuyQty = totalBuyQty;
    }

    public Double getTotalSellQty() {
        return totalSellQty;
    }

    public void setTotalSellQty(Double totalSellQty) {
        this.totalSellQty = totalSellQty;
    }
}
