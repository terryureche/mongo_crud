package com.terry.mongo_crud.db.mongo.repositories;

import com.terry.mongo_crud.db.mongo.models.Product;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ProductRepository extends PagingAndSortingRepository<Product, String> {
    //   mongodb compass { "categoryList.$id" : 0, "subcategoryList.$id": 1}
    @Query(value="{'categoryList.id' : ?0, 'subcategoryList.id' : ?1}")
    List<Product> findAllByCategoryIdSubCategoryID(Integer lhsId, Integer rhsId);
}
