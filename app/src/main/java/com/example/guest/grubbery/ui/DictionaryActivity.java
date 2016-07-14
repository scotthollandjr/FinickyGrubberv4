package com.example.guest.grubbery.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.guest.grubbery.Constants;
import com.example.guest.grubbery.R;
import com.example.guest.grubbery.models.Word;
import com.example.guest.grubbery.services.DictionaryService;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class DictionaryActivity extends AppCompatActivity {
    public static ArrayList<Word> mWords = new ArrayList<>();
    @Bind(R.id.defintionListView) ListView mDefinitionListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String word = intent.getStringExtra("word");

        findDefinition(word);
    }

    public void findDefinition(String word) {
        final DictionaryService dictionaryService = new DictionaryService();

        dictionaryService.getDefinition(word, new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) {
                mWords = dictionaryService.processResults(response);
                //Log.d("CUBONE dict acti", "response " + response);

                DictionaryActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        String[] entries = new String[mWords.size()];
                        for (int i = 0; i < entries.length; i ++) {
                            entries[i] = mWords.get(i).getWord() + ": " + mWords.get(i).getDefinition();
                        }

                        ArrayAdapter adapter = new ArrayAdapter(DictionaryActivity.this, android.R.layout.simple_list_item_1, entries);
                        mDefinitionListView.setAdapter(adapter);

//                        for (Word word : mWords) {
//                            Log.d("CUBONE dict acti", word.getWord());
//                            Log.d("CUBONE dict acti", word.getPart());
//                            Log.d("CUBONE dict acti", word.getDefinition());
//                        }
                    }
                });
            }
        });
    }
}
