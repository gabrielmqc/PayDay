package com.payment.demo.controller;

import java.util.Date;

public interface FolhaDePagamento {

    float selecionarCompetencia(Date data);

    void importarRegistros();

    double calcular(double calculo);

    void visualizar();
} 
