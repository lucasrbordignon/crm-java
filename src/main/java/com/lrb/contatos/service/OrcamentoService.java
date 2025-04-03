package com.lrb.contatos.service;

import com.lrb.contatos.model.Orcamento;
import com.lrb.contatos.repository.OrcamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrcamentoService {

  private final OrcamentoRepository orcamentoRepository;

  public OrcamentoService(OrcamentoRepository orcamentoRepository) {
    this.orcamentoRepository = orcamentoRepository;
  }

  public List<Orcamento> listarOrcamentosPorContato(String contatoId) {
    return orcamentoRepository.findByContatoId(contatoId);
  }

  public Optional<Orcamento> buscarPorId(String id) {
    return orcamentoRepository.findById(id);
  }

  public Orcamento salvar(Orcamento orcamento) {
    return orcamentoRepository.save(orcamento);
  }

  public void deletar(String id) {
    orcamentoRepository.deleteById(id);
  }
}
