package com.example.demo.controller;

import com.example.demo.dto.UpdateUserRequest;
import com.example.demo.entity.exemole1.Person;
import com.example.demo.service.EntityManagerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    private EntityManagerService entityManagerService;


    @PostMapping("/addUser")
    public String addUser(@RequestBody @Valid Person user, BindingResult bindingResult){
        return entityManagerService.addUser(user, bindingResult);
    }

    @GetMapping("/getUser/{id}")    //get id by url
    public String findById(@PathVariable Long id, @RequestHeader("User-Agent") String header){
        return entityManagerService.findById(id, header);
    }

    @GetMapping("/getUser")    //get id by query parameters
    public String findById(@RequestParam Long id){
        return entityManagerService.findById(id);
    }

    @PutMapping("/changing") // from body
    public String changing(@RequestBody @Valid UpdateUserRequest updateUserRequest,  BindingResult bindingResult){
        return entityManagerService.changing(updateUserRequest, bindingResult);
    }

    @DeleteMapping("/delete")
    public String delete(Long id){
        return entityManagerService.delete(id);
    }

    @GetMapping("/allUsers")
    public List<Person> getAllUsers(){
        return entityManagerService.getAllUsers();
    }


}
