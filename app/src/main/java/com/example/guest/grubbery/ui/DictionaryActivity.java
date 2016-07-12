package com.example.guest.grubbery.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.guest.grubbery.Constants;
import com.example.guest.grubbery.R;
import com.example.guest.grubbery.models.Word;
import com.example.guest.grubbery.services.DictionaryService;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class DictionaryActivity extends AppCompatActivity {

    public static ArrayList<Word> mWords = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String word = intent.getStringExtra("word");

        findDefinition(word);
    }

    public static void findDefinition(String word) {
        final DictionaryService dictionaryService = new DictionaryService();
        dictionaryService.getDefinition(word, new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    String jsonData = response.body().string();
                    if (response.isSuccessful()) {
                        mWords = dictionaryService.processResults(response);
                        Log.v("Dictionary Activity", mWords.size() + "");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
