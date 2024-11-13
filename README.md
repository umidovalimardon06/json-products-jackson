# Introduction

The goal of the exercise is to open json file that contains web shop products,
execute various queries on the data and display in the console.
To process json file please use the learned technologies (Jackson `ObjectMapper`).


# Data Model

Product data follows a simple structure. It has a few attributes that describe the product:
- name
- producer
- amount
- unit
- value

The products may be organized into categories and sub-categories in any level.
If the product is assigned to a category, the product's category array contains an element, the category name.
If the product can be further categorized, the product's subcategory array contains one more element, the subcategory name.

The product data file's top element is a json array, which contains product objects.

See an example of test data:

```
[
  {
    "name": "white bread",
    "producer": "ABC Bakery",
    "amount": 1,
    "unit": "loaf",
    "value": 2.99,
    "categories": ["bakery", "bread"]
  },
  {
    // another product
  }
]
```

Notes
- The example shows categories array that has two elements, one category and sub-category inside it. But you should expect that the array can have any number of elements.


# Technical Specification

The template project contains `Product` domain java class.

`Product` class defines a few fields that do not conform the json data file properties:
- `value` vs `price`
- `amount` vs `quantity`

Make sure to configure `Product` to map the json file to it.

Note: You **must not** rename Product class fields.

These are located in the `com.epam.training.shop` package.

Please implement the following method in `ProductsReader` class:
-  `List<Product> read()` - reads the content of the json file provided by file parameter.

Please implement the following methods in `ProductQueries` class:

| Method name                      | Description                                                                                                       |
|----------------------------------|-------------------------------------------------------------------------------------------------------------------|
| `getSubCategoriesOf`             | Returns all subcategories of the category given by its name                                                       |
| `getSweetsWherePriceIsLowerThan` | Get all products that belong to subcategories of "sweets" category and the price is lower than provided parameter |
| `getTheMostExpensiveProduct`     | Get the product that has the highest price                                                                        |

The template repository contains an example `products.json` file located in `input` folder.

Running the queries on that data set, `getSubCategoriesOf` method called with "drinks" parameter it should return "soft drinks" and "juices".

`getSweetsWherePriceIsLowerThan` method called with parameter 3.0, should return "milk chocolate" and "dark chocolate".
