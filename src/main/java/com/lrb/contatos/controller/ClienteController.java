package com.lrb.contatos.controller;

import com.lrb.contatos.model.Cliente;
import com.lrb.contatos.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

  @Autowired
  private ClienteService service;

  @GetMapping
  public List<Cliente> listarTodos() {
    return service.listarTodos();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Cliente> buscarPorId(@PathVariable String id) {
    Optional<Cliente> cliente = service.buscarPorId(id);
    return cliente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  }

  @PostMapping
  public Cliente criar(@RequestBody Cliente cliente) {
    return service.salvar(cliente);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Cliente> atualizar(@PathVariable String id, @RequestBody Cliente cliente) {
    if (!service.buscarPorId(id).isPresent()) {
      return ResponseEntity.notFound().build();
    }
    cliente.setId(id);
    return ResponseEntity.ok(service.salvar(cliente));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> excluir(@PathVariable String id) {
    if (!service.buscarPorId(id).isPresent()) {
      return ResponseEntity.notFound().build();
    }
    service.excluir(id);
    return ResponseEntity.noContent().build();
  }
}
