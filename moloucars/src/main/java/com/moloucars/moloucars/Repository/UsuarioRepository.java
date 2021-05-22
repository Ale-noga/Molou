package com.moloucars.moloucars.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moloucars.moloucars.Model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
