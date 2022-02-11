package com.apiBancoSP.bancosp.repository;

import com.apiBancoSP.bancosp.entity.TarjetaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarjetaRepository extends JpaRepository<TarjetaEntity, String> {
}
