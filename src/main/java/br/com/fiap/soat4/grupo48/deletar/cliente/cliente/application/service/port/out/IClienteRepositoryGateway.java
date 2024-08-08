package br.com.fiap.soat4.grupo48.deletar.cliente.cliente.application.service.port.out;

import br.com.fiap.soat4.grupo48.deletar.cliente.cliente.infra.adapter.db.ClienteEntity;

import java.util.UUID;

public interface IClienteRepositoryGateway {
    ClienteEntity buscarPeloId(UUID id);

    void deletarCliente(UUID id, boolean logical);

    void salvar(ClienteEntity cliente);

    void deletar(ClienteEntity cliente);
}
