package com.malagueta.backend.credito.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Documento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String tipo;
    private String numero;
    private Date dataValidade;
    private Date dataEmissao;
    @OneToOne
    private Cliente client;
}
