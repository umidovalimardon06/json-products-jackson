package com.epam.training.products.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@Getter
@Setter


public class Product {
    @JsonProperty("name")
    private String name;

    @JsonProperty("producer")
    private String producer;

    @JsonProperty("amount")
    private int quantity;

    @JsonProperty("unit")
    private String unit;

    @JsonProperty("value")
    private double price;

    @JsonProperty("categories")
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
