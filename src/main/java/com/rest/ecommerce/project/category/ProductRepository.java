package com.rest.ecommerce.project.category;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product,Integer> {

//    @Query("select x from Product x where x.new_product = true")
    Page<Product> findAllByNewProduct(Boolean new_product,Pageable pageable);
    Page<Product> findAllByFeatured(Boolean featured, Pageable pageable);
    Page<Product> findAllByActive(Boolean active, Pageable pageable);
    Page<Product> findAll(Pageable pageable);
    Page<Product> findByPid(Integer pid, Pageable pageable);

    Product findByPid(Integer pid);
//    Page<Product> findByOrderByPriceDesc(Pageable pageable);

}
