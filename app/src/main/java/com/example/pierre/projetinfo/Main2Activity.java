package com.example.pierre.projetinfo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    public static Client yazid= new Client(36.0125268, -115.0637508);

    private Grid earth = new Grid();

    private int d = 0;

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        context = this;

        Bundle b = getIntent().getExtras();
        String message = b.getString("distance");

        Log.i("Distance: ", message);

        d = Integer.parseInt(message);

        lecture();
        ArrayList<Restaurant> res = earth.listof(yazid, d);

        MyAdapter myAdapter = new MyAdapter(d);

        myAdapter.setRestos(res);

        final RecyclerView rv = (RecyclerView) findViewById(R.id.list);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(myAdapter);


    }

    public void lecture(){

        Database data = new Database();
        ArrayList<Restaurant>  services = null;
        try {
            services = data.createDB(readJSON("restautest.json"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        earth.makeBoxes();


        //Iterator<Restaurant> iterator = services.iterator();
        int i = 0;
        while (i < services.size()) {
            Restaurant r = services.get(i);
            Log.i("Mon resto: ", r.getName());
            earth.addRestaurant(r);
            i++;
        }

        Log.i("On ajoute un restaurant", "hh");
        //Restaurant currentRestaurant = iterator.next();

    }



    private String readJSON(String s) {

        String json = null;
        try {
            InputStream is = getAssets().open(s);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
        }


        Log.i("Contenu", json);

        return json;

    }

}
