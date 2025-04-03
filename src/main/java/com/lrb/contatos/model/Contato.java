package com.lrb.contatos.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "contatos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Contato {

  @Id
  @Column(unique = true, updatable = false, nullable = false)
  private String id;

  @ManyToOne
  @JoinColumn(name = "client_id", referencedColumnName = "id", nullable = false)
  @JsonIgnoreProperties("contatos")
  private Cliente cliente;

  @Column(name = "contacted_at")
  private LocalDateTime contactedAt;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
  private LocalDateTime deletedAt;

  private String interest;
  private String channel;
  private String observation;

  @OneToMany(mappedBy = "contato", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Orcamento> orcamentos;

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
