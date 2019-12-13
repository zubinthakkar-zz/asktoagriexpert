package com.example.zubinthakkar.asktoagriexpert;

/**
 * Created by sapan on 16-03-2018.
 */

public class Qlist {
    private int id;
    private String query;
    private String farmer;



    public Qlist(int id, String query, String farmer_id) {
        this.id = id;
        this.query = query;
        this.farmer = farmer_id;
    }

    public int getId() {

        return id;
    }


    public String getQuery() {

        return query;

    }
    public String getFarmer()
    {
        return farmer;
    }

}
