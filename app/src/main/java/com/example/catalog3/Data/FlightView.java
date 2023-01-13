package com.example.catalog3.Data;
import java.util.list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup
import android.annotation.NonNull;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.catalog3.R;
import com.example.catalog3.Model.Flights;
import com.squareup.picasso.Picasso;


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
    View views = LayoutInflater.from(parent.getContext()).inflate(R.layout.airport,parent, false);

    return new ViewHolder(views, context);
//gdgdgdd



    }
    @Override
    public void onBindViewHolder(@NonNull FlightView.ViewHolder holder, int position){
    Flights flight = flightList.get(position);
    String airSnapShot = flight.getSnapShot();
    holder.name.setText(flight.getName());
    holder.location.setText(flight.getLocation());
    holder.phone.setText(flight.getPhone());
    Picasso.get()
            .load(airSnapShot)
            .fit()
            .placeholder(android.R.drawable.ic_btn_speak_now)
            .into(holder.airSnap);


    }
    @Override
    public int getItemCount(){
        return flightList.size();

    }
    public class ViewHolder extends RecyclerView.ViewHolder{
    TextView name;
    TextView location;
    TextView phone;
    ImageView airSnap;
        public ViewHolder(@NonNull View itemView, Context context){
            super(itemView);
            context=context;
            name=itemView.findViewById(R.id.flightNameID);
            airSnap=itemView.findViewById(R.id.flightLocationID);
            location=itemView.findViewById(R.id.flightLocationID);
            phone=itemView.findViewById(R.id.flightPhoneID);



        }
    }


    public class ViewHolder1 {
        public ViewHolder1(View views, Context context) {
        }
    }
}
