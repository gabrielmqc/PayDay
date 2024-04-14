package com.payment.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.payment.demo.model.Empregador;
import com.payment.demo.service.EmpregadorService;

@RestController
@RequestMapping("/empregadores")
public class EmpregadorController {

    @Autowired
    private EmpregadorService empregadorService;

    @ResponseBody

    @GetMapping("/empregadores")
    public List<Empregador> listar() {
        List<Empregador> empregador = empregadorService.carregarEmpregador();
        System.err.println(empregador);
        return empregador;
    }

}
