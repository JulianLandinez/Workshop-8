package com.backend.JpaMysql.Repositories;

import com.backend.JpaMysql.Entities.Publicacion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IpublicacionRepository extends CrudRepository<Publicacion,Long> {
}
