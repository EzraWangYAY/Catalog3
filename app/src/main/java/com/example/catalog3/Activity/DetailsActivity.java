package com.example.catalog3.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.catalog3.Model.Flights;
import com.example.catalog3.R;




    public class DetailsActivity extends AppCompatActivity{
        private Flights flights;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

    }
}