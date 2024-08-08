package br.com.fiap.soat4.grupo48.deletar.cliente.cliente.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder(toBuilder = true)
@AllArgsConstructor
public class Cliente {
    private UUID id;
    private String nome;
    private String endereco;
    private String telefone;
    private String pagamentoInfo;
    private boolean ativo;

}
