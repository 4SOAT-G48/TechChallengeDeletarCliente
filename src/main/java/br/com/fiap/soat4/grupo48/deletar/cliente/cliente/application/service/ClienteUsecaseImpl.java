package br.com.fiap.soat4.grupo48.deletar.cliente.cliente.application.service;

import br.com.fiap.soat4.grupo48.deletar.cliente.cliente.application.service.port.in.IClientPort;
import br.com.fiap.soat4.grupo48.deletar.cliente.cliente.application.service.port.out.IClienteRepositoryGateway;
import br.com.fiap.soat4.grupo48.deletar.cliente.cliente.infra.adapter.db.ClienteEntity;

import java.util.UUID;

public class ClienteUsecaseImpl implements IClientPort {

    private final IClienteRepositoryGateway iClienteRepositoryGateway;

    public ClienteUsecaseImpl(IClienteRepositoryGateway iClienteRepositoryGateway) {
        this.iClienteRepositoryGateway = iClienteRepositoryGateway;
    }

    @Override
    public ClienteEntity buscarPeloId(UUID id) { return this.iClienteRepositoryGateway.buscarPeloId(id); }

    @Override
    public void deletarCliente(UUID id, boolean logical) {
        this.iClienteRepositoryGateway.deletarCliente(id, logical);
    }


}
