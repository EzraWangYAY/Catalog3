package com.example.catalog3.Data;
import java.util.list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup
import android.annotation.NonNull;


import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.example.catalog3.R;
import com.example.catalog3.Model.Flights;


public class FlightView extends RecyclerView.Adapter<FlightRecyclerView>.ViewHolder {
    private Context context;
    private List<Flight> flightList;
public FlightView(Context context, List<Flight> flight){
    this.context = context;
    flightList = flight;

}

    @NonNull
    @Override
    public FlightView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
    View views LayoutInflater.from(parent.getContext()).inflate(R.layout.flight,parent, false);
    return new ViewHolder(view.context);

        return null;


    }
    @Override
    public void onBindViewHolder(@NonNull FlightView.ViewHolder holder, int position){

    }
    @Override
    public int getItemCount(){
        return 0;

    }
    public class viewHolder extends RecyclerView.ViewHolder{
        public ViewHolder(@NonNull View itemView){
            super(itemView);

        }
    }


    public class ViewHolder {
    }
}
