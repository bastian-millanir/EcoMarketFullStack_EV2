package com.EcoMarketFullStack.EcoMarket.repository;

import com.EcoMarketFullStack.EcoMarket.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

    List<Usuario> findByApellido(String apellido);
    
    Usuario findByCorreo(String correo);

    List<Usuario> findByNombreAndApellido(String nombre, String Apellido);

    @Query("SELECT p FROM Usuario p WHERE p.apellidos= :ap")
    List<Usuario> buscarPorApellido(@Param("apellido") String ap);

    @Query(value="SELECT * FROM paciente WHERE correo = :correo", nativeQuery= true)
    Usuario buscarPorCorreo(@Param("correo") String correo);
}
