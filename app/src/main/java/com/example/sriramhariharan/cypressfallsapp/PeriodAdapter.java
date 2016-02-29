package com.example.sriramhariharan.cypressfallsapp;


import java.util.List;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by SriramHariharan on 2/28/16.
 */
public class PeriodAdapter extends BaseAdapter implements OnClickListener{
    private Context context;
    private List<Period> periods;

    public PeriodAdapter(Context context, List<Period> per){
        this.context = context;
        this.periods = per;
    }
    public int getCount() {
        return periods.size();
    }
    public Object getItem(int position) {
        return periods.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup viewGroup)
    {
        Period num = periods.get(position);
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.rowlayout, null);
        }
        TextView schperiod = (TextView) convertView.findViewById(R.id.period);
        schperiod.setText(num.getName());

        TextView grade = (TextView) convertView.findViewById(R.id.grade);
        grade.setText(num.getGrade() + "");
        int numgrade = num.getGrade();

        if(numgrade > 90 || numgrade == 90)
        {
            grade.setTextColor(Color.GREEN);
        }
        if((numgrade > 80 && numgrade <90) || numgrade == 80)
            grade.setTextColor(Color.YELLOW);
        if((numgrade > 70 && numgrade <80) || numgrade == 70)
            grade.setTextColor(Color.parseColor("#FFA500"));
        if(numgrade < 70)
        {
            grade.setTextColor(Color.RED);
        }
        return convertView;
    }
    @Override
    public void onClick(View view) {

    }



}
