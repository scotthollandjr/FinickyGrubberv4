package com.example.guest.grubbery.models;

/**
 * Created by Guest on 7/12/16.
 */
public class Word {
    private String mWord;
    private String mPart;
    private String mDefinition;

    public Word(String word, String part, String definition) {
        this.mWord = word;
        this.mPart = part;
        this.mDefinition = definition;
    }

    public String getWord() {
        return mWord;
    }

    public String getPart() {
        return mPart;
    }

    public String getDefinition() {
        return mDefinition;
    }
}
