package com.malagueta.backend.credito.services.impl;

import com.malagueta.backend.credito.model.Credito;
import com.malagueta.backend.credito.model.Garantia;
import com.malagueta.backend.credito.services.GarantiaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GarantiaServiceImpl implements GarantiaService {

    Logger logger= LoggerFactory.getLogger(GarantiaServiceImpl.class);
    @Override
    public List<Garantia> getGarantiafromCredito(int credito_Id) {

        logger.info("comecando o processo de listagem de garantia");
        List<Garantia> garantias =new ArrayList<>();
        garantias.add(new Garantia().setCredito_id(new Credito()).setDocB64("dfdfdfdfdf"));
        logger.info("fim do processo de garantia");
        return garantias;
    }
}
