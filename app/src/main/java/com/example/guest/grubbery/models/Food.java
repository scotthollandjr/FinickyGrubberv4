package com.example.guest.grubbery.models;

import android.os.Parcelable;

import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

@Parcel
public class Food {
    private String name;
    private String brand;
    private List<String> ingredients = new ArrayList<>();

    public Food() {}

    public Food(String name, String brand, ArrayList<String> ingredients) {
        this.name = name;
        this.brand = brand;
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public List<String> getIngredients() { return ingredients; }

    public void setName(String name) { this.name = name; }

    public void setBrand(String brand) { this.brand = brand; }

    public void setIngredients(List<String> ingredients) { this.ingredients = ingredients; }

}
