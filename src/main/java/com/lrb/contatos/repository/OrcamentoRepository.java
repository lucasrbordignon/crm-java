package com.lrb.contatos.repository;

import com.lrb.contatos.model.Orcamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrcamentoRepository extends JpaRepository<Orcamento, String> {
  List<Orcamento> findByContatoId(String contatoId);
}
