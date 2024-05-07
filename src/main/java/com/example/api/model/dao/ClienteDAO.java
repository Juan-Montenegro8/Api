package com.example.api.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.api.model.entity.cliente;

public interface ClienteDAO extends CrudRepository<cliente, Integer>{
    
}
