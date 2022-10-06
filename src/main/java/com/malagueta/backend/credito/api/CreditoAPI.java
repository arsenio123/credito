package com.malagueta.backend.credito.api;

import com.malagueta.backend.credito.model.Credito;
import com.malagueta.backend.credito.services.impl.CreditoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class CreditoAPI {
    private CreditoService creditoService;

    @Autowired
    public CreditoAPI(CreditoService creditoService){
        this.creditoService=creditoService;
    }


    @PostMapping("credito/creat")
    @PreAuthorize("hasAuthority('ROLE_CREDITOS')")
    public Credito createCredito(@RequestBody Credito credito)
    {
        return creditoService.creatCredito(credito);
    }

    @GetMapping("hello")
    public String hello()
    {
        return "Hello";
    }


    @GetMapping("credito/list")
    @PreAuthorize("hasAuthority('ROLE_CREDITOS')")
    public List<Credito> get(){
        System.out.println("iniciando o get de creditos");
        return creditoService.getCreditoRepository();
    }
}
