package com.EcoMarketFullStack.EcoMarket.repository;

import com.EcoMarketFullStack.EcoMarket.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

    List<Usuario> findByApellidos(String apellidos);
    
    Usuario findByEmail(String email);

    List<Usuario> findByNombresAfterAndApellidos(String nombres, String Apellidos);

    @Query("SELECT p FROM Usuario p WHERE p.apellidos= :ap")
    List<Usuario> buscarPorApellidos(@Param("apellidos") String ap);

    @Query(value="SELECT * FROM Usuario WHERE email = :email", nativeQuery= true)
    Usuario buscarPorEmail(@Param("email") String email);
}
