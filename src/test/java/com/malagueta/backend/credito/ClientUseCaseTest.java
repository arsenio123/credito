package com.malagueta.backend.credito;

import com.malagueta.backend.credito.repository.impl.UserRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ClientUseCaseTest {
    @Autowired
    public UserRepositoryImpl userRepository;

    @Test
    public void testLogin(){
        userRepository.findByName("admin");
    }
}
