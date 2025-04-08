package com.senai.Atividade_Pontuada_API_REST_com_Spring_Boot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestController
@RequestMapping("/dev")

public class Dev {
    @GetMapping
    public String dev(){
        return "Desenvolvedor: Clara Lemos";
    }
}
