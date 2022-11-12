package com.malagueta.backend.credito.model.billing;

import com.malagueta.backend.credito.model.Credito;

import javax.persistence.*;

@Entity
public class Divida {
    @Id
    private int id;

    @OneToOne(cascade = {CascadeType.ALL})
    private Credito credito;
    
    private String descricao;
    private double valorEmDivida;

    //@Enumerated(EnumType.STRING)
    private enum EstadoDivida{
        EM_VIGOR("EM_VIGOR"),EXPIRADO("EXPIRADO"),SALDADO("SALDADO");
        private final String estado;

        EstadoDivida(final String estado) {
            this.estado=estado;
        }
    }

    public int getId() {
        return id;
    }

    public Divida setId(int id) {
        this.id = id;
        return this;
    }

    public Credito getCredito() {
        return credito;
    }

    public Divida setCredito(Credito credito) {
        this.credito = credito;
        return this;
    }

    public String getDescricao() {
        return descricao;
    }

    public Divida setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public double getValorEmDivida() {
        return valorEmDivida;
    }

    public Divida setValorEmDivida(double valorEmDivida) {
        this.valorEmDivida = valorEmDivida;
        return this;
    }
}
