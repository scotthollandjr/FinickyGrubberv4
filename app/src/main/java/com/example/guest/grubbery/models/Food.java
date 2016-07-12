package com.example.guest.grubbery.models;

import org.parceler.Parcel;

/**
 * Created by Guest on 7/11/16.
 */
@Parcel
public class Food {
    private String mName;
    private String mBrand;

    public Food() {}

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
