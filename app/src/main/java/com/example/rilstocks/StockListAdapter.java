package com.example.rilstocks;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rilstocks.model.MarketUiData;
import com.example.rilstocks.model.Record;
import com.example.rilstocks.utils.AppUtils;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StockListAdapter extends RecyclerView.Adapter<StockListAdapter.StockViewHolder> {

    List<MarketUiData> marketDataList = new ArrayList<>();
    Context context;


    public StockListAdapter(List<MarketUiData> marketDataList,Context context) {
        this.marketDataList = marketDataList;
        this.context = context;
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
        String rupees = context.getResources().getString(R.string.rupees);
        holder.tv_company_name.setText(marketDataList.get(position).getCompanyName());
        holder.tv_share_price.setText(rupees+marketDataList.get(position).getDisplayVal1());
        if(marketDataList.get(position).getDisplayVal2() != null){
            holder.tv_percent_gain.setVisibility(View.VISIBLE);
            double val = AppUtils.round(marketDataList.get(position).getDisplayVal2(),2);
            double percentChange = AppUtils.round(marketDataList.get(position).getPercentageChange(),2);
            holder.tv_percent_gain.setText(""+val+"("+percentChange+"%)");
            if(val < 0){
                holder.tv_percent_gain.setTextColor(context.getResources().getColor(R.color.red));
            }else{
                holder.tv_percent_gain.setTextColor(context.getResources().getColor(R.color.green));
            }
        }else{
            holder.tv_percent_gain.setVisibility(View.INVISIBLE);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(position == 0){
                    Intent intent = new Intent(context,StockDetailActivity.class);
                    context.startActivity(intent);
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return marketDataList.size();
    }

    public static class StockViewHolder extends RecyclerView.ViewHolder {

        TextView tv_company_name,tv_share_price,tv_percent_gain;
        public StockViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_company_name = itemView.findViewById(R.id.tv_company_name);
            tv_share_price = itemView.findViewById(R.id.tv_share_price);
            tv_percent_gain = itemView.findViewById(R.id.tv_percent_gain);
        }
    }
}
