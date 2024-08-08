package br.com.fiap.soat4.grupo48.deletar.cliente.cliente.infra.adapter.db;

import br.com.fiap.soat4.grupo48.deletar.cliente.cliente.domain.model.Cliente;
import jakarta.persistence.*;
import lombok.*;
import lombok.extern.jackson.Jacksonized;

import java.util.UUID;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Jacksonized
@Entity
@Table(name = "clientes")
public class ClienteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String nome;
    private String endereco;
    private String telefone;
    private String pagamentoInfo;
    @Getter
    private boolean ativo;

    public ClienteEntity(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.endereco = cliente.getEndereco();
        this.telefone = cliente.getTelefone();
        this.pagamentoInfo = cliente.getPagamentoInfo();
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Cliente toCliente() {
        return new Cliente(this.id, this.nome, this.endereco, this.telefone, this.pagamentoInfo, isAtivo());
    }

}