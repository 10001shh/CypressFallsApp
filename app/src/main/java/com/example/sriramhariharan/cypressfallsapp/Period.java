package com.example.sriramhariharan.cypressfallsapp;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
/**
 * Created by SriramHariharan on 2/28/16.
 */
public class Period {
    private String name;
    private int grade;

    public Period(String n, int g)
    {
        name = n;
        grade = g;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String n)
    {
        name = n;
    }
    public int getGrade()
    {
        return grade;
    }

    public void setGrade(int g)
    {
        grade = g;
    }
}
