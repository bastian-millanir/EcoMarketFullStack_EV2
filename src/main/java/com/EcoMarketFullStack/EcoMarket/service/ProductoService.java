package com.EcoMarketFullStack.EcoMarket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EcoMarketFullStack.EcoMarket.model.Producto;
import com.EcoMarketFullStack.EcoMarket.repository.ProductoRepository;

import jakarta.transaction.Transactional;
//  FIX IMPORT
@Service
@Transactional
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> findAll(){
        return productoRepository.findAll();
    }

    public Producto findById(Integer id){
        return productoRepository.findById(id).get();
    }

    public Producto save(Producto producto){
        return productoRepository.save(producto);
    }

    public void delete(Integer id){
        productoRepository.deleteById(id);
    }

}
