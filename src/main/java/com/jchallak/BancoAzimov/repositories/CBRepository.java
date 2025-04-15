package com.jchallak.BancoAzimov.repositories;

import com.jchallak.BancoAzimov.entities.ContaBancaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CBRepository extends JpaRepository<ContaBancaria, Long> {
    Long deleteByNumeroConta(String numeroConta);
    Optional<ContaBancaria> findByNumeroConta(String numeroConta);
}
