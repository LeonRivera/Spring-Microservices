package com.formacionbdi.springboot.app.commons.usuarios.models.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable{
    

    static final Long serialVersionUID  = 3L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, length = 20)
    private String username;

    @Column(length = 60)
    private String password;

    private Boolean enabled;
    private String nombre;
    private String apellido;

    @Column(unique = true,length = 120)
    private String email;

    // With lazy we only get the roles calling the getter of the list 
    // With eager we get all roles in the user
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "usuarios_roles",
     joinColumns = @JoinColumn(name = "usuario_id"),
     inverseJoinColumns = @JoinColumn(name ="role_id"),
     //A user can't repeat the same role
    //  1 - 1
    //  1 - 1
     uniqueConstraints = {@UniqueConstraint(columnNames = {"usuario_id", "role_id"})})
    private List<Role> roles;


    private Integer intentos;

}
