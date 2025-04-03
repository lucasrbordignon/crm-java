package com.lrb.contatos.service;

import com.lrb.contatos.model.Cliente;
import com.lrb.contatos.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

  @Autowired
  private ClienteRepository repository;

  public List<Cliente> listarTodos() {
    return repository.findAll();
  }

  public Optional<Cliente> buscarPorId(String id) {
    return repository.findById(id);
  }

  public Cliente salvar(Cliente cliente) {
    cliente.setUpdatedAt(LocalDateTime.now());
    return repository.save(cliente);
  }

  public void excluir(String id) {
    Cliente cliente = repository.findById(id).orElseThrow(() ->
        new RuntimeException("Cliente não encontrado!"));

    cliente.markAsDeleted();
    repository.save(cliente);
  }
}
