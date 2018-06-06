package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;



public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        try {

            JSONObject sandwich_JObject = new JSONObject(json);
            JSONObject sandwich_name = sandwich_JObject.getJSONObject("name");

            String main_name = sandwich_name.getString("mainName");

            JSONArray alsoKnownAs_array = sandwich_name.getJSONArray("alsoKnownAs");
            List<String> alsoKnownAs = new ArrayList<>();
            for (int i = 0; i < alsoKnownAs_array.length(); i++) {
                alsoKnownAs.add(alsoKnownAs_array.getString(i));
            }


            String place_of_origin = sandwich_JObject.getString("placeOfOrigin");
            String description = sandwich_JObject.getString("description");
            String image = sandwich_JObject.getString("image");

            JSONArray ingredients_array = sandwich_JObject.getJSONArray("ingredients");
            List<String> ingredients = new ArrayList<>();
            for (int i = 0; i < ingredients_array.length(); i++) {
                ingredients.add(ingredients_array.getString(i));
            }

            return new Sandwich(main_name, alsoKnownAs, place_of_origin, description, image, ingredients);
        }
        catch (JSONException exp){
            exp.printStackTrace();
            return null;
        }

    }
}
