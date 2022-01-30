package com.rest.ecommerce.project.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryResource {

    @Autowired
    private CategoryDaoService service;

    @GetMapping("old/categories")
    public List<Category> retrieveAllCategories(){
        return service.findAll();
    }


    @GetMapping("old/categories/{id}")
    public Category retrieveCategory(@PathVariable int id){
        return service.findOne(id);
    }

}
