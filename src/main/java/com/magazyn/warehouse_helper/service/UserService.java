package com.magazyn.warehouse_helper.service;


import com.magazyn.warehouse_helper.model.User;
import com.magazyn.warehouse_helper.model.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User save(UserRegistrationDto registrationDto);
    User getUserByName(String name);
//    void addBookToUser(User user, Book book);
    User getUserByEmail(String email);

    User findUserById(int id);
}
