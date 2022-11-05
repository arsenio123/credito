package com.malagueta.backend.credito.services.impl;


import com.malagueta.backend.credito.model.Credito;
import com.malagueta.backend.credito.repository.ClienteRepository;
import com.malagueta.backend.credito.repository.CreditoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditoService {

    private static final Logger log= LoggerFactory.getLogger(CreditoService.class);
    @Autowired
    private CreditoRepository creditoRepository;

    public List<Credito> listCredit() {
        return creditoRepository.getAllCredit();
    }

    public List<Credito> searchCredit(Credito credito){
        return creditoRepository.getCreditBy(credito);
    }

    public Credito creatCredit(Credito credito) {
        log.debug("Inico de validacao da criacao do user "+credito);
        List<Credito> openCredits =creditoRepository.findOpenCredit(credito.getCliente());
        if(openCredits!=null && openCredits.isEmpty()) {
            log.debug("criando o credito "+credito);
            return creditoRepository.createCredito(credito);
        }else {
            log.debug("cliente nao tem permisao para ciar um novo cerdito deve fecha os"+openCredits.size() +" creditos abertos"  );
        }
        return null;
    }

    public List<Credito> listCredit(Credito credito){
        return creditoRepository.getCreditBy(credito);
    }
}
