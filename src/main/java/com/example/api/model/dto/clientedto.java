package com.example.api.model.dto;

import java.io.Serializable;
import java.util.*;
import lombok.*;

@Data
@ToString
@Builder
public class clientedto implements Serializable{

    private Integer idCliente;
    private String nombre;
    private String apellido;
    private String correo;
    private Date fechaRegistro;
}
