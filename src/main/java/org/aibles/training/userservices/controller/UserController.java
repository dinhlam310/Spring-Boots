package org.aibles.training.userservices.controller;

import org.aibles.training.userservices.model.User;
import org.aibles.training.userservices.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;
    public UserController(UserService userService){
        this.userService=userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser (@PathVariable("id") int id) {
         User user = userService.getUser(id);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }



    @GetMapping("/ListUser")
    public ResponseEntity<List<User>> getUser(){
        List<User> getAllUser = userService.getAllUser();
        return new ResponseEntity<List<User>>(getAllUser, HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public  ResponseEntity<User> createUser(@Valid @RequestBody User user){
        User createUser = userService.createUser(user);
        return new ResponseEntity<User>(createUser, HttpStatus.OK);

    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<String> updateUser(@Valid @PathVariable ("id") int id,@Valid @RequestBody User user){
        User updateUser = userService.updateUser(id,user);
        return new ResponseEntity<String>("Update Successfully", HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") int id){
        userService.deleteUser(id);
        return new ResponseEntity<String>("Delete Successfully", HttpStatus.OK);
    }

}
