package com.apiBancoSP.bancosp.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
@Getter
@Setter
public class ClienteEntity {

    @Id
    private Long idCliente;

    private String nombre;
}
