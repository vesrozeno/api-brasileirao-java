package com.api.brasileirao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.brasileirao.entities.Jogo;

@Repository
public interface JogoRepository extends JpaRepository<Jogo, Integer> {

}
