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
    private boolean small_breed;
    private boolean large_breed;
    private String manufactured_in;
    private int kcal_per_oz;
    private int crude_protein;
    private int crude_fat;
    private int crude_fiber;
    private String type;
    private String age;

    public Food() {}

    public Food(String name, String brand, ArrayList<String> ingredients, boolean grain_free, boolean small_breed, boolean large_breed, String manufactured_in, int kcal_per_oz, int crude_protein, int crude_fat, int crude_fiber, String type, String age) {
        this.name = name;
        this.brand = brand;
        this.ingredients = ingredients;
        this.grain_free = grain_free;
        this.small_breed = small_breed;
        this.large_breed = large_breed;
        this.manufactured_in = manufactured_in;
        this.kcal_per_oz = kcal_per_oz;
        this.crude_protein = crude_protein;
        this.crude_fat = crude_fat;
        this.crude_fiber = crude_fiber;
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

    public boolean getSmall_breed() { return small_breed; }

    public boolean getLarge_breed() { return large_breed; }

    public String getManufactured_in() {
        return manufactured_in;
    }

    public int getKcal_per_oz() {
        return kcal_per_oz;
    }

    public int getCrude_protein() {
        return crude_protein;
    }

    public int getCrude_fat() {
        return crude_fat;
    }

    public int getCrude_fiber() {
        return crude_fiber;
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

    public void setKcal_per_cup(int kcal_per_oz) { this.kcal_per_oz = kcal_per_oz; }

    public void setCrude_protein(int crude_protein) { this.crude_protein = crude_protein; }

    public void setCrude_fat(int crude_fat) { this.crude_fat = crude_fat; }

    public void setCrude_fiber(int crude_fiber) { this.crude_fiber = crude_fiber; }

    public void setType(String type) { this.type = type; }

    public void setAge(String age) { this.age = age; }

}
