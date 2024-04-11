package com.payment.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.payment.demo.model.Funcionario;

import java.io.IOException;
import java.util.List;

@Component
public class LeitorJSON {

    @Autowired
    private ResourceLoader resourceLoader;

    @Autowired
    private ObjectMapper objectMapper;

    public List<Funcionario> loadFuncionarios() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:resources/funcionarios.json");
        List<Funcionario> funcionarios = objectMapper.readValue(resource.getFile(), new TypeReference<List<Funcionario>>(){});
        return funcionarios;
    }
}