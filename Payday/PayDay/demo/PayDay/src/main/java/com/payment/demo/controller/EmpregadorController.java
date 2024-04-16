package com.payment.demo.controller;

import java.io.IOException;
import java.io.File;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/empregadores")
public class EmpregadorController {

    private ObjectMapper objectMapper = new ObjectMapper();


    @GetMapping("/get")
    public ResponseEntity<Object> getData() throws IOException {
        Object data = objectMapper.readValue(new File("C:\\Users\\gabri\\OneDrive\\Área de Trabalho\\Nova pasta\\PayDay\\Payday\\PayDay\\demo\\PayDay\\src\\main\\resources\\empregador.json"), Object.class);
        return ResponseEntity.ok(data);
    }

}
