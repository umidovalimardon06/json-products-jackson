package com.epam.training.products;

import com.epam.training.products.domain.Product;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class ProductQueries {

    private final List<Product> products;

    public ProductQueries(List<Product> products) {
        this.products = products;
    }

    // Returns all subcategories of the category given by its name
    public List<String> getSubCategoriesOf(String categoryName) {
        Set<String> subCategories = new LinkedHashSet<>(); // unique + stable order

        if (categoryName == null || products == null) {
            return new ArrayList<>();
        }

        for (Product product : products) {
            String[] categories = product.getCategories();
            if (categories == null || categories.length < 2) continue;

            String parent = categories[0];
            String child  = categories[1];

            if (categoryName.equals(parent)) {
                subCategories.add(child);
            }
        }

        return new ArrayList<>(subCategories);
    }

    // Get all products that belong to subcategories of "sweets" category
    // and the price is lower than provided parameter
    public List<Product> getSweetsWherePriceIsLowerThan(double price) {
        List<Product> result = new ArrayList<>();

        if (products == null) {
            return result;
        }

        for (Product product : products) {
            String[] categories = product.getCategories();
            if (categories == null || categories.length < 2) continue; // must be in a subcategory

            if ("sweets".equals(categories[0]) && product.getPrice() < price) {
                result.add(product);
            }
        }

        return result;
    }

    // Get the product that has the highest price
    public Product getTheMostExpensiveProduct() {
        if (products == null || products.isEmpty()) {
            return null;
        }

        Product max = products.get(0);
        for (Product p : products) {
            if (p.getPrice() > max.getPrice()) {
                max = p;
            }
        }
        return max;
    }
}
