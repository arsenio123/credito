package com.malagueta.backend.credito.services.impl;


import com.malagueta.backend.credito.model.Credito;
import com.malagueta.backend.credito.model.CreditoSatus;
import com.malagueta.backend.credito.repository.ClienteRepository;
import com.malagueta.backend.credito.repository.CreditoRepository;
import com.malagueta.backend.credito.repository.impl.search.SearchCredito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CreditoService {

    private static final Logger log= LoggerFactory.getLogger(CreditoService.class);
    @Autowired
    private CreditoRepository creditoRepository;

    @Autowired
    private SearchCredito searchCredito;

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

    public List<Credito> listarPorCreterio(String estado,
                                           Date minBeginDate,
                                           Date maxBeginDate,
                                           Double valor){
        Optional<String> estadoOp;
        Optional<Date> minBeginDateOp;
        Optional<Date> maxBeginDateOp;
        Optional<Double> valorOp;

        if (estado == null) estadoOp = Optional.empty(); else estadoOp = Optional.of(estado);
        if (minBeginDate == null) minBeginDateOp = Optional.empty(); else minBeginDateOp = Optional.of(minBeginDate);
        if (maxBeginDate == null) maxBeginDateOp = Optional.empty(); else maxBeginDateOp = Optional.of(maxBeginDate);
        if (valor == null) valorOp = Optional.empty(); else valorOp = Optional.of(valor);

        return searchCredito.findByEstadoAndBegindate(estadoOp,
                minBeginDateOp,
                maxBeginDateOp,
                valorOp);
    }

}
