package com.api.brasileirao.dto;

import com.api.brasileirao.entities.Time;

import lombok.Data;

@Data
public class JogoDTO {
    private Integer id;
    private Time timeMandante;
    private Time timeVisitante;
    private Integer golsTimeMandante;
    private Integer golsTimeVisitante;
    private Integer publicoPagante;
}
