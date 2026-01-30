package com.epam.training.products;

import com.epam.training.products.domain.Product;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

public class ProductsReader {
    public ProductsReader(File file) {
    }

    @SneakyThrows
    public List<Product> read() {
        ObjectMapper objectMapper = new ObjectMapper();
        Path inputJson = Paths.get("input/products.json");
        List<Product> products;

        products = objectMapper.readValue(
                Files.newBufferedReader(inputJson),
                new TypeReference<List<Product>>(){}
        );

        return products;
    }
}
