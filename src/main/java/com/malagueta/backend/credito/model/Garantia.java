package com.malagueta.backend.credito.model;

import javax.persistence.*;

@Entity
public class Garantia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String docB64;

    @OneToOne
    private Credito credito_id;

    private enum estado{};

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Garantia setDocB64(String docB64) {
        this.docB64 = docB64;
        return this;
    }

    public Garantia setCredito_id(Credito credito_id) {
        this.credito_id = credito_id;
        return this;
    }
}
