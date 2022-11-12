package com.malagueta.backend.credito;

import com.malagueta.backend.credito.model.Producto;
import com.malagueta.backend.credito.model.ProductoEstados;
import com.malagueta.backend.credito.services.ServicoProducto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductoUseCaseTest {

    @Autowired
    private ServicoProducto servicoProducto;

    @Test
    public void creatProducto(){
        Producto producto =new Producto();
        producto.setDesc("credito vale 100");
        producto.setCapitalMax(1000);
        producto.setCapitalMin(100);
        producto.setTaxa(5);
        producto.setEstado(ProductoEstados.NORMAL);

        servicoProducto.creat(producto);
    }
}
