package com.payment.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.payment.demo.model.Adicionais;
import com.payment.demo.model.Funcionario;

@Controller
public class FuncionarioController {

    @GetMapping("/funcionarios")
    public String listarFuncionarios(Model model) {
       // Criar instâncias de Funcionario
       Funcionario funcionario1 = new Funcionario(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null);
       funcionario1.setNis("123456789");
       funcionario1.setCargo("Analista");
       funcionario1.setJornadaDeTrabalho("40 horas/semana");
       funcionario1.setCategoria("CLT");
       funcionario1.setNivelSalarial(5000.00f);
       
       Funcionario funcionario2 = new Funcionario(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null);
       funcionario2.setNis("987654321");
       funcionario2.setCargo("Gerente");
       funcionario2.setJornadaDeTrabalho("40 horas/semana");
       funcionario2.setCategoria("CLT");
       funcionario2.setNivelSalarial(7000.00f);
       
       // Definir tipo de adicional para cada funcionário
       String tipoAdicionalFuncionario1 = "Insalubridade";
       String tipoAdicionalFuncionario2 = "Periculosidade";

       // Adicionar tipo de adicional ao modelo
       model.addAttribute("tipoAdicionalFuncionario1", tipoAdicionalFuncionario1);
       model.addAttribute("tipoAdicionalFuncionario2", tipoAdicionalFuncionario2);
       
       // Adicionar funcionários ao modelo
       model.addAttribute("funcionario1", funcionario1);
       model.addAttribute("funcionario2", funcionario2);
       
       // Retorna a view que irá exibir os funcionários
       return "listarFuncionarios";
   }
}