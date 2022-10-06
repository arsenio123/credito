package com.malagueta.backend.credito;

import com.malagueta.backend.credito.model.Credito;
import com.malagueta.backend.credito.repository.CreditoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Calendar;

@SpringBootApplication
public class CreditoDaoImplTest {

   private CreditoRepository creditoRepository;

    @Autowired
   public CreditoDaoImplTest(CreditoRepository creditoRepository){
        this.creditoRepository = creditoRepository;
   }

   private void testCreateCredito(){
       Credito credito=new Credito();
       credito.setAprovadoPOr("Arsenio gerente");
       credito.setCreatedBy("Arsenio cliente");
       credito.setJurus(30);
       credito.setDoDate(Calendar.getInstance().getTime());
       credito.setValor(500);
       credito.setCreatedDate(Calendar.getInstance().getTime());
       creditoRepository.createCredito(credito);
   }
    public static void main(String[] args) {

        ApplicationContext cx= SpringApplication.run(CreditoDaoImplTest.class,args);
        //testCreateCredito();
        //CreditoAPI apitest=new CreditoAPI();
        //apitest.createCredito();
    }
}
