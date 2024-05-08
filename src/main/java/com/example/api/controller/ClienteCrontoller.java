package com.example.api.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.api.model.entity.cliente;
import com.example.api.service.ICliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api/v1")
public class ClienteCrontoller {
    
    @Autowired
    private ICliente clienteservice;

    @PostMapping("cliente")
    public cliente create(@RequestBody cliente Cliente){
        return clienteservice.save(Cliente);
    }
    
    @PutMapping("cliente")
    public cliente update(@RequestBody cliente Cliente){
        return clienteservice.save(Cliente);
    }

    @DeleteMapping("cliente/{id}")
    public void delete(@PathVariable Integer id){
        cliente clientedelete = clienteservice.findById(id);
        clienteservice.delete(clientedelete);
    }

    @GetMapping("cliente/{id}")
    public cliente showById(@PathVariable Integer id){
        return clienteservice.findById(id);
    }

}
