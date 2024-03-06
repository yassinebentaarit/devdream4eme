package tn.esprit.devdream.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.devdream.entities.User;
import tn.esprit.devdream.service.interfaces.IUserService;
import tn.esprit.devdream.service.classes.UserServices;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
//@PreAuthorize("hasRole('Esprit') ")
public class UserControllers {
    @Autowired
    IUserService iUserService;

    @Autowired
    UserServices us ;

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user ){
        return us.addUser(user);
    }
    @GetMapping("/showAlluser")
    public List<User> retrieveAllUser(){
        return us.retrieveAllUsers();
    }
    @GetMapping("/retrieve-all-Users")
    public List<User> getUser() {
        List<User> listUser = iUserService.retrieveAllUsers();
        return listUser;
    }
    @GetMapping("/retrieve-User/{user-id}")
    public User retrieveUser(@PathVariable("user-id") Long userId) {
        User user  = iUserService.retrieveUser(userId);
        return user;
    }
    @DeleteMapping("/remove-user/{user-id}")
    public void removeUser(@PathVariable("user-id") Long userId) {
        iUserService.removeUser(userId);
    }

   /* @PutMapping("/modify-user/{user-id}")
    public User modifyUser(@PathVariable("user-id") Long userId,@RequestBody User c) {
        c.setId(userId);
        User user = iUserService.modifyUser(c);
        return user;
    }*/
}

