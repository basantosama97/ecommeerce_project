package com.rest.ecommerce.project.category.cart;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRepository extends JpaRepository<JwtUser, Long> {
    JwtUser findByEmail(String email);
    List<JwtUser> findAll();
    JwtUser findUserByEmail(String email);
}
