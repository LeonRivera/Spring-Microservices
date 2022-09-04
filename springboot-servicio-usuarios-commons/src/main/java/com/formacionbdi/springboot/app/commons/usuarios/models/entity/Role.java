package com.formacionbdi.springboot.app.commons.usuarios.models.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.io.Serializable;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "roles")
public class Role implements Serializable{
    static final Long serialVersionUID  = 3L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = true, length = 30)
    private String nombre;

    //Multidirectional
    // @ManyToMany(mappedBy = "roles")
    // private List<Usuario> usuarios;
}
