package com.example.rilstocks.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StocksData {

    @SerializedName("records")
    @Expose
    private List<Record> records = null;
    @SerializedName("totalRecords")
    @Expose
    private Integer totalRecords;

    public List<Record> getRecords() {
        return records;
    }

    public void setRecords(List<Record> records) {
        this.records = records;
    }

    public Integer getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(Integer totalRecords) {
        this.totalRecords = totalRecords;
    }
}
