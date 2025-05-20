package com.EcoMarketFullStack.EcoMarket.service;

import com.EcoMarketFullStack.EcoMarket.model.Producto;
import com.EcoMarketFullStack.EcoMarket.model.Usuario;
import com.EcoMarketFullStack.EcoMarket.repository.ProductoRepository;
import com.EcoMarketFullStack.EcoMarket.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
// 
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
