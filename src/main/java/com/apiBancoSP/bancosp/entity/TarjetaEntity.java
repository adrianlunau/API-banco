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


    @OneToMany(mappedBy = "tarjetaDestino",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TransaccionEntity> transaccionesEntrantes = new ArrayList<>();

    @OneToMany(mappedBy = "tarjetaOrigen",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TransaccionEntity> transaccionesSalientes = new ArrayList<>();



    public void descontarSaldo(Double monto){
        this.saldo-=monto;
    }

    public void agregarSaldo(Double monto){
        this.saldo+=monto;
    }

    public void agregarTransaccionEntrante(TransaccionEntity entity){
        transaccionesEntrantes.add(entity);
    }

    public void agregarTransaccionSaliente(TransaccionEntity entity) { transaccionesSalientes.add(entity); }



    public Boolean puedeTransferir(Double monto) {
        if (monto <= this.saldo) {
            return true;
        }
        return false;
    }

}
