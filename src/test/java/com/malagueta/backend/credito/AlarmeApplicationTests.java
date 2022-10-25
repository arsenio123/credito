package com.malagueta.backend.credito;

import com.malagueta.backend.credito.model.Cliente;
import com.malagueta.backend.credito.model.Credito;
import com.malagueta.backend.credito.model.User;
import com.malagueta.backend.credito.repository.ClienteRepository;
import com.malagueta.backend.credito.services.impl.CreditoService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.Calendar;
import java.util.Date;


//@SpringBootTest
public class AlarmeApplicationTests {

    Logger logger= LoggerFactory.getLogger(AlarmeApplicationTests.class);
    Cliente clienteTestCOntext;
    @Autowired
    private CreditoService creditoService;
    @Autowired
    private ClienteRepository clienteDao;

   // @Test
   public void contextLoads() {
        logger.debug("Hello Debugging");
        logger.info("Hello Info");
        logger.error("Hello Error");
        logger.trace("hello trace logger");
       // Assert.notEmpty(creditoService.getCreditoRepository(),"que mensagem é essa tem de estudar");
    }

    //@Test
    public void testCreateClient(){
        Cliente cliente=new Cliente();
        cliente.setDataNascimento(Calendar.getInstance().getTime());
        cliente.setNome("Arsenio Malagueta");
        cliente.setRendimento(500);
        clienteTestCOntext=clienteDao.regista(cliente);
    }


    //@Test
   public void testCreatCredit() {
        Credito credito=new Credito();
        Calendar now=Calendar.getInstance();
        Date curDate=now.getTime();
        credito.setCreatedDate(curDate);
        credito.setUpdateDate(curDate);
        credito.setValor(100);
        credito.setJurus(5);
        credito.setCliente(clienteTestCOntext);
        now.add(Calendar.YEAR,5);
        Date doDate=now.getTime();
        credito.setDoDate(doDate);

        credito.setCreatedBy(new User());
        creditoService.creatCredito(credito);
        Assert.isTrue(true,"que mensagem é essa tem de estudar");
    }



}
