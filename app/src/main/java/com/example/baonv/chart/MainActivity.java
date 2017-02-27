package com.example.baonv.chart;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private LineChart mChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mChart = (LineChart) findViewById(R.id.mChart);
        setDataChart();
    }

    private void setDataChart() {
        ArrayList<LineDataSet> lines = new ArrayList<LineDataSet>();
        ArrayList<String> labels = new ArrayList<String>();
        for (int i = 0; i < 20; i++) {
            labels.add(defindDate(i));
        }

        //TODO : set data line 1
        ArrayList<Entry> entries1 = new ArrayList<>();
        entries1.add(new Entry(8, 0));
        entries1.add(new Entry(18, 1));
        entries1.add(new Entry(19, 2));
        entries1.add(new Entry(10, 3));
        entries1.add(new Entry(15, 4));
        entries1.add(new Entry(25, 5));
        entries1.add(new Entry(35, 6));
        entries1.add(new Entry(40, 7));
        entries1.add(new Entry(28, 8));
        entries1.add(new Entry(26, 9));
        entries1.add(new Entry(8, 10));
        entries1.add(new Entry(18, 11));
        entries1.add(new Entry(19, 12));
        entries1.add(new Entry(10, 13));
        entries1.add(new Entry(15, 14));
        entries1.add(new Entry(25, 15));
        entries1.add(new Entry(35, 16));
        entries1.add(new Entry(40, 17));
        entries1.add(new Entry(28, 18));
        entries1.add(new Entry(26, 19));
        LineDataSet dataset1 = new LineDataSet(entries1, "Màu đỏ của Bảo");
        dataset1.setColor(Color.RED);
        dataset1.setFillColor(Color.RED);
        dataset1.setCircleColor(Color.RED);
        dataset1.setDrawFilled(false);
        dataset1.setDrawCubic(false);

        //TODO : Cấu hình data đường 2
        ArrayList<Entry> entries2 = new ArrayList<>();
        entries2.add(new Entry(10, 0));
        entries2.add(new Entry(15, 1));
        entries2.add(new Entry(11, 2));
        entries2.add(new Entry(18, 3));
        entries2.add(new Entry(20, 4));
        entries2.add(new Entry(16, 5));
        entries2.add(new Entry(40, 6));
        entries2.add(new Entry(50, 7));
        entries2.add(new Entry(35, 8));
        entries2.add(new Entry(38, 9));
        entries2.add(new Entry(10, 10));
        entries2.add(new Entry(15, 11));
        entries2.add(new Entry(11, 12));
        entries2.add(new Entry(18, 13));
        entries2.add(new Entry(20, 14));
        entries2.add(new Entry(16, 15));
        entries2.add(new Entry(40, 16));
        entries2.add(new Entry(50, 17));
        entries2.add(new Entry(35, 18));
        entries2.add(new Entry(38, 19));

        LineDataSet dataset2 = new LineDataSet(entries2, "Màu xanh của Đoài");
        dataset2.setColor(Color.BLUE);
        dataset1.setFillColor(Color.BLUE);
        dataset1.setCircleColor(Color.BLUE);
        dataset2.setDrawFilled(false);
        dataset2.setDrawCubic(false);

        //TODO : add data to list
        lines.add(dataset1);
        lines.add(dataset2);

        //TODO : set data to chart view
        mChart.setDescription("");
        mChart.setData(new LineData(labels, lines));
        mChart.animateY(1000);
    }

    private String defindDate(int numberDate) {
        String result = "";
        Calendar cal = Calendar.getInstance();
        cal.setTime(cal.getTime());
        cal.add(Calendar.DATE, numberDate);
        result = convertDateToString(cal.getTime(), "dd/MM/yyyy");
        return result;
    }

    public String convertDateToString(Date date, String format) {
        if (date == null) return null;
        String dateStr = "";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            dateStr = sdf.format(date);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return dateStr;
    }
}
