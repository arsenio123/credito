package com.malagueta.backend.credito.api;
import com.malagueta.backend.credito.model.User;
import com.malagueta.backend.credito.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserAPI {

    private UserServices userServices;

    @Autowired
    public  UserAPI(UserServices userServices){
        this.userServices =userServices;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("user/list")
    public List<User> getUsers(){
        return userServices.getUser();

    }

    @PostMapping("user/login")
    public User getUsers(@RequestBody String name){
        System.out.println(name);
        return userServices.getUserByName(name);

    }
}
