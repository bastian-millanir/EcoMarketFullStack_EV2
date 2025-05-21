package com.EcoMarketFullStack.EcoMarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.EcoMarketFullStack.EcoMarket.model.Envio;

@Repository
public interface EnvioRepository extends JpaRepository<Envio, Integer > {

}
