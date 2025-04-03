package com.lrb.contatos.service;

import com.lrb.contatos.dto.ContatoDTO;
import com.lrb.contatos.model.Cliente;
import com.lrb.contatos.model.Contato;
import com.lrb.contatos.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContatoService {

  @Autowired
  private ContatoRepository repository;

  public List<Contato> listarContatos() {
    return repository.findAll();
  }

  public List<ContatoDTO> listarContatosPorCliente(String clienteId) {
    return repository.findContatosByClienteId(clienteId);
  }

  public Optional<Contato> buscarPorId(String id) {
    return repository.findById(id);
  }

  public Contato salvar(Contato contato) {
    return repository.save(contato);
  }

  public void deletar(String id) {
    Contato contato = repository.findById(id).orElseThrow(() ->
        new RuntimeException("Contato não encontrado!"));

    contato.markAsDeleted();
    repository.save(contato);
  }
}
