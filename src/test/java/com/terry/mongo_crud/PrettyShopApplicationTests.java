package com.terry.mongo_crud;

import com.terry.mongo_crud.db.mongo.models.Category;
import com.terry.mongo_crud.db.mongo.models.Subcategory;
import com.terry.mongo_crud.db.mongo.repositories.CategoryRepository;
import com.terry.mongo_crud.db.mongo.repositories.SubCategoryRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class PrettyShopApplicationTests {
    @Autowired
    private SubCategoryRepository subCategoryRepository;
    @Autowired
    private CategoryRepository categoryRepository;


    private void eraseDemoData() {
        categoryRepository.deleteAll();
        subCategoryRepository.deleteAll();
    }

    private Category generateCategory(Integer id, String name) {
        Category category = new Category(id,name);
        return categoryRepository.save(category);
    }

    private void feedDemoData() {
        Category clothes = generateCategory(0, "clothes");
        Category footwear = generateCategory(1,"footwear");

        Integer RECORD_NR = 10;
        Integer LIMIT_UNTIL_CLOTHES = 4;

        for(Integer i = 0; i < RECORD_NR; i++) {
            Subcategory subcategory = new Subcategory();
            subcategory.setId(i);
            subcategory.setName(String.format("%s-%d", "clothes", i));

            List<Category> categoryList = null;

            if(i < LIMIT_UNTIL_CLOTHES) {
                categoryList = Arrays.asList(clothes);
            } else if(i == RECORD_NR - 1) {
                categoryList = Arrays.asList(clothes, footwear);
            } else {
                categoryList = Arrays.asList(footwear);
            }

            subcategory.setCategoryList(categoryList);

            subCategoryRepository.save(subcategory);
        }
    }

    @Test
    public void testDemo() {
        eraseDemoData();
        feedDemoData();
    }

    @Test
    public void getCountOfSubCategoriesRelatedToClothes() {
        Integer EXPECTED_NUMBER = 5;

        List<Subcategory> subcategoriesList = subCategoryRepository.findByCategoryId(0);
        Integer subcategoriesNr = subcategoriesList.size();

        Assert.assertEquals(EXPECTED_NUMBER, subcategoriesNr);
    }

    @Test
    public void getCountOfSubCategoriesRelatedToFootwear() {
        Integer EXPECTED_NUMBER = 6;

        List<Subcategory> subcategoriesList = subCategoryRepository.findByCategoryId(1);
        Integer subcategoriesNr = subcategoriesList.size();

        Assert.assertEquals(EXPECTED_NUMBER, subcategoriesNr);
    }

//    @Test
//    public void createSubCategoryWitRef() {
//        catRepo.deleteAll();
//        subCatRefRepo.deleteAll();
//
//
//        Subcategory subcatRef = new Subcategory(1,"pantaloni",0);
//
//        Category cat = new Category(1, "haine");
//
//        cat = catRepo.save(cat);
//
//        subcatRef.setCategory(cat);
//
//        Subcategory subcatdb = subCatRefRepo.save(subcatRef);
//
//        System.out.println(subcatdb.getCategory());
//    }
//    @Test
//    public void searchSubCategoryByIndexed() {
//
//        Subcategory subcatRef1 = new Subcategory(1,"pantaloni1",0);
//        subCatRefRepo.save(subcatRef1);
//        Subcategory subcatRef2 = new Subcategory(2,"pantaloni2",0);
//        subCatRefRepo.save(subcatRef2);
//        Subcategory subcatRef3 = new Subcategory(3,"pantaloni3",0);
//        subCatRefRepo.save(subcatRef3);
//
//        TextCriteria search = TextCriteria.forDefaultLanguage().matchingAny("pantaloni%");
//        List<Subcategory> r = subCatRefRepo.findAllBy(search);
//
//        r.stream().forEach(
//                u -> System.out.println(
//                        u.getId() +
//                                u.getName()
//
//                )
//        );
//
//    }



}
