package com.backend.JpaMysql.Repositories;

import com.backend.JpaMysql.Entities.Amistad;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IamistadRepository extends CrudRepository<Amistad,Long> {

    List<Amistad> findByIsaceptadoIsTrue();
    boolean existsBySolicitanteIdAndSolicitadoId(Long solicitanteId, Long solicitadoId);

}
