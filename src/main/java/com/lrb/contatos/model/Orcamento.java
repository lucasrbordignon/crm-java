package com.lrb.contatos.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "orcamentos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Orcamento {

  @Id
  @Column(unique = true, updatable = false, nullable = false)
  private String id;

  @ManyToOne
  @JoinColumn(name = "contact_id", nullable = false)
  private Contato contato;

  private Double value;
  private String description;

  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
  private LocalDateTime deletedAt;

  @PrePersist
  protected void onCreate() {
    this.id = UUID.randomUUID().toString();
    this.createdAt = LocalDateTime.now();
    this.updatedAt = LocalDateTime.now();
  }

  @PreUpdate
  protected void onUpdate() {
    this.updatedAt = LocalDateTime.now();
  }

  public void markAsDeleted() {
    this.deletedAt = LocalDateTime.now();
  }
}
