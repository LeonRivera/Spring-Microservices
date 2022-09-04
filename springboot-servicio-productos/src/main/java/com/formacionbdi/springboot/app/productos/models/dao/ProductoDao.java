package com.formacionbdi.springboot.app.productos.models.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.formacionbdi.springboot.app.commons.models.entity.Producto;


@Repository
public interface ProductoDao extends CrudRepository<Producto, Long>{
}
