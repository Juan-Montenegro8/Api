package com.example.api.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.api.model.dto.clientedto;
import com.example.api.model.entity.cliente;
import com.example.api.service.ICliente;

import java.util.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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
    @ResponseStatus(HttpStatus.CREATED)
    public cliente create(@RequestBody clientedto ClienteDto){
        cliente Clientesave = clienteservice.save(ClienteDto);
        return cliente.builder()
            .idCliente(Clientesave.getIdCliente())
            .nombre(Clientesave.getNombre())
            .apellido(Clientesave.getApellido())
            .fechaRegistro(Clientesave.getFechaRegistro())
            .correo(Clientesave.getCorreo())
            .build();
    }
    
    @PutMapping("cliente")
    @ResponseStatus(HttpStatus.CREATED)
    public cliente update(@RequestBody clientedto ClienteDto){
        cliente Clienteupdate = clienteservice.save(ClienteDto);
        return cliente.builder()
            .idCliente(Clienteupdate.getIdCliente())
            .nombre(Clienteupdate.getNombre())
            .apellido(Clienteupdate.getApellido())
            .fechaRegistro(Clienteupdate.getFechaRegistro())
            .correo(Clienteupdate.getCorreo())
            .build();
    }

    @DeleteMapping("cliente/{id}")
    //@ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> delete(@PathVariable Integer id){
        Map<String, Object> response= new HashMap<>();
        try {
            cliente clientedelete = clienteservice.findById(id);
            clienteservice.delete(clientedelete);
            return new ResponseEntity<>(clientedelete, HttpStatus.NO_CONTENT);
        } catch (DataAccessException e) {
            response.put("mensaje",e.getMessage());
            response.put("cliente",null);

            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("cliente/{id}")
    @ResponseStatus(HttpStatus.OK)
    public clientedto showById(@PathVariable Integer id){
        cliente Cliente = clienteservice.findById(id);
        return clientedto.builder()
            .idCliente(Cliente.getIdCliente())
            .nombre(Cliente.getNombre())
            .apellido(Cliente.getApellido())
            .fechaRegistro(Cliente.getFechaRegistro())
            .correo(Cliente.getCorreo())
            .build();
    }

}
