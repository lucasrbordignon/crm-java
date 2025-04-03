package com.lrb.contatos.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "clientes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Cliente {

  @Id
  @Column(unique = true, updatable = false, nullable = false)
  private String id;

  @Column(nullable = false)
  private String nome;

  @Column()
  private String email;

  @Column()
  private String instagramId;

  @Column()
  private String phoneNumber;

  @Column(unique = true, updatable = false)
  private String cpf;

  @Column(updatable = false)
  private LocalDateTime createdAt;

  @Column()
  private LocalDateTime deletedAt;

  @Column()
  private LocalDateTime updatedAt;

  @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Contato> contatos;

  @PrePersist
  protected void onCreate() {
    this.id = UUID.randomUUID().toString();
    this.createdAt = LocalDateTime.now();
    this.updatedAt = LocalDateTime.now();
  }

  public void markAsDeleted() {
    this.deletedAt = LocalDateTime.now();
  }
}
