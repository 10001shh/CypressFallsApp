package com.example.sriramhariharan.cypressfallsapp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by SriramHariharan on 3/11/16.
 */
public class CourseAdapter extends BaseAdapter {

    Context context;
    private ArrayList<Course> courses;
    private static LayoutInflater inflater = null;

    public CourseAdapter (Context contxt,ArrayList<Course> crs) {
        courses = crs;
        context = contxt;

        inflater = (LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return courses.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return  courses.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public class Holder
    {
        TextView clssname;
        TextView teacher;
        TextView grade;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder = new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.rowlayout, null);
        holder.clssname=(TextView) rowView.findViewById(R.id.period);
        holder.teacher=(TextView) rowView.findViewById(R.id.teachedr);
        holder.grade = (TextView) rowView.findViewById(R.id.grade);
        holder.clssname.setText(courses.get(position).getSubject());
        holder.teacher.setText(courses.get(position).getTeacher().getName());
        holder.grade.setText(courses.get(position).getAverage() + "");

        return rowView;
    }
}
