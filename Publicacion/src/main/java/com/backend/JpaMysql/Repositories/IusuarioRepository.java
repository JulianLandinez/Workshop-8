package com.backend.JpaMysql.Repositories;

import com.backend.JpaMysql.Entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface IusuarioRepository extends JpaRepository<Usuario,Long> {

     Usuario findByNombre(String nombre);
}
