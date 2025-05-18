package com.EcoMarketFullStack.EcoMarket.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.EcoMarketFullStack.EcoMarket.service.PedidoService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.EcoMarketFullStack.EcoMarket.model.Pedido;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController

@RequestMapping("api/v1/pedidos")
public class PedidoController {

    @Autowired
     private PedidoService pedidoService;


    @GetMapping
    public ResponseEntity <List<Pedido>> listar (){
        List <Pedido> pedidos = pedidoService.findAll();
        if (pedidos.isEmpty()){
            return ResponseEntity.noContent().build();

        }
        return ResponseEntity.ok(pedidos);
    }
    
    @PostMapping
     public ResponseEntity<Pedido> guardar(@RequestBody Pedido pedido){
        Pedido pedidoNuevo = pedidoService.save(pedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoNuevo);
     }
    
    
    @GetMapping("{id}")
    public ResponseEntity<Pedido> buscar (@PathVariable Integer id){
       try{
        Pedido pedido = pedidoService.findById((id));
        return ResponseEntity.ok(pedido);
       }
       catch(Exception e){
        return ResponseEntity.notFound().build();
       }
    }
    
    @PutMapping("{id}")
    public ResponseEntity<Pedido> actualizar(@PathVariable Integer id, @RequestBody Pedido pedido) {
        try{
          Pedido pedi = pedidoService.findById(id);

          pedi.setId(id);
          pedi.setFecha_pedido(pedido.getFecha_pedido());
          pedi.setHora_pedido(pedido.getHora_pedido());
          pedi.setCosto(pedido.getCosto());
          pedi.setComentario(pedido.getComentario());
          pedi.setDireccionEntrega(pedido.getDireccionEntrega());
          
          pedidoService.save(pedi);
          return ResponseEntity.ok(pedido);
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
        
    @DeleteMapping("{id}")
    public ResponseEntity<Pedido> eliminar(@PathVariable Integer id){
        try{
            pedidoService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
     }    


    
 }
     



