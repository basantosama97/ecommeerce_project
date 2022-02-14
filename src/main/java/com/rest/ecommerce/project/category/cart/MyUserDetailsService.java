package com.rest.ecommerce.project.category.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MyUserDetailsService implements UserDetailsService {
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return new User("foo", "foo", new ArrayList<>());
//    }

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        JwtUser jwtUser = userRepository.findUserByEmail(email);
        if (jwtUser == null) {
            throw new UsernameNotFoundException("email Not found" + email);
        }
        return new User(jwtUser.getEmail(), jwtUser.getPassword(), new ArrayList<>());
    }
}
