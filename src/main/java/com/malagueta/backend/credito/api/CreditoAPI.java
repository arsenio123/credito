package com.malagueta.backend.credito.api;

import com.malagueta.backend.credito.model.Credito;
import com.malagueta.backend.credito.model.User;
import com.malagueta.backend.credito.services.impl.CreditoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class CreditoAPI {
    private CreditoService creditoService;

    @Autowired
    public CreditoAPI(CreditoService creditoService){
        this.creditoService=creditoService;
    }


    @PostMapping("credito/creat")
    public Credito createCredito(@RequestBody Credito credito)
    {
        return creditoService.creatCredit(credito);
    }

    @GetMapping("hello")
    @CrossOrigin
    public User hello()
    {
        return new User().setName("Arsenio Malagueta").setSenha("secret");
    }


    @GetMapping("credito/list")
    @PreAuthorize("hasAuthority('ROLE_CREDITOS')")
    public List<Credito> get(){
        System.out.println("iniciando o get de creditos");
        return creditoService.listCredit();
    }
}
