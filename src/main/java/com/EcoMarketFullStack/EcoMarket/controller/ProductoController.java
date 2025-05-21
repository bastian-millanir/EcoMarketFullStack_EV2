package com.EcoMarketFullStack.EcoMarket.controller;

import com.EcoMarketFullStack.EcoMarket.model.Producto;
import com.EcoMarketFullStack.EcoMarket.service.ProductoService;
// 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/productos")

public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public ResponseEntity<List<Producto>> listar(){
        List<Producto> productos = productoService.findAll();
        if(productos.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(productos);
    }

    @PostMapping
    public ResponseEntity<Producto> guardar(@RequestBody Producto producto){
        Producto productoNuevo = productoService.save(producto);
        return ResponseEntity.status(HttpStatus.CREATED).body(productoNuevo);
    }
    
    @GetMapping("{id}")
    public ResponseEntity<Producto> buscar(@PathVariable Integer id){
        try{
            Producto producto = productoService.findById(id);
            return ResponseEntity.ok(producto);
        }
        catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Producto> actualizar(@PathVariable Integer id, @RequestBody Producto producto){
        try {
            Producto product = productoService.findById(id);
            product.setId(id);
            product.setNombre_producto(producto.getNombre_producto());
            product.setPrecio(producto.getPrecio());
            product.setStock(producto.getStock());
            

            productoService.save(product);
            return ResponseEntity.ok(producto);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Producto> eliminar(@PathVariable Integer id){
        try {
            productoService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

}
