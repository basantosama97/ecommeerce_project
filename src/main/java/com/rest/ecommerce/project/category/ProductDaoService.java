package com.rest.ecommerce.project.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductDaoService {
    @Autowired
    private ProductRepository productRepository;

    private static List<Product> products = new ArrayList<>();

    private static int productsCount =3;
    static {
        products.add(new Product(111,"V-neck Tshirt", "Description", "Slug", "image", true, false, true));

    }

    public List<Product> findAll(){
        return products;
    }

    public Product save (Product product){
        if(product.getPid()==null){
            product.setPid(++productsCount);
        }
        products.add(product);
        return product;
    }

    public Product findOne(int id){
        for (Product product:products){
            if (product.getPid()==id){
                return product;
            }
        }
        return null;
    }

    public List<Product> AllNew(Boolean new_products){
        for (Product new_product:products){
            if (new_product.getNewProduct() == true){
                return (List<Product>) new_product;
            }
        }
        return null;
    }

//    public Page<Product> findPaginated(int pageNo, int pageSize){
//        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
//        return productRepository.findAll(pageable);
//    }

//    public List<Product> findAllProductsDesc(String field){
//        return productRepository.findAll(Sort.by(Sort.Direction.DESC, field));
//    }


}
