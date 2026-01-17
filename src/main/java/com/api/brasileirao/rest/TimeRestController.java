package com.api.brasileirao.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.brasileirao.entities.Time;
import com.api.brasileirao.services.TimeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping(value = "/times")
public class TimeRestController {

    @Autowired
    private TimeService timeService;

    @GetMapping
    public ResponseEntity<List<Time>> getTimes() {
        return ResponseEntity.ok().body(timeService.listarTimes());
    }

    @Operation(summary = "Lista os times", description = "Retorna a lista de times cadastrados no Brasileirão")
    @GetMapping(value = "{id}")
    public ResponseEntity<Time> getTime(@PathVariable Integer id) {
        return ResponseEntity.ok().body(timeService.obterTime(id));
    }

    @PostMapping
    public ResponseEntity<Void> cadastrarTime(@RequestBody Time time) {
        timeService.cadastrarTime(time);
        return ResponseEntity.ok().build();
    }

}
