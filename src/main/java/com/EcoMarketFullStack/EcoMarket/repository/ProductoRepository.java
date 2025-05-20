package com.EcoMarketFullStack.EcoMarket.repository;

import com.EcoMarketFullStack.EcoMarket.model.Producto;
import com.EcoMarketFullStack.EcoMarket.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    List<Producto> findByNombreProductos(String nombreProducto); // cambiar atributo en Model Producto 
    
    Producto findBySku(Integer sku);

    List<Producto> findByNombreProductoAndSku(String nombreProducto, Integer sku);

    @Query("SELECT p FROM Producto p WHERE p.nombreProducto= :np")
    List<Producto> buscarPorNombreProducto(@Param("nombreProducto") String np);

    @Query(value="SELECT * FROM Producto WHERE sku = :sku", nativeQuery= true)
    Producto buscarPorSku(@Param("sku") Integer sku);

}
