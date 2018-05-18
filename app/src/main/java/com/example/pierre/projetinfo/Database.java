package com.example.pierre.projetinfo;

import android.util.Log;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Database {
    Database data;
    public ArrayList<Restaurant> createDB(String file) throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure( DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        //nécessaire pour éviter les erreurs à chaque fois qu'on tombe sur un attribut non réferencé dans la classe Restaurant
        // @SuppressWarnings("resource")

        Scanner input = new Scanner(file);
        ArrayList<Restaurant> restaurants=new ArrayList<Restaurant>();
        Log.i("Initialisation", "Taille: "+restaurants.size());
        //while (input.hasNextLine()) {
        //lecture ligne à ligne du fichie
        String jsonInString1 = file; //input.nextLine();
        Restaurant resto=mapper.readValue(jsonInString1, Restaurant.class);
        Log.i("Resto:", "mon resto est "+resto.getName());
        restaurants.add(resto);
        //}



        Log.i("Conclusion", "Taille: "+restaurants.size());
        return restaurants;



    }
}
