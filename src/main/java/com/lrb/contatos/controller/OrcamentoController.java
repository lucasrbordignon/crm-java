package com.lrb.contatos.controller;

import com.lrb.contatos.model.Orcamento;
import com.lrb.contatos.service.OrcamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orcamentos")
public class OrcamentoController {

  @Autowired
  private OrcamentoService service;

  @GetMapping("/contato/{contatoId}")
  public List<Orcamento> listarOrcamentosPorContato(@PathVariable String contatoId) {
    return service.listarOrcamentosPorContato(contatoId);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Orcamento> buscarOrcamento(@PathVariable String id) {
    Optional<Orcamento> orcamento = service.buscarPorId(id);
    return orcamento.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  }

  @PostMapping
  public Orcamento criarOrcamento(@RequestBody Orcamento orcamento) {
    return service.salvar(orcamento);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deletarOrcamento(@PathVariable String id) {
    service.deletar(id);
    return ResponseEntity.noContent().build();
  }
}
