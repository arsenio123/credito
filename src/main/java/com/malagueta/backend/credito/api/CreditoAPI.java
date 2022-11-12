package com.malagueta.backend.credito.api;

import com.malagueta.backend.credito.model.Credito;
import com.malagueta.backend.credito.model.CreditoSatus;
import com.malagueta.backend.credito.model.User;
import com.malagueta.backend.credito.repository.impl.search.SearchCredito;
import com.malagueta.backend.credito.services.impl.CreditoService;
import com.malagueta.backend.credito.values.Estados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@RestController
public class CreditoAPI {
    @Autowired
    private CreditoService creditoService;

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
        List<Credito> list=creditoService.listCredit();

        System.out.println("numero de creditos: "+list.size());
        list.stream().forEach(credito -> {
            System.out.println("credito: "+credito.getId()+",  "+credito);
        });
        return list;
    }

    @GetMapping("credito/list/critirea")
    //@PreAuthorize("hasAuthority('ROLE_CREDITOS')")
    public List<Credito> getbyCritirea(@RequestParam(name="estado" ,required = false) String estado,
                             @RequestParam(name="minBeginDate", required = false)Date minBeginDate,
                             @RequestParam(name="maxBeginDate", required = false)Date maxBeginDate,
                             @RequestParam(name="valor", required = false) Double valor) {
        return creditoService.listarPorCreterio(estado,minBeginDate,maxBeginDate,valor);

    }
}
