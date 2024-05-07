package com.example.api.service;

import com.example.api.model.entity.cliente;

public interface ICliente {

    cliente save(cliente Cliente);

    cliente findById(Integer id);

    void delete(cliente Cliente);
}
