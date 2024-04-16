package com.payment.demo.service;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.payment.demo.model.Empregador;

import java.io.File;

@Service
public class EmpregadorService {
    private static final String FILE_PATH = "C:\\Users\\gabri\\OneDrive\\Área de Trabalho\\Nova pasta\\PayDay\\Payday\\PayDay\\demo\\PayDay\\src\\main\\resources\\empregador.json";

    public Empregador getEmpregador(String cnpj) {
        try {
            // Carregar dados do arquivo JSON
            ObjectMapper objectMapper = new ObjectMapper();
            List<Empregador> empregadores = objectMapper.readValue(new File(FILE_PATH),
                    objectMapper.getTypeFactory().constructCollectionType(List.class, Empregador.class));
    
            // Percorre a lista para encontrar o funcionário com o NIS específico
            for (Empregador empregador : empregadores) {
                // Verifica se o NIS do funcionário corresponde ao NIS fornecido
                if (empregador.getCnpj().equals(cnpj)) {
                    // Retorna o funcionário encontrado
                    return empregador;
                }
            }
    
            // Retorna null se o funcionário com o NIS especificado não for encontrado
            return null;
        } catch (IOException e) {
            // Lidar com exceções de IO, se necessário
            e.printStackTrace();
            return null;
        }
    }
    }

