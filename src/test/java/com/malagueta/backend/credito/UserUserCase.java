package com.malagueta.backend.credito;

import com.malagueta.backend.credito.services.UserServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
public class UserUserCase {

    @Autowired
    public UserServices userServices;

    @Test
    public void getUsers(){
        Assert.notEmpty(userServices.getUser(),"garanta que há registos de users");
    }
}
