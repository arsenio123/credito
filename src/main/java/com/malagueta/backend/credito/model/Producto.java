package com.malagueta.backend.credito.model;

import javax.persistence.*;

@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private long taxa;
    private long capitalMin;
    private long capitalMax;
    private String descricao;

    private ProductoEstados estado;

    public Integer getId() {
        return id;
    }

    public Producto setId(Integer id) {
        this.id = id;
        return this;
    }

    public long getTaxa() {
        return taxa;
    }

    public Producto setTaxa(long taxa) {
        this.taxa = taxa;
        return this;
    }

    public long getCapitalMin() {
        return capitalMin;
    }

    public Producto setCapitalMin(long capitalMin) {
        this.capitalMin = capitalMin;
        return this;
    }

    public long getCapitalMax() {
        return capitalMax;
    }

    public Producto setCapitalMax(long capitalMax) {
        this.capitalMax = capitalMax;
        return this;
    }

    public String getDesc() {
        return descricao;
    }

    public Producto setDesc(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public ProductoEstados getEstado() {
        return estado;
    }

    public Producto setEstado(ProductoEstados estado) {
        this.estado = estado;
        return this;
    }
}
