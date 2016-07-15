package com.example.guest.grubbery.models;

import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Guest on 7/11/16.
 */
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
}
