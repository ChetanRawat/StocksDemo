package com.example.rilstocks.model;

public class MarketUiData {

    private String companyName;

    private String displayVal1;

    private Double displayVal2;

    private Double percentageChange;

    public Double getPercentageChange() {
        return percentageChange;
    }

    public void setPercentageChange(Double percentageChange) {
        this.percentageChange = percentageChange;
    }

    public String getDisplayVal1() {
        return displayVal1;
    }

    public void setDisplayVal1(String displayVal1) {
        this.displayVal1 = displayVal1;
    }

    public Double getDisplayVal2() {
        return displayVal2;
    }

    public void setDisplayVal2(Double displayVal2) {
        this.displayVal2 = displayVal2;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
