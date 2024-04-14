package com.payment.demo.service;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.payment.demo.model.Empregador;

@Service
public class EmpregadorService {

    String jsonEmpregador = "{resources/empregador.json}";

    public List<Empregador> carregarEmpregador() {

        JsonObject jsonObject = new JsonObject();

        System.out.println(jsonObject);
        List<Empregador> clientList = null;
        try {
            Gson gson = new Gson();
            FileReader reader = new FileReader(
                    "C:\\Users\\gabri\\OneDrive\\Área de Trabalho\\Nova pasta\\PayDay\\Payday\\PayDay\\demo\\PayDay\\src\\main\\resources\\empregador.json");
            clientList = gson.fromJson(reader, new TypeToken<List<Empregador>>() {
            }.getType());

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return clientList;

    }
}
