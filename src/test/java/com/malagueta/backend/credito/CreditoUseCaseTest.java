package com.malagueta.backend.credito;

import com.malagueta.backend.credito.api.CreditoAPI;
import com.malagueta.backend.credito.model.Cliente;
import com.malagueta.backend.credito.model.Credito;
import com.malagueta.backend.credito.model.CreditoSatus;
import com.malagueta.backend.credito.model.User;
import com.malagueta.backend.credito.repository.impl.search.SearchCredito;
import com.malagueta.backend.credito.services.impl.CreditoService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.util.Assert;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class CreditoUseCaseTest {

    Logger logger= LoggerFactory.getLogger(CreditoUseCaseTest.class);
   @Autowired
   public CreditoService creditoService;
   @Autowired
   public SearchCredito searchCredito;
   @Autowired
   public JpaRepository<Credito, Long> creditoJpa;
   @Autowired
   public CreditoAPI creditoAPI;

   @Test
   public void testCreateCredito(){

       Credito credito=new Credito();
       credito.setAprovadoPOr(new User().setId(1));
       credito.setCreatedBy(new User().setId(1));
       credito.setJurus(30);
       credito.setDoDate(Calendar.getInstance().getTime());
       credito.setValor(500);
       credito.setEstado(CreditoSatus.VIGOR);
       credito.setCreatedDate(Calendar.getInstance().getTime());
       credito.setCliente(new Cliente().setId(4));
       Assert.notNull(creditoService.creatCredit(credito),"Teste Criar Credito Falhado: nao pode ser null");

   }

    /**
     * Listar credito por estado
     */
   @Test
   public void getAllCredit(){
       List<Credito> creditos=creditoService.listCredit();//creditoAPI.get();;
       creditos.stream().forEach(credito -> {
           System.out.println("nome do cliente "+ credito.getCliente().getNome()
                   +", credito numero: "+credito.getId()+
                   " estado "+credito.getValor());
       });
       Assert.notNull(creditoService.listCredit(), "Garanta que ha creditos na base de dados");
   }

    /**
     * Listar credito por data de aprovacao
     */
    @Test
    public void lstaCreditoByClienteAndEstado(){
/*
        Credito credito=creditoService.listCredit().get(1);
        Example<Credito> creditoExample=Example.of(Credito.from)
        creditoExemple.setCliente(credito.getCliente());
        System.out.println(" lista com "+searchCredito.
         //       findByClienteAndEstado(credito.getCliente(), credito.getEstado()).size());

        System.out.println(" lista com "+
                        searchCredito.findAll(Example.of(creditoExemple)).size());
                        */

    }

    /**
     * Listar credito por data de vencimento
     */
    @Test
    public void testarListaCreditoDataVencido(){

        /*searchCredito.findByEstado(CreditoSatus.CANCELADO).stream().forEach(c ->{
            System.out.println("Credito "+ c.getId());

        });*/
    System.out.println("********Creditos cancelados*****");
        searchCredito.findByEstadoAndBegindate(Optional.of(CreditoSatus.VIGOR.name()), Optional.empty(),Optional.empty(),Optional.empty()).stream().forEach(c ->{
            System.out.println("Credito "+ c.getId());

        });

        System.out.println("********Creditos em vigor *****");
        searchCredito.findByEstadoAndBegindate(Optional.of(CreditoSatus.VIGOR.name()), Optional.empty(),Optional.empty(),Optional.empty()).stream().forEach(c ->{
            System.out.println("Credito "+ c.getId());

        });


        System.out.println("********Creditos em vigor de 500 meticais *****");
        searchCredito.findByEstadoAndBegindate(Optional.of(CreditoSatus.VIGOR.name()), Optional.empty(),Optional.empty(),Optional.of(new Double(500))).stream().forEach(c ->{
            System.out.println("Credito "+ c.getId());

        });

        System.out.println("********Creditos em vigor de 300 meticais *****");
        Date min=Calendar.getInstance().getTime();
        searchCredito.findByEstadoAndBegindate(Optional.of(CreditoSatus.VIGOR.name()), Optional.of(min),Optional.empty(),Optional.of(new Double(300))).stream().forEach(c ->{
            System.out.println("Credito "+ c.getId());

        });

    }

    /**
     * aprovar credito
     */
    @Test
    public void aprovarCredito(){
    }

    /**
     * em caso de necessidade de atualizacao credito deve ser mandado de volta para correcao
     * return Message erros; User to correct
     */
    @Test
    public void validarCredito(){
    }



}
