package com.example.catalog3.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.catalog3.Model.Flights;
import com.example.catalog3.R;
import com.squareup.picasso.Picasso;

import org.json.JSONException;

import java.util.HashMap;
import java.util.Map;


public class DetailsActivity extends AppCompatActivity{
        private Flights flights;
        private TextView LocationView, PhoneView, NameView;
        private ImageView airSnap;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

            flights = (Flights) getIntent().getSerializableExtra("flights");
            flightID =  flights.getImbID();
            LocationView = findViewById(R.id.LocationView);
            PhoneView = findViewById(R.id.PhoneView);
            NameView = findViewById(R.id.NameView);

            getFlightDetails(flightID);
    }
    private void getFlightDetails(String id){
        String myUrl = "https://airport-info.p.rapidapi.com/airport" + id;
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, myUrl, null ,  )// dont kno wwhat ot write after this aprt video doesn't show it
        @Override
                public void onResponse(JSONObject response){
                try{
                    LocationView.setText(response.getString("Location"));
                    PhoneView.setText("Phone" + response.getString("Phone"));
                    NameView.setText("Name" + response.getString("Name"));


                    Picasso.get()
                            .load(response.getString("Flyer"))
                            .fit()
                            .into(airSnap);

                }catch (JSONException e){
                    e.printStackTrace();
                }
        }
    }, new Response.ErrorListner(){
        @Override
                public void onErrorResponse(VolleyError error){
            Log.d("Erreur", "Err" + error);

        }
    }) {
            @Override
                    public Map<String, String> getHeaders() throws AuthFailureError (
                            Map<String, String> params = new HashMap<>();
                            params.put("X-RapidAPI-Host", "airport-info.p.rapidapi.com");
                            params.put("X-RapidAPI-Key", "76cdcb02a3msh62cb64c6e4c1133p120b83jsnde911ba5edb9");
                            return params;



        )
    };

queue.add(jsonObjectRequest);

}