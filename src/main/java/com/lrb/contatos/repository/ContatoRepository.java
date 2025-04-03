package com.lrb.contatos.repository;

import com.lrb.contatos.dto.ContatoDTO;
import com.lrb.contatos.model.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContatoRepository extends JpaRepository<Contato, String> {
  @Query("SELECT new com.lrb.contatos.dto.ContatoDTO(c.id, c.channel, c.interest, c.observation, c.contactedAt) " +
      "FROM Contato c WHERE c.cliente.id = :clienteId")
  List<ContatoDTO> findContatosByClienteId(@Param("clienteId") String clienteId);
}