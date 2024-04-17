package com.payment.demo.controller;

import java.io.File;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.payment.demo.model.Eventos;
import com.payment.demo.model.Funcionario;
import com.payment.demo.service.FuncionarioDataManager;
import com.payment.demo.service.FuncionarioService;


@RestController
@CrossOrigin("*")
@RequestMapping("/funcionarios")
public class FuncionarioController {

  @Autowired
  private FuncionarioDataManager funcionarioDataManager;

  @Autowired
  private FuncionarioService funcionarioService;

  private ObjectMapper objectMapper = new ObjectMapper();

  @GetMapping("/get")
  public ResponseEntity<Object> getData() throws IOException {
    Object data = objectMapper.readValue(new File(
        "C:\\Users\\bielc\\Desktop\\PayDay-main\\Payday\\PayDay\\demo\\PayDay\\src\\main\\resources\\funcionario.json"),
        Object.class);
    return ResponseEntity.ok(data);
  }

  @GetMapping("get/{nis}")
  public ResponseEntity<Object> buscaPorNis(@PathVariable String nis) throws IOException{
      Funcionario funcionario = funcionarioService.encontrarFuncionarioPorNIS(nis);
      return ResponseEntity.ok(funcionario);
  }
  
  @PutMapping("/update/{nis}")
  public ResponseEntity<String> updateData(@PathVariable String nis, @RequestBody Eventos novosEventos) {
    Funcionario funcionarioAtualizado = funcionarioDataManager.atualizarEventosDoFuncionario(nis, novosEventos);

    if (funcionarioAtualizado != null) {

      return ResponseEntity.ok("Eventos do funcionário atualizados com sucesso. Salário líquido atualizado: "
          + funcionarioAtualizado.toString());
    } else {
      // Retorna uma resposta de erro se o funcionário com o NIS especificado não for
      // encontrado
      return ResponseEntity.notFound().build();
    }
  }


}