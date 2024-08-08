package br.com.fiap.soat4.grupo48.deletar.cliente.cliente.infra.adapter.db;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpringClienteRepository extends JpaRepository<ClienteEntity, UUID> {
}
