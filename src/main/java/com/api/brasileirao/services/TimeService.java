package com.api.brasileirao.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.brasileirao.entities.Time;
import com.api.brasileirao.repository.TimeRepository;

@Service
public class TimeService {

    @Autowired
    private TimeRepository repository;

    public void cadastrarTime(Time time) {
        repository.save(time);
    }

    public List<Time> listarTimes() {
        return repository.findAll();
    }

    public Time obterTime(Integer id) {
        return repository.findById(id).get();
    }

}
