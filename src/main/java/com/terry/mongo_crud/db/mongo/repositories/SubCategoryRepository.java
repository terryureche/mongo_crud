package com.terry.mongo_crud.db.mongo.repositories;

import com.terry.mongo_crud.db.mongo.models.Subcategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface SubCategoryRepository extends PagingAndSortingRepository<Subcategory, String> {
    Page<SubCategoryRepository> findAllById(Integer id, Pageable page);

    Subcategory findSubcategoryBy(Integer id);

    Page<SubCategoryRepository> findAllByName(String name, Pageable page);

    List<Subcategory> findAllBy(TextCriteria criteria);

//    @Query("{ \"categoryList\" : \"$id\"} : ?0")
//    @Aggregation("{ \"categoryList.$id\" : ?0}")
    @Query(value="{ 'categoryList.id' : ?0}")
    List<Subcategory> findByCategoryId(Integer id);
}
