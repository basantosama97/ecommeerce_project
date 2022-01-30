package com.rest.ecommerce.project.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class CategoryJpaResource {

    @Autowired
    private CategoryDaoService service;

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductVariantRepository productVariantRepository;

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/categories")
    public List<Category> retrieveAllCategories(){
        return (List<Category>) categoryRepository.findAll();
    }


    @GetMapping("/categories/{id}")
    public Page<Category> retrieveCategory (@PathVariable int id, @RequestParam Integer page, @RequestParam Integer size){


        Pageable pageable = PageRequest.of(page, size);
        Page<Category> categories = categoryRepository.findById(id, pageable);
        return categories;

//        Optional<Category> category= categoryRepository.findById(id);
//
//        return category;

    }

    @GetMapping("/categories/{id}/products")
    public List<Product> retrieveAllCategoryProducts(@PathVariable int id){
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        return categoryOptional.get().getProduct();
    }



    @GetMapping("/jpa/categories/{sku}/products/product")
    public List<ProductVariants> retrieveAllProductVariants(@PathVariable int sku){
        Optional<Product> productOptional = productRepository.findById(sku);
        return productOptional.get().getProductVariants();
    }





//    @GetMapping("/jpa/categories/{id}/products")
//    public List<ProductVariants> retrieveAllProductsVariants(@PathVariable int sku){
//        Optional<ProductVariants> productOptional = productVariantRepository.findById(sku);
//        return productOptional.get().getProductVariants();
//    }

//    @GetMapping("/jpa/categories/{id}/products/{product_id}/product/sizes")
//    public List<Size> retrieveAllProductSizes(@PathVariable int id, @PathVariable int product_id){
//        Optional<Product> productOptional = productRepository.findById(product_id);
//        return productOptional.get().getSizes();
//    }

}
