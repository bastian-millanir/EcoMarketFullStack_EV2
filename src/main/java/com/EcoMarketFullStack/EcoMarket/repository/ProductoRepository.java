package com.EcoMarketFullStack.EcoMarket.repository;

import com.EcoMarketFullStack.EcoMarket.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    List<Producto> findByNombre_producto(String nombre_producto); 
    
    Producto findByid(Integer id);

    List<Producto> findByNombre_productoAndId(String nombre_producto, Integer id);

    @Query("SELECT p FROM Producto p WHERE p.nombre_producto= :nombre_producto")
    List<Producto> buscarPorNombre_Productos(@Param("nombre_producto") String nombre_producto);

    @Query(value="SELECT * FROM producto WHERE id = :id", nativeQuery= true)
    Producto buscarPorId(@Param("id") Integer id); //

}
