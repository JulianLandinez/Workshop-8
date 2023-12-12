package com.backend.JpaMysql.Repositories;

import com.backend.JpaMysql.Entities.Mensaje;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImensajesRepository extends CrudRepository<Mensaje,Long> {
}
