package com.malagueta.backend.credito;

import com.malagueta.backend.credito.model.Cliente;
import com.malagueta.backend.credito.model.Credito;
import com.malagueta.backend.credito.model.User;
import com.malagueta.backend.credito.repository.CreditoRepository;
import com.malagueta.backend.credito.services.impl.CreditoService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.Calendar;
import java.util.List;

@SpringBootTest
public class CreditoUseCaseTest {

    Logger logger= LoggerFactory.getLogger(CreditoUseCaseTest.class);
   @Autowired
   public CreditoService creditoService;

   @Test
   public void testCreateCredito(){

       Credito credito=new Credito();
       credito.setAprovadoPOr(new User().setId(1));
       credito.setCreatedBy(new User().setId(1));
       credito.setJurus(30);
       credito.setDoDate(Calendar.getInstance().getTime());
       credito.setValor(500);
       credito.setCreatedDate(Calendar.getInstance().getTime());
       credito.setCliente(new Cliente().setId(4));
       Assert.notNull(creditoService.creatCredit(credito),"Teste Criar Credito Falhado: nao pode ser null");

   }

    /**
     * Listar credito por estado
     */
   @Test
   public void getAllCredit(){
       List<Credito> creditos=creditoService.listCredit();
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
    public void testarListaCreditoDataAprovacao(){
    }

    /**
     * Listar credito por data de vencimento
     */
    @Test
    public void testarListaCreditoDataVencido(){
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
