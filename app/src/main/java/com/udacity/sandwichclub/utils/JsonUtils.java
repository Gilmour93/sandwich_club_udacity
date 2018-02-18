package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) throws JSONException {
        JSONObject sandwichPicked = new JSONObject(json);
        JSONObject sandwichName = sandwichPicked.getJSONObject("name");
        String mainName = sandwichName.getString("mainName");

        List<String> alsoKnownAs = getList(sandwichName.getJSONArray("alsoKnownAs"));

        String placeOfOrigin = sandwichPicked.getString("placeOfOrigin");
        String description = sandwichPicked.getString("description");
        String image = sandwichPicked.getString("image");

        List<String> ingredients = getList(sandwichPicked.getJSONArray("ingredients"));

        return new Sandwich(mainName, alsoKnownAs, placeOfOrigin, description, image, ingredients);
    }

    private static List<String> getList (JSONArray array) throws JSONException {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < array.length(); i++){
            list.add(array.getString(i));
        }

        return list;
    }
}
