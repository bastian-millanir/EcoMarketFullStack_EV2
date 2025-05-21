package com.EcoMarketFullStack.EcoMarket.repository;

import com.EcoMarketFullStack.EcoMarket.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    List<Producto> findByNombreProductos(String nombre_producto); 
    
    Producto findBySku(Integer id);

    List<Producto> findByNombreProductoAndSku(String nombre_producto, Integer id);

    @Query("SELECT p FROM Producto p WHERE p.nombre_producto= :np")
    List<Producto> buscarPorNombreProducto(@Param("nombre_producto") String np);

    @Query(value="SELECT * FROM Producto WHERE id = :id", nativeQuery= true)
    Producto buscarPorIProducto(@Param("id") Integer id); //

}
