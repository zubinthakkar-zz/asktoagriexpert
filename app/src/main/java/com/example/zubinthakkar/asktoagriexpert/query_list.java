package com.example.zubinthakkar.asktoagriexpert;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class query_list extends AppCompatActivity {

    String qlist_url = Url.URL+"querylist.php";
    RecyclerView recyclerView;
    QueryAdapter adapter;
    List<Qlist> qlistList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query_list);

        qlistList = new ArrayList<>();

        recyclerView = (RecyclerView) findViewById(R.id.recycleView);
        recyclerView.setHasFixedSize(true);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        loadQuery();

//adapter = new QueryAdapter(this, qlistList);
//recyclerView.setAdapter(adapter);
    }
    private void loadQuery(){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, qlist_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONArray Query = new JSONArray(response);

                    for(int i=0; i<Query.length(); i++){

                        JSONObject queryobject = Query.getJSONObject(i);
                        int id = queryobject.getInt("query_id");
                        String queryname = queryobject.getString("query");
                        String farmername = queryobject.getString("fna");
                        Qlist query = new Qlist(id,queryname,farmername);

                        qlistList.add(query);
                    }
                    adapter = new QueryAdapter(query_list.this, qlistList);
                    recyclerView.setAdapter(adapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(query_list.this, error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

        Volley.newRequestQueue(this).add(stringRequest);

    }
}
