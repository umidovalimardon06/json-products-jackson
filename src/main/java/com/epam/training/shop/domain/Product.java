package com.epam.training.shop.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Optional;

@EqualsAndHashCode
@ToString
@Getter
@Setter
public class Product {
    private String name;
    private String producer;
    private int quantity;
    private String unit;
    private double price;
    private String[] categories;

    public boolean hasCategory() {
        return categories != null && categories.length >= 1;
    }

    public String getCategory() {
        return hasCategory() ? categories[0] : null;
    }

    public boolean hasSubCategory() {
        return categories != null && categories.length >= 2;
    }

    public String getSubCategory() {
        return hasSubCategory() ? categories[1] : null;
    }

}
