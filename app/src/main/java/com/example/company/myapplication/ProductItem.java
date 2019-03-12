package com.example.company.myapplication;

import java.io.Serializable;

public class ProductItem implements Serializable {
    public String name;
    public String unit;
    public float quantity;

    public boolean isSelected = false;

    public ProductItem(String name, String unit, float quantity) {
        this.name = name;
        this.unit = unit;
        this.quantity = quantity;
    }

    public ProductItem(String name) {
        this.name = name;
        this.unit = "кг";
        this.quantity = 1f;
    }

    @Override
    public String toString() {
        String selectIndicator = isSelected ? "***" : "";
        return selectIndicator + name + ", " + quantity + " " + unit + selectIndicator;
    }
}
