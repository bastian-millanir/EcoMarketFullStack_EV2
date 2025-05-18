package com.EcoMarketFullStack.EcoMarket.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import jakarta.transaction.Transactional;

@Service
@Transactional

public class PedidoService {

    @Autowired
    private PedidoRepository PedidoRepository;

    public Pedido findById(Integer id) {
        return PedidoRepository.findById(id).get();
    }

    public List <Pedido> findAll(){
        return PedidoRepository.findAll();

    }

    public Pedido save (Pedido pedi){
        return PedidoRepository.save(pedi);

    
    }
    
    public void delete (Integer id){  
        PedidoRepository.deleteById(id);
    }
}
