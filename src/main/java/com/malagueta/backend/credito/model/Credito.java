package com.malagueta.backend.credito.model;


import javax.persistence.*;
import java.util.Date;
import java.util.Set;


@Entity
public class Credito {
    //dados de auditoria
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Date createdDate;
    private Date updateDate;
    @OneToOne(cascade = {CascadeType.ALL})
    private User createdBy; // este campo no futoro vai conter o Objecto user
    @OneToOne
    private User aprovadoPOr; // este campo vai conter o user que aprovou o credito
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="cliente_id", nullable=false)
    private Cliente cliente;// este capo no futuro vai conter o Cliente a quem está associado o Credito
    //@Enumerated(EnumType.STRING)
    private long valor;
    private Date doDate;
    private CreditoSatus estado;
    private double jurus;

    @OneToMany
    private Set<Garantia> garanias;


    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public User getAprovadoPOr() {
        return aprovadoPOr;
    }

    public void setAprovadoPOr(User aprovadoPOr) {
        this.aprovadoPOr = aprovadoPOr;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public long getValor() {
        return valor;
    }

    public void setValor(long valor) {
        this.valor = valor;
    }




    public Date getDoDate() {
        return doDate;
    }

    public void setDoDate(Date doDate) {
        this.doDate = doDate;
    }

    public double getJurus() {
        return jurus;
    }

    public void setJurus(double jurus) {
        this.jurus = jurus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CreditoSatus getEstado() {
        return estado;
    }

    public Credito setEstado(CreditoSatus estado) {
        this.estado = estado;
        return this;
    }

    public Set<Garantia> getGaranias() {
        return garanias;
    }

    public Credito setGaranias(Set<Garantia> garanias) {
        this.garanias = garanias;
        return this;
    }

    public String toString(){
        StringBuilder builder=new StringBuilder();
        builder.append("Credito [");
        builder.append("cliente:"+getCliente());
        return builder.toString();
    }
}
