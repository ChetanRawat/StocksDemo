package com.example.rilstocks;

import android.content.Context;
import android.widget.TextView;

import com.github.mikephil.charting.components.MarkerView;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ChartMarker extends MarkerView {

    TextView tv_point_val;
    public ChartMarker(Context context, int layoutResource) {
        super(context, layoutResource);
        tv_point_val = findViewById(R.id.tv_point_val);
    }

    @Override
    public void refreshContent(Entry e, Highlight highlight) {
        tv_point_val.setText(getFormatedText(e));
        super.refreshContent(e, highlight);
    }

    private String getFormatedText(Entry e) {
        String value = getResources().getString(R.string.rupees)+e.getY()+"|"+getTime(e.getX());
        return value;
    }

    private String getTime(float x) {
        SimpleDateFormat formatter = new SimpleDateFormat("h:mm a");
        String dateString = formatter.format(new Date((long)x));
        return dateString;
    }
}
