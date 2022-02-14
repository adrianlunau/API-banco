package com.apiBancoSP.bancosp.repository;


import com.apiBancoSP.bancosp.entity.TransaccionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransaccionRepository extends JpaRepository<TransaccionEntity, Long> {

    //@Query("select t from TransaccionEntity t where t.tarjeta_origen = :nroTarjeta")
    //List<TransaccionEntity> findLastTenTransaction(@Param("nroTarjeta") String nroTarjeta);
}
