package com.example.api.service;

import com.example.api.model.dto.clientedto;
import com.example.api.model.entity.cliente;

public interface ICliente {

    cliente save(clientedto Cliente);

    cliente findById(Integer id);

    void delete(cliente Cliente);

    boolean existsById(Integer id);
}
