package com.payment.demo.service;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.payment.demo.model.Funcionario;
import com.payment.demo.model.PessoaFisica;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

@Service
public class FuncionarioService {

    @Autowired
    private EventosService eventosService;
    private PessoaFisica pessoaFisica;
    private LeitorJSON leitorJSON;
    String jsonFuncionario = "{resources/funcionario.json}";

    public List<Funcionario> carregarFuncionarios() {

        JsonObject jsonObject = new JsonObject();

        jsonObject.addProperty("nome", "João Silva");
        jsonObject.addProperty("cargo", "Desenvolvedor");
        jsonObject.addProperty("idade", 30);
        jsonObject.addProperty("salario", 5000.00);

        System.out.println(jsonObject);
        List<Funcionario> clientList = null;
        try {
            Gson gson = new Gson();
            FileReader reader = new FileReader("C:\\Users\\gabri\\OneDrive\\Área de Trabalho\\Nova pasta\\PayDay\\Payday\\PayDay\\demo\\PayDay\\funcionario.json");
            clientList = gson.fromJson(reader, new TypeToken<List<Funcionario>>(){}.getType());

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return clientList;

    }

    public void calcularSalarioLiquido(Funcionario funcionario, PessoaFisica pessoaFisica) {
        // Resetar o valor total dos eventos antes de calcular
        eventosService.resetarValorTotalEventos();

        // Executar eventos para o funcionário
        eventosService.adicionarHoraExtra50(funcionario.getNivelSalarial(), funcionario.getQuantiaHoraExtra50());
        eventosService.adicionarHoraExtra100(funcionario.getNivelSalarial(), funcionario.getQuantiaHoraExtra100());
        eventosService.subtrairFaltas(funcionario.getNivelSalarial(), funcionario.getQuantiaFaltas());
        eventosService.descontoPorAtraso(funcionario.getNivelSalarial(), funcionario.getQuantiaDescontoPorAtraso());
        eventosService.descansoSemanalRemunerado(funcionario.getNivelSalarial(),
                funcionario.getQuantiaDescansoSemanalRemunerado());
        eventosService.adicionalNoturno(funcionario.getNivelSalarial(), funcionario.getQuantiaAdicionalNoturno());
        eventosService.salarioFamilia(funcionario.getNivelSalarial(), funcionario.getQuantidadeDependentes());
        eventosService.diariaViagem(funcionario.getNivelSalarial(), funcionario.getQuantiaDiariaViagem());

        // eventosService.auxilioCrecheBaba(pessoaFisica.getDataDeNascimento(), funcionario.getQuantidadeDependentes());

        // Obter o valor total dos eventos
        Float valorTotalEventos = eventosService.getValorTotalEventos();

        // Calcular o salário líquido
        Float salarioLiquido = funcionario.getNivelSalarial() + valorTotalEventos;

        // Salvar o salário líquido no funcionário
        funcionario.setSalarioLiquido(salarioLiquido);
    }

    /*
     * public void executarEvento(Funcionario funcionario, Dependente dependente) {
     * // Verifica se o objeto de eventos do funcionário não é nulo
     * if (funcionario.getEventos() != null) {
     * // Obtém o objeto de eventos do funcionário
     * Eventos eventos = funcionario.getEventos();
     * 
     * // Verifica e executa cada tipo de evento, se estiver presente
     * if (eventos.getHoraExtra50() != null) {
     * eventosService.adicionarHoraExtra50(funcionario.getNivelSalarial(),
     * eventos.getHoraExtra50());
     * }
     * if (eventos.getHoraExtra100() != null) {
     * eventosService.adicionarHoraExtra100(funcionario.getNivelSalarial(),
     * eventos.getHoraExtra100());
     * }
     * if (eventos.getFaltas() != null) {
     * eventosService.subtrairFaltas(funcionario.getNivelSalarial(),
     * eventos.getFaltas());
     * }
     * if (eventos.getAtraso() != null) {
     * eventosService.descontoPorAtraso(funcionario.getNivelSalarial(),
     * eventos.getAtraso());
     * }
     * if (eventos.getDescansoSemanalRemunerado() != null) {
     * eventosService.descansoSemanalRemunerado(funcionario.getNivelSalarial(),
     * eventos.getDescansoSemanalRemunerado());
     * }
     * if (eventos.getAdicionalNoturno() != null) {
     * eventosService.adicionalNoturno(funcionario.getNivelSalarial(),
     * eventos.getAdicionalNoturno());
     * }
     * if (eventos.getSalarioFamilia() != null) {
     * eventosService.salarioFamilia(funcionario.getNivelSalarial(),
     * funcionario.getQuantidadeDependentes());
     * }
     * if (eventos.getDiariaViagem() != null) {
     * eventosService.diariaViagem(funcionario.getNivelSalarial(),
     * eventos.getDiariaViagem());
     * }
     * if (eventos.getAuxilioCrecheBaba() != null) {
     * eventosService.auxilioCrecheBaba(dependente.getDataDeNascimento(),
     * funcionario.getQuantidadeDependentes());
     * }
     * } else {
     * System.out.println("O objeto de eventos do funcionário está nulo.");
     * }
     * }
     */

}
