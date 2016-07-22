package com.example.guest.grubbery.services;

import android.util.Log;

import com.example.guest.grubbery.Constants;
import com.example.guest.grubbery.models.Food;
import com.example.guest.grubbery.models.Word;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Guest on 7/8/16.
 */
public class DictionaryService {
    private static final String URL_PRE = "http://api.pearson.com/v2/dictionaries/entries?headword=";
    private static final String URL_API = "&apikey=";

    public ArrayList<Food> mFoods = new ArrayList<>();

    public static void getDefinition(String word, Callback callback) {
        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        String url = URL_PRE + word + URL_API + Constants.API_KEY;

        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public ArrayList<Word> processResults(Response response) {
        ArrayList<Word> words = new ArrayList<>();

        try {
            String jsonData = response.body().string();
            if (response.isSuccessful()) {

                JSONObject dictionaryJSON = new JSONObject(jsonData);
                JSONArray wordsJSON = dictionaryJSON.getJSONArray("results");
                Log.d("CUBONE dict servi", "wordsJSON: " + wordsJSON);

                for (int i = 0; i < wordsJSON.length(); i++) {
                    JSONObject definitionJSON = wordsJSON.getJSONObject(i);
                    String name = definitionJSON.getString("headword");
                    String part = definitionJSON.getString("part_of_speech");
                    JSONObject n = definitionJSON.getJSONArray("senses").getJSONObject(0);
                    String d = n.getJSONObject("definition").toString();
                    Log.d("CUBONE dict servi", n + "");
                    //String definition = n.get(0).toString();
                    //Log.d("CUBONE dict servi", definition + "");
                    //String definition = n.getString("definition").toString();
                    String definition = "Lorem ipsum sample definition em aperiam.";
                    //Log.d("CUBONE dict servi", definition + "");

                    if ( (part.equals("noun")) && (!(name.equals(null))) && (!(definition.equals(null))) ) {
                        Word word = new Word(name, part, definition);
                        words.add(word);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return words;
    }
}
