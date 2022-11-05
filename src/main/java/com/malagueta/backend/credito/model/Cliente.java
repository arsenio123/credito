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

    @OneToMany
    private Set<Documento> documento;

    @OneToMany(mappedBy="cliente")
    private Set<Credito> creditos;

    public int getId() {
        return id;
    }

    public Cliente setId(int id) {
        this.id = id;
        return this;
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

    public Set<Documento> getDocumento() {
        return documento;
    }

    public Cliente setDocumento(Set<Documento> documento) {
        this.documento = documento;
        return this;
    }
}
