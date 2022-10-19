package com.malagueta.backend.credito.api;

import com.malagueta.backend.credito.model.Garantia;
import com.malagueta.backend.credito.services.GarantiaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class GarantiasAPI {
    Logger logger= LoggerFactory.getLogger(Garantia.class);

    @Autowired
    public GarantiaService garantiaService;

    @GetMapping("/Garantia")
    public List<Garantia> listar(@RequestParam("credito_Id") int credito_Id){

        return garantiaService.getGarantiafromCredito(credito_Id);
    }

}
