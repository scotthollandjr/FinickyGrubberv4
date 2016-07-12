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
            Log.d("CUBONE dict act", "jsonData =" + jsonData);
            if (response.isSuccessful()) {
                JSONObject dictionaryJSON = new JSONObject(jsonData);
                JSONArray wordsJSON = dictionaryJSON.getJSONArray("results");

                for (int i = 0; i < wordsJSON.length(); i++) {
                    JSONObject definitionJSON = wordsJSON.getJSONObject(i);
                    String name = definitionJSON.getString("headword");
                    String part = definitionJSON.getString("part_of_speech");
                    String definition = definitionJSON.getString("definition");

                    Word word = new Word(name, part, definition);
                    words.add(word);
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
