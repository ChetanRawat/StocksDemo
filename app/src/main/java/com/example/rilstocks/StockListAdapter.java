package com.example.rilstocks;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rilstocks.model.Record;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StockListAdapter extends RecyclerView.Adapter<StockListAdapter.StockViewHolder> {

    List<Record> records = new ArrayList<>();

    public StockListAdapter(List<Record> listdata) {
        this.records = listdata;
    }

    @NonNull
    @Override
    public StockViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.rv_stock_row, parent, false);
        StockViewHolder viewHolder = new StockViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull StockViewHolder holder, int position) {
//        final MyListData myListData = listdata[position];
        holder.tv_company_name.setText(records.get(position).getCompanyShortName());
        holder.tv_share_price.setText(records.get(position).getMarketCap());
    }

    @Override
    public int getItemCount() {
        return records.size();
    }

    public static class StockViewHolder extends RecyclerView.ViewHolder {

        TextView tv_company_name,tv_share_price;
        public StockViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_company_name = itemView.findViewById(R.id.tv_company_name);
            tv_share_price = itemView.findViewById(R.id.tv_share_price);
        }
    }
}
