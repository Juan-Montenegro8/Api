package com.example.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.api.model.dao.ClienteDAO;
import com.example.api.model.entity.cliente;
import com.example.api.service.ICliente;

@Service
public class ClienteImpl implements ICliente{

    @Autowired
    private ClienteDAO clienteDAO;

    @Transactional
    @Override
    public cliente save(cliente Cliente) {
        return clienteDAO.save(Cliente);
    }

    @Transactional(readOnly = true)
    @Override
    public cliente findById(Integer id) {
        return clienteDAO.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void delete(cliente Cliente) {
        clienteDAO.delete(Cliente);
    }
    

}
