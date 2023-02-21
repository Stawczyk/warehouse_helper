package com.magazyn.warehouse_helper.controller;


import com.magazyn.warehouse_helper.model.User;
import com.magazyn.warehouse_helper.model.dto.UserRegistrationDto;
import com.magazyn.warehouse_helper.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("/registration")
public class UserRegistrationController {
    @Autowired
    private UserService userService;

    @PostMapping
    public HttpStatus registerUserAccount(@RequestBody UserRegistrationDto registrationDto) {
        User user = userService.save(registrationDto);
        if (user ==null){
            return HttpStatus.BAD_REQUEST;
        }
        return HttpStatus.ACCEPTED;
    }

}
