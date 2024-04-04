package com.payment.demo.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.payment.demo.model.Adicionais;
import com.payment.demo.model.Funcionario;


public class AdicionaisController {
    @GetMapping("/calcular-adicionais")
    public String calcularAdicionais(Model model, String tipoAdicional) {
        // Criar instâncias de Funcionario
        Funcionario funcionario1 = new Funcionario(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null);
        funcionario1.setNivelSalarial(5000.00f);
        
        Funcionario funcionario2 = new Funcionario(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null);
        funcionario2.setNivelSalarial(7000.00f);
        
        // Criar instâncias de Adicionais e calcular os valores com base no tipo
        Adicionais adicionaisFuncionario1 = new Adicionais(0, 0, 0, 0, 0, 0, 0, funcionario1);
        adicionaisFuncionario1.setFuncionario(funcionario1);
        
        Adicionais adicionaisFuncionario2 = new Adicionais(0, 0, 0, 0, 0, 0, 0, funcionario2);
        adicionaisFuncionario2.setFuncionario(funcionario2);
        
        if ("insalubridade".equals(tipoAdicional)) {
            float insalubridadeFuncionario1 = calcularInsalubridade(funcionario1);
            adicionaisFuncionario1.setInsalubridade(insalubridadeFuncionario1);

            float insalubridadeFuncionario2 = calcularInsalubridade(funcionario2);
            adicionaisFuncionario2.setInsalubridade(insalubridadeFuncionario2);
        }
        // Adicionar objetos de Adicionais ao modelo
        model.addAttribute("adicionaisFuncionario1", adicionaisFuncionario1);
        model.addAttribute("adicionaisFuncionario2", adicionaisFuncionario2);
        
        // Retorna a view que irá exibir os cálculos dos adicionais
        return "calcularAdicionais";
    }

    // Método para calcular o adicional de insalubridade
    private float calcularInsalubridade(Funcionario funcionario) {
        float salario = funcionario.getNivelSalarial();
        // Implemente sua lógica de cálculo aqui
        return salario * 0.1f; // Exemplo simples de cálculo
    }

    // Outros métodos para calcular os demais adicionaisis
}
