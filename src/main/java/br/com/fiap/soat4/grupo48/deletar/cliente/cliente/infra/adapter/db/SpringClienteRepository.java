package br.com.fiap.soat4.grupo48.deletar.cliente.cliente.infra.adapter.db;

import br.com.fiap.soat4.grupo48.deletar.cliente.cliente.domain.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface SpringClienteRepository extends JpaRepository<ClienteEntity, UUID> {
}
