package com.example.menu_makanan.service;

import com.example.menu_makanan.exception.NotFoundException;
import com.example.menu_makanan.model.User;
import com.example.menu_makanan.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserDetailService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) {
        if (userRepository.existsByEmail(username)){
            User user = userRepository.findByEmail(username).orElseThrow(() -> new NotFoundException("Id Not Found"));
            return UserDetail.buildUser(user);
        }
        throw new NotFoundException("User Not Found with username: " + username);
    }

}