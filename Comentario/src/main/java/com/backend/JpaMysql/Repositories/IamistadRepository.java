package com.backend.JpaMysql.Repositories;

import com.backend.JpaMysql.Entities.Amistad;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IamistadRepository extends CrudRepository<Amistad,Long> {
}
