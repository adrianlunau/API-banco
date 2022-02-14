package com.apiBancoSP.bancosp.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "transaccion")
@Getter
@Setter
public class TransaccionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idTransaccion;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "tarjeta_origen", insertable = false, updatable = false)
    private TarjetaEntity tarjetaOrigen;

    @Column(name = "tarjeta_origen", nullable = false)
    private String nroTarjetaOrigen;

    private Double monto;

    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate fecha;


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "tarjeta_destino", insertable = false, updatable = false)
        private TarjetaEntity tarjetaDestino;

    @Column(name = "tarjeta_destino", nullable = false)
    private String nroTarjetaDestino;

}
