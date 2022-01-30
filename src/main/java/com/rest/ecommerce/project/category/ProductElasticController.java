package com.rest.ecommerce.project.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductElasticController {

    private ProductElasticService service;


    private ProductRepository productRepository;

    @Autowired
    public ProductElasticController(ProductElasticService service, ProductRepository productRepository) {

        this.service = service;
        this.productRepository = productRepository;
    }


// Didn't work
//    @GetMapping("{id}")
//    public Product findById(@PathVariable String id) throws Exception {
//
//        return service.findById(id);
//    }


//    @GetMapping("/allproducts")
//    public List<Product> findAll() throws Exception {
//
//        return service.findAll();
//    }


    @PostMapping("/save/{id}")
    public ResponseEntity createProduct(@PathVariable Integer id) throws Exception {
        Product product = (Product) productRepository.findByPid(id);
        return new ResponseEntity(service.createProduct(product), HttpStatus.CREATED);
    }


//    @GetMapping(value = "/search")
//    public List<Product> search(
//            @RequestParam(value = "name") String name, @RequestParam(value = "description") String description)
//            throws Exception {
//        return service.searchByName(name, description);
//    }


    @GetMapping(value = "/search")
    public List<Product> search(
            @RequestParam String match)
            throws Exception {
        return (List<Product>) service.searchByProductNameAndDescription(match);
    }


    @GetMapping(value = "/searching")
    public List<Product> searchProductByCategory(
            @RequestParam String category)
            throws Exception {
        return service.searchByCategory(category);

//    }
//    @PostMapping
//    public Product insertProduct(@RequestBody Product product) throws Exception {
//        return service.createProduct(product);
//    }
//
//    @PutMapping("/{id}")
//    public Map<String, Object> updateProductById(@RequestBody Product product, @PathVariable String id) {
//        return service.(id, book);
//    }


//    @PostMapping
//    public ResponseEntity createProduct(
//
//            Optional<Product> product= productRepository.findAll();
//
//        return
//                new ResponseEntity(service.createProduct(document), HttpStatus.CREATED);
//    }

    }
}
