package com.malagueta.backend.credito.model;


import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private Date dataNascimento;
    private Integer rendimento;

    @OneToMany(mappedBy="cliente")
    private Set<Credito> creditos;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Integer getRendimento() {
        return rendimento;
    }

    public void setRendimento(Integer rendimento) {
        this.rendimento = rendimento;
    }

    public Set<Credito> getCreditos() {
        return creditos;
    }

    public void setCreditos(Set<Credito> creditos) {
        this.creditos = creditos;
    }
}
