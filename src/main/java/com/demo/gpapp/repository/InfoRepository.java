package com.demo.gpapp.repository;

import com.demo.gpapp.entity.InfoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfoRepository extends CrudRepository<InfoEntity, Long> {
}

