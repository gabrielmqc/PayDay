package com.payment.demo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.payment.demo.model.Eventos;
import com.payment.demo.model.Funcionario;
import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioDataManager {
    private static final String FILE_PATH = "C:\\Users\\bielc\\Desktop\\PayDay-main\\Payday\\PayDay\\demo\\PayDay\\src\\main\\resources\\funcionario.json";

    @Autowired
    private FuncionarioService funcionarioService;

    public Funcionario atualizarEventosDoFuncionario(String nis, Eventos novosEventos) {
        try {
            // Carregar dados do arquivo JSON
            ObjectMapper objectMapper = new ObjectMapper();
            List<Funcionario> funcionarios = objectMapper.readValue(new File(FILE_PATH),
                    objectMapper.getTypeFactory().constructCollectionType(List.class, Funcionario.class));

            // Percorre a lista para encontrar o funcionário com o NIS específico
            for (Funcionario funcionario : funcionarios) {
                // Verifica se o NIS do funcionário corresponde ao NIS fornecido
                if (funcionario.getNis().equals(nis)) {
                    // Atualiza apenas os eventos do funcionário encontrado
                    funcionario.getEventos().setHoraExtra50(novosEventos.getHoraExtra50());
                    funcionario.getEventos().setHoraExtra100(novosEventos.getHoraExtra100());
                    funcionario.getEventos().setFaltas(novosEventos.getFaltas());
                    funcionario.getEventos().setAtraso(novosEventos.getAtraso());
                    funcionario.getEventos().setDescansoSemanalRemunerado(novosEventos.getDescansoSemanalRemunerado());
                    funcionario.getEventos().setAdicionalNoturno(novosEventos.getAdicionalNoturno());
                    funcionario.getEventos().setDiariaViagem(novosEventos.getDiariaViagem());
                    funcionario.getEventos().setAuxilioCrecheBaba(novosEventos.getAuxilioCrecheBaba());

                    // Calcular o salário líquido
                    funcionarioService.calcularSalarioLiquido(funcionario);

                    // Salvar dados atualizados de volta no arquivo JSON
                    objectMapper.writeValue(new File(FILE_PATH), funcionarios);

                    // Retorna o funcionário atualizado
                    return funcionario;
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
