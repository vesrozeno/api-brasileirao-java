package com.api.brasileirao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.brasileirao.entities.Time;

@Repository
public interface TimeRepository extends JpaRepository<Time, Integer> {
    List<Time> findByNomeIgnoreCaseAndAndIdNot(String nome, Integer id);
}
