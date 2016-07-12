package com.example.guest.grubbery.models;

/**
 * Created by Guest on 7/11/16.
 */
public class Food {
    private String mName;
    private String mBrand;

    public Food(String name, String brand) {
        this.mName = name;
        this.mBrand = brand;
    }

    public String getName() {
        return mName;
    }

    public String getBrand() {
        return mBrand;
    }
}
