package com.example.company.myapplication;

import java.io.Serializable;

class ProductItem : Serializable {
    val name : String
    val unit : String;
    val quantity: Float;

    var isSelected = false;

    constructor(name : String, unit : String, quantity : Float) {
        this.name = name;
        this.unit = unit;
        this.quantity = quantity;
    }

    constructor(name : String) {
        this.name = name;
        this.unit = "кг";
        this.quantity = 1f;
    }

    override fun toString() : String {
        val selectIndicator = if (isSelected) "***" else ""
        return selectIndicator + name + ", " + quantity + " " + unit + selectIndicator;
    }
}
