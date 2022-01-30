package com.rest.ecommerce.project.category;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryDaoService {

    private static List<Category> categories = new ArrayList<>();

    private static int categoriesCount =3;
    static {
        categories.add(new Category(1, "V-neck category", "V shape neck T-shirts", "image"));
        categories.add(new Category(2, "R-neck category", "Rounded shape neck T-shirts", "image"));
        categories.add(new Category(3, "H-neck category", "High shape neck T-shirts", "image"));


//        categories.add(new Category(2, "Eve", new Date()));
//        categories.add(new Category(3, "Jack", new Date()));

    }

    public List<Category> findAll(){
        return categories;
    }

    public Category save (Category category){
        if(category.getId()==null){
            category.setId(++categoriesCount);
        }
        categories.add(category);
        return category;
    }

    public Category findOne(int id){
        for (Category category:categories){
            if (category.getId()==id){
                return category;
            }
        }
        return null;
    }

}
