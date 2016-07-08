package com.example.guest.grubbery.services;

import com.example.guest.grubbery.Constants;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by Guest on 7/8/16.
 */
public class DictionaryService {
    private static final String URL_PRE = "http://api.pearson.com/v2/dictionaries/entries?headword=";
    private static final String URL_API = "&apikey=";

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
}
