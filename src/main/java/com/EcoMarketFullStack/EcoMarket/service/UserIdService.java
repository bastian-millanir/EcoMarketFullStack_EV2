package com.EcoMarketFullStack.EcoMarket.service;

import com.EcoMarketFullStack.EcoMarket.model.UserId;
import com.EcoMarketFullStack.EcoMarket.repository.UserIdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserIdService {

    @Autowired
    private UserIdRepository userIdRepository;

    public List<UserId> getAllUserIds() {
        return userIdRepository.findAll();
    }

    public Optional<UserId> getUserIdById(Integer id) {
        return userIdRepository.findById(id);
    }

    public UserId createUserId(UserId userId) {
        return userIdRepository.save(userId);
    }

    public UserId updateUserId(Integer id, UserId userIdDetails) {
        return userIdRepository.findById(id).map(userId -> {
            userId.setName(userIdDetails.getName());
            return userIdRepository.save(userId);
        }).orElseThrow(() -> new RuntimeException("UserId no encontrado con id: " + id));
    }

    public void deleteUserId(Integer id) {
        userIdRepository.deleteById(id);
    }
}
