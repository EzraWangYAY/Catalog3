package com.example.catalog3.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.catalog3.Data.FlightRecyclerViewAdapter;
import com.example.catalog3.Model.Flights;
import com.example.catalog3.R;
import com.example.catalog3.Util.Prefs;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private FlightRecyclerViewAdapter flightRecyclerViewAdapter;
    private List<Flights> flightsList;
    private RequestQueue requestQueue;

    //premier essaie
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestQueue = Volley.newRequestQueue(this);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        flightsList = new ArrayList<>();

        Prefs prefs = new Prefs(MainActivity.this);
        String search = prefs.getSearch();
        flightsList = getFlights(search);
        flightRecyclerViewAdapter = new FlightRecyclerViewAdapter(this, flightsList);
        recyclerView.setAdapter(flightRecyclerViewAdapter);
        flightRecyclerViewAdapter.notifyDataSetChanged();


    }

    public List<Flights> getFlights(String Search) {
        flightsList.clear();
        String myUrl = "https://airport-info.p.rapidapi.com/airport" + Search + "&r=json";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(myUrl, new Response.Listener<JSONObject>() {
            @Override

            public void onResponse(JSONObject response) {
                try {
                    JSONArray flightArray = response.getJSONArray("Search");
                    for(int i=0; i<flightArray.length(); i++){
                        flightObj = flightArray.getJSONObject(i);
                        Flight flight = new Flight();
                        flight.setName(flightObj.getString("Name"));
                        flight.setPhone(flightObj.getString("Phone"));
                        flight.setLocation(flightObj.getString("Location"));
                        flightsList.add(flight);

                    }
                    flightRecyclerViewAdapter.notifyDataSetChanged();


                }catch (JSONException e) {
                    e.printStackTrace();

                }

            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error){

            }
        })
        {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("X-RapidAPI-Host", "airport-info.p.rapidapi.com");
                params.put("X-RapidAPI-Key", "76cdcb02a3msh62cb64c6e4c1133p120b83jsnde911ba5edb9");
                return params;

            }
        };
        requestQueue.add(jsonObjectRequest);

        return flightsList;
    }
}

               