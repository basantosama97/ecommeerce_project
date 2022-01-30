package com.rest.ecommerce.project.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductJpaResource {

    @Autowired
    private ProductDaoService service;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductVariantRepository productVariantRepository;
    @Autowired
    private ProductRepository productRepository;


    @GetMapping("/products")
    public Page<Product> retrieveAllProducts(@RequestParam Integer page, @RequestParam Integer size){

//        return (List<Product>) productRepository.findAll(firstPageWithTwoElements);
        //return (List<Product>) productRepository.findAll();
        Pageable pageable = PageRequest.of(page, size);
        Page<Product> pageing = productRepository.findAll(pageable);
        return pageing;

    }
    @GetMapping("/categoryproducts/{id}")
    public List<Product> ProductsPerCategory(@PathVariable Integer id){
        return productRepository.findByCategory_Id(id);
    }


    @GetMapping("/products/product/{id}")
    public Page<Product> retrieveOneProducts (@PathVariable int id, @RequestParam Integer page, @RequestParam Integer size){

        Pageable pageable = PageRequest.of(page, size);
        Page<Product> product = productRepository.findByPid(id, pageable);
        return product;

     //   Optional<Product> product= productRepository.findById(id);

     //   return product;

    }

    @GetMapping("/products/new/{new_product}")
    public Page<Product> retrieveNewProducts(@PathVariable Boolean new_product, @RequestParam Integer page, @RequestParam Integer size){

        Pageable pageable = PageRequest.of(page, size);
        Page<Product> product = productRepository.findAllByNewProduct(new_product, pageable);
        return product;

      //  return productRepository.findAllByNewProduct(new_product);
    }

    @GetMapping("/products/featured/{featured}")
    public Page<Product> retrieveFeaturedProducts(@PathVariable Boolean featured, @RequestParam Integer page, @RequestParam Integer size){

        Pageable pageable = PageRequest.of(page, size);
        Page<Product> product = productRepository.findAllByFeatured(featured, pageable);
        return product;


        // return productRepository.findAllByFeatured(featured);
    }

    @GetMapping("/products/active/{active}")
    public Page<Product> retrieveActiveProducts(@PathVariable Boolean active, @RequestParam Integer page, @RequestParam Integer size){

        Pageable pageable = PageRequest.of(page, size);
        Page<Product> product = productRepository.findAllByActive(active, pageable);
        return product;

       //return productRepository.findAllByActive(active);
    }

    @GetMapping("/products/asc")
    public Page<Product> retrieveAllProductsAsc(@RequestParam Integer page, @RequestParam Integer size){

        Pageable pageable = PageRequest.of(page, size, Sort.by("price").ascending());
        Page<Product> paging = productRepository.findAll(pageable);
        return paging;
    }

    @GetMapping("/products/desc")
    public Page<Product> retrieveAllProductsDesc(@PageableDefault Pageable pageable){

        //Pageable pageable = PageRequest.of(page, size, Sort.by("price").descending());
        Page<Product> paging = productRepository.findAll(pageable);
        return paging;
    }


}
