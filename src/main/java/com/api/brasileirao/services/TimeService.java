package com.api.brasileirao.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.brasileirao.dto.TimeDTO;
import com.api.brasileirao.entities.Time;
import com.api.brasileirao.repository.TimeRepository;

@Service
public class TimeService {

    @Autowired
    private TimeRepository repository;

    public TimeDTO cadastrarTime(TimeDTO time) throws Exception {
        if (timeJaExiste(time.getNome(), 0)) {
            throw new Exception(String.format("Time %s já existe.", time.getNome()));

        } else {
            Time timeEntity = toEntity(time);
            return toDTO(repository.save(timeEntity));
        }
    }

    private Boolean timeJaExiste(String nome, Integer id) {
        return !repository.findByNomeIgnoreCaseAndAndIdNot(nome, id).isEmpty();
    }

    public List<TimeDTO> listarTimes() {
        return repository.findAll().stream().map(entity -> toDTO(entity)).collect(Collectors.toList());
    }

    public TimeDTO obterTime(Integer id) {
        return toDTO(repository.findById(id).get());
    }

    private Time toEntity(TimeDTO time) {
        Time entity = new Time();
        entity.setNome(time.getNome());
        entity.setEstadio(time.getEstadio());
        entity.setUf(time.getUf());
        entity.setSigla(time.getSigla());
        return entity;
    }

    private TimeDTO toDTO(Time time) {
        TimeDTO dto = new TimeDTO();
        dto.setNome(time.getNome());
        dto.setEstadio(time.getEstadio());
        dto.setUf(time.getUf());
        dto.setSigla(time.getSigla());
        return dto;
    }

}
