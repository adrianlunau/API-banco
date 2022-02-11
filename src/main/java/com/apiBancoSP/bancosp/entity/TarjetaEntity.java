package com.apiBancoSP.bancosp.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tarjeta")
@Getter
@Setter
public class TarjetaEntity {

    @Id
    private String nroDeCuenta;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_cliente", insertable = false, updatable = false)
    private ClienteEntity cliente;

    @Column(name = "id_cliente", nullable = false)
    private Long clienteId;

    private Integer pin;

    private Double saldo;


    @OneToMany(mappedBy = "tarjetaOrigen", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TransaccionEntity> transacciones = new ArrayList<>();


}
