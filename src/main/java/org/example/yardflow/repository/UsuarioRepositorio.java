package org.example.yardflow.repository;


import org.example.yardflow.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends JpaRepository <Long, Usuario>{


}
