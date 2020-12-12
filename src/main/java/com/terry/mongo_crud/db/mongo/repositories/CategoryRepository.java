package com.terry.mongo_crud.db.mongo.repositories;

import com.terry.mongo_crud.db.mongo.models.Category;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CategoryRepository extends PagingAndSortingRepository<Category, String> {
    Category findById(Integer id);
}
