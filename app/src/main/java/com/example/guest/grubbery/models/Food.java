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
    private boolean grain_free;
    private String manufactured_in;
    private int kcal_per_cup;
    private String type;
    private String age;

    public Food() {}

    public Food(String name, String brand, ArrayList<String> ingredients, boolean grain_free, String manufactured_in, int kcal_per_cup, String type, String age) {
        this.name = name;
        this.brand = brand;
        this.ingredients = ingredients;
        this.grain_free = grain_free;
        this.manufactured_in = manufactured_in;
        this.kcal_per_cup = kcal_per_cup;
        this.type = type;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public boolean getGrain_free() {
        return grain_free;
    }

    public String getManufactured_in() {
        return manufactured_in;
    }

    public int getKcal_per_cup() {
        return kcal_per_cup;
    }

    public String getType() {
        return type;
    }

    public String getAge() { return age; }


    public List<String> getIngredients() {
        return ingredients;
    }

    public void setName(String name) { this.name = name; }

    public void setBrand(String brand) { this.brand = brand; }

    public void setIngredients(List<String> ingredients) { this.ingredients = ingredients; }

    public void setGrain_free(boolean grain_free) { this.grain_free = grain_free; }

    public void setManufactured_in(String manufactured_in) { this.manufactured_in = manufactured_in; }

    public void setKcal_per_cup(int kcal_per_cup) { this.kcal_per_cup = kcal_per_cup; }

    public void setType(String type) { this.type = type; }

    public void setAge(String age) { this.age = age; }

}
