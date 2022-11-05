package com.malagueta.backend.credito.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String senha;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns= @JoinColumn(name =  "role_id"))
    private Set<Role> roles;

    public int getId() {
        return id;
    }

    public User setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getSenha() {
        return senha;
    }

    public User setSenha(String senha) {
        this.senha = senha;
        return this;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public User setRoles(Set<Role> roles) {
        this.roles = roles;
        return this;
    }

    public String toString(){
        StringBuilder builder=new StringBuilder();
        builder.append("User [ userName: ");
        builder.append(name);
        builder.append(", role, ");
        roles.forEach(role->builder.append(role.getDescricao()+","));
        builder.append("]");
        return builder.toString();
    }
}
