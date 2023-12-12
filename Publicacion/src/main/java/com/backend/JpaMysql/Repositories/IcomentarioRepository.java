package com.backend.JpaMysql.Repositories;

import com.backend.JpaMysql.Entities.Comentario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IcomentarioRepository extends CrudRepository<Comentario,Long> {
}
