package com.example.rilstocks.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Record {

    @SerializedName("isin")
    @Expose
    private String isin;
    @SerializedName("companyName")
    @Expose
    private String companyName;
    @SerializedName("companyShortName")
    @Expose
    private String companyShortName;
    @SerializedName("searchId")
    @Expose
    private String searchId;
    @SerializedName("industryCode")
    @Expose
    private Object industryCode;
    @SerializedName("bseScriptCode")
    @Expose
    private Integer bseScriptCode;
    @SerializedName("nseScriptCode")
    @Expose
    private String nseScriptCode;
    @SerializedName("yearlyHighPrice")
    @Expose
    private Double yearlyHighPrice;
    @SerializedName("yearlyLowPrice")
    @Expose
    private Double yearlyLowPrice;
    @SerializedName("closePrice")
    @Expose
    private Double closePrice;
    @SerializedName("marketCap")
    @Expose
    private Long marketCap;
    @SerializedName("livePriceDto")
    @Expose
    private LivePriceDto livePriceDto;

    public String getIsin() {
        return isin;
    }

    public void setIsin(String isin) {
        this.isin = isin;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyShortName() {
        return companyShortName;
    }

    public void setCompanyShortName(String companyShortName) {
        this.companyShortName = companyShortName;
    }

    public String getSearchId() {
        return searchId;
    }

    public void setSearchId(String searchId) {
        this.searchId = searchId;
    }

    public Object getIndustryCode() {
        return industryCode;
    }

    public void setIndustryCode(Object industryCode) {
        this.industryCode = industryCode;
    }

    public Integer getBseScriptCode() {
        return bseScriptCode;
    }

    public void setBseScriptCode(Integer bseScriptCode) {
        this.bseScriptCode = bseScriptCode;
    }

    public String getNseScriptCode() {
        return nseScriptCode;
    }

    public void setNseScriptCode(String nseScriptCode) {
        this.nseScriptCode = nseScriptCode;
    }

    public Double getYearlyHighPrice() {
        return yearlyHighPrice;
    }

    public void setYearlyHighPrice(Double yearlyHighPrice) {
        this.yearlyHighPrice = yearlyHighPrice;
    }

    public Double getYearlyLowPrice() {
        return yearlyLowPrice;
    }

    public void setYearlyLowPrice(Double yearlyLowPrice) {
        this.yearlyLowPrice = yearlyLowPrice;
    }

    public Double getClosePrice() {
        return closePrice;
    }

    public void setClosePrice(Double closePrice) {
        this.closePrice = closePrice;
    }

    public Long getMarketCap() {
        return marketCap;
    }

    public void setMarketCap(Long marketCap) {
        this.marketCap = marketCap;
    }

    public LivePriceDto getLivePriceDto() {
        return livePriceDto;
    }

    public void setLivePriceDto(LivePriceDto livePriceDto) {
        this.livePriceDto = livePriceDto;
    }
}
