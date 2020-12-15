package com.terry.mongo_crud.api;


import com.terry.mongo_crud.db.mongo.models.Product;
import com.terry.mongo_crud.db.mongo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
class Products {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    Iterable<Product> getProducts() {
        return productRepository.findAll();
    }

    //looks like this is use swagger
    //and we are not allowed to use the same url with diff params
    @RequestMapping("/category_id_and_subcategory_id")
    @GetMapping
    Iterable<Product> getProductsFilteredBySubCategoryAndCategory(
            @RequestParam(name="categoryId") Integer categoryId,
            @RequestParam(name="subCategoryId") Integer subCategoryId
    ) {
        return productRepository.findAllByCategoryIdSubCategoryID(categoryId, subCategoryId);
    }

    //looks like this is use swagger
    //and we are not allowed to use the same url with diff params
    @RequestMapping("/category_id")
    @GetMapping
    Iterable<Product> getProductsFilteredByCategory(
            @RequestParam(name="categoryId") Integer categoryId
    ) {
        return productRepository.findAllByCategoryId(categoryId);
    }

    //looks like this is use swagger
    //and we are not allowed to use the same url with diff params
    @RequestMapping("/subcategory_id")
    @GetMapping
    Iterable<Product> getProductsFilteredBySubCategory(
            @RequestParam(name="subCategoryId") Integer subCategoryId
    ) {
        return productRepository.findAllBySubCategoryID(subCategoryId);
    }
}
