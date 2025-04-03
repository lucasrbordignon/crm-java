package com.lrb.contatos.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContatoDTO {
  private String id;
  private LocalDateTime contactedAt;
  private String channel;
  private String interest;
  private String observation;

  public ContatoDTO(String id, String channel, String interest, String observation, LocalDateTime contactedAt) {
    this.id = id;
    this.channel = channel;
    this.interest = interest;
    this.observation = observation;
    this.contactedAt = contactedAt;
  }
}
