package com.example.catalog3.Data;
import java.util.List;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.catalog3.R;
import com.example.catalog3.Model.Flights;
import com.squareup.picasso.Picasso;

public class FlightRecyclerViewAdapter extends RecyclerView.Adapter<FlightRecyclerViewAdapter.ViewHolder> {
    private Context context;
    private List<Flights> flightList;

public FlightRecyclerViewAdapter(Context context, List<Flights> flight)
{
    this.context = context;
    flightList = flight;

}

    @NonNull
    @Override
    public FlightRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
    View views = LayoutInflater.from(parent.getContext()).inflate(R.layout.airport,parent, false);

    return new ViewHolder(views, context);




    }
    @Override
    public void onBindViewHolder(@NonNull FlightRecyclerViewAdapter.ViewHolder holder, int position){
    Flights flight = flightList.get(position);
    //image of plane
    String airSnapShot = flight.getSnapShot();  // Tu n'avais pas de methode flight.getSnapShot() dans le fichier Flights je l'ai ajouté mais je ne sais pas c'est pour quoi faire!!!!!!
    holder.name.setText(flight.getName());
    holder.location.setText("Location: " + flight.getLocation());
    holder.phone.setText("Phone: " + flight.getPhone());
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
            name=itemView.findViewById(R.id.FlightNameID);
            airSnap=itemView.findViewById(R.id.FlightImageID);
            // peut être que tu devrais créer le champ airSnap dans le fichier airport.xm !!!! car ici tu as deux champs qui font la même chose
            location=itemView.findViewById(R.id.FlightLocationID);
            phone=itemView.findViewById(R.id.FlightNumberID); // peut être renommer le nom du champ pour qu'on puisse savoir que c'est un numéro de télephone !! voir dans le fichier airport.xml

                imageView.setOnClickListener(new View.onClickListener()){
                    @Override
                public void onClick(View v){
                        Flights flights = flightList.get(getAdapterPosition());
                        Intent intent = new Intent(context, DetailsACtivity.class);
                        intent.putExtra("flight", (CharSequence) flights);
                        context.startActivity(intent);


                }
            }


        }
    }


    public class ViewHolder1 {
        public ViewHolder1(View views, Context context) {
        }
    }
}
