package com.EcoMarketFullStack.EcoMarket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EcoMarketFullStack.EcoMarket.model.Envio;
import com.EcoMarketFullStack.EcoMarket.repository.EnvioRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EnvioService {
   
    @Autowired
    private EnvioRepository envioRepository;

    public List<Envio> findAll(){
        return envioRepository.findAll();
    }

    public Envio findById(Integer id){
        return envioRepository.findById(id).get();
    }

    public Envio save(Envio envio){
        return envioRepository.save(envio);
    }

    public void delete (Integer id){
        envioRepository.deleteById(id);
    }
}
