package com.payment.demo.controller;

import com.payment.demo.model.Eventos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/funcionarios/{funcionarioId}/eventos")
public class EventosController {

    private EventosService eventosService;

    @Autowired
    public EventosController(EventosService eventosService) {
        this.eventosService = eventosService;
    }

    @PostMapping("/horas-extras-50")
    public ResponseEntity<Eventos> adicionarHoraExtra50(@PathVariable Long funcionarioId, @RequestBody Eventos eventos) {
        eventos = eventosService.adicionarHoraExtra50(funcionarioId, eventos.getHorasExtras50());
        return ResponseEntity.ok(eventos);
    }

    @PostMapping("/horas-extras-100")
    public ResponseEntity<Eventos> adicionarHoraExtra100(@PathVariable Long funcionarioId, @RequestBody Eventos eventos) {
        eventos = eventosService.adicionarHoraExtra100(funcionarioId, eventos.getHorasExtras100());
        return ResponseEntity.ok(eventos);
    }

    @PutMapping("/faltas")
    public ResponseEntity<Eventos> subtrairFaltas(@PathVariable Long funcionarioId, @RequestBody Eventos eventos) {
        eventosService.subtrairFaltas(funcionarioId, eventos.getFaltas());
        return ResponseEntity.ok(eventos);
    }

    @PutMapping("/atrasos")
    public ResponseEntity<Eventos> descontoPorAtraso(@PathVariable Long funcionarioId, @RequestBody Eventos eventos) {
        Eventos updatedEventos = eventosService.descontoPorAtraso(funcionarioId, eventos.getHorasDeAtraso(), eventos);
        return ResponseEntity.ok(updatedEventos);
    }

    @PutMapping("/descanso-semanal-remunerado")
    public ResponseEntity<Eventos> descansoSemanalRemunerado(@PathVariable Long funcionarioId, @RequestBody Eventos eventos) {
        Eventos updatedEventos = eventosService.descansoSemanalRemunerado(funcionarioId, eventos);
        return ResponseEntity.ok(updatedEventos);
    }

    @PutMapping("/adicional-noturno")
    public ResponseEntity<Eventos> adicionalNoturno(@PathVariable Long funcionarioId, @RequestBody Eventos eventos) {
        Eventos updatedEventos = eventosService.adicionalNoturno(funcionarioId, eventos);
        return ResponseEntity.ok(updatedEventos);
    }

    @PutMapping("/salario-familia")
    public ResponseEntity<Eventos> salarioFamilia(@PathVariable Long funcionarioId, @RequestBody Eventos eventos) {
        Eventos updatedEventos = eventosService.salarioFamilia(funcionarioId, eventos);
        return ResponseEntity.ok(updatedEventos);
    }

    @PutMapping("/diaria-viagem")
    public ResponseEntity<Eventos> diariaViagem(@PathVariable Long funcionarioId, @RequestBody Eventos eventos) {
        Eventos updatedEventos = eventosService.diariaViagem(funcionarioId, eventos);
        return ResponseEntity.ok(updatedEventos);
    }

    @PutMapping("/auxilio-creche-baba")
    public ResponseEntity<Eventos> auxilioCrecheBaba(@PathVariable Long funcionarioId, @RequestBody Eventos eventos) {
        Eventos updatedEventos = eventosService.auxilioCrecheBaba(funcionarioId, eventos);
        return ResponseEntity.ok(updatedEventos);
    }
}