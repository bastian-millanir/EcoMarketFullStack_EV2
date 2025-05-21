package com.EcoMarketFullStack.EcoMarket.repository;

import com.EcoMarketFullStack.EcoMarket.model.UserId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserIdRepository extends JpaRepository<UserId, Integer> {
    // Métodos personalizados si son necesarios
}
