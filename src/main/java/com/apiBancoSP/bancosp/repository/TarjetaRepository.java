package com.apiBancoSP.bancosp.repository;

import com.apiBancoSP.bancosp.entity.TarjetaEntity;
import com.apiBancoSP.bancosp.entity.TransaccionEntity;
import org.hibernate.annotations.Sort;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TarjetaRepository extends JpaRepository<TarjetaEntity, String> {

    @Query(value = "select t.transaccionesSalientes from TarjetaEntity t where t.nroDeCuenta = :nroTarjeta order by fecha")
    List<TransaccionEntity> findLastTenTransaccionesSalientes(@Param("nroTarjeta") String nroTarjeta, Pageable pageable);

    @Query(value = "select t.transaccionesEntrantes from TarjetaEntity t where t.nroDeCuenta = :nroTarjeta order by fecha")
    List<TransaccionEntity> findLastTenTransaccionesEntrantes(@Param("nroTarjeta") String nroTarjeta, Pageable pageable);
}
