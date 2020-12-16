package com.terry.mongo_crud.api;


import com.terry.mongo_crud.db.mongo.models.Product;
import com.terry.mongo_crud.db.mongo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
class Products {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping
        Iterable<Product> getProducts(
            @RequestParam(name="categoryId",required = false) Optional<Integer> categoryId,
            @RequestParam(name="subCategoryId", required = false) Optional<Integer> subCategoryId
    ) {
        if(categoryId.isPresent() && subCategoryId.isPresent()) {
            return productRepository.findAllByCategoryIdSubCategoryID(categoryId.get(), subCategoryId.get());
        } else if(categoryId.isPresent()) {
            return productRepository.findAllByCategoryId(categoryId.get());
        } else if(subCategoryId.isPresent()) {
            return productRepository.findAllBySubCategoryID(subCategoryId.get());
        } else {
            return productRepository.findAll();
        }
    }
}
