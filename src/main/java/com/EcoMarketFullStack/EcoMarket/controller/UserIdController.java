package com.EcoMarketFullStack.EcoMarket.controller;

import com.EcoMarketFullStack.EcoMarket.model.UserId;
import com.EcoMarketFullStack.EcoMarket.service.UserIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/userIds")
public class UserIdController {

    @Autowired
    private UserIdService userIdService;

    @GetMapping
    public List<UserId> getAllUserIds() {
        return userIdService.getAllUserIds();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserId> getUserIdById(@PathVariable Integer id) {
        return userIdService.getUserIdById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public UserId createUserId(@RequestBody UserId userId) {
        return userIdService.createUserId(userId);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserId> updateUserId(@PathVariable Integer id, @RequestBody UserId userIdDetails) {
        try {
            return ResponseEntity.ok(userIdService.updateUserId(id, userIdDetails));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserId(@PathVariable Integer id) {
        userIdService.deleteUserId(id);
        return ResponseEntity.noContent().build();
    }
}
