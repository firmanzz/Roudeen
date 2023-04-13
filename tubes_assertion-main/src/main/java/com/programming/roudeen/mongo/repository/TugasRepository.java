package com.programming.techie.mongo.repository;

import com.programming.techie.mongo.model.Tugas;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface TugasRepository extends MongoRepository<Tugas, String> {
    @Query("{'name': ?0}")
    Optional<Tugas> findByName(String name);
}
