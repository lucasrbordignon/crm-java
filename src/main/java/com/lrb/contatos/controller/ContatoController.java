package com.lrb.contatos.controller;

import com.lrb.contatos.dto.ContatoDTO;
import com.lrb.contatos.model.Contato;
import com.lrb.contatos.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contatos")
public class ContatoController {

  @Autowired
  private ContatoService service;

  @GetMapping("/")
  public List<Contato> listarContatos() {
    return service.listarContatos();
  }

  @GetMapping("/cliente/{clienteId}")
  public List<ContatoDTO> listarContatosPorCliente(@PathVariable String clienteId) {
    return service.listarContatosPorCliente(clienteId);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Contato> buscarContato(@PathVariable String id) {
    Optional<Contato> contato = service.buscarPorId(id);
    return contato.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  }

  @PostMapping
  public Contato criarContato(@RequestBody Contato contato) {
    return service.salvar(contato);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deletarContato(@PathVariable String id) {
    service.deletar(id);
    return ResponseEntity.noContent().build();
  }
}
