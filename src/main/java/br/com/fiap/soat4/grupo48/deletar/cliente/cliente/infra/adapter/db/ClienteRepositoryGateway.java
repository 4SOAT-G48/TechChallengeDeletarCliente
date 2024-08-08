package br.com.fiap.soat4.grupo48.deletar.cliente.cliente.infra.adapter.db;

import br.com.fiap.soat4.grupo48.deletar.cliente.cliente.application.service.port.out.IClienteRepositoryGateway;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ClienteRepositoryGateway implements IClienteRepositoryGateway {
    private final SpringClienteRepository springClienteRepository;

    public ClienteRepositoryGateway(SpringClienteRepository springClienteRepository) {
        this.springClienteRepository = springClienteRepository;
    }

    @Override
    public ClienteEntity buscarPeloId(UUID id) { return this.springClienteRepository.findById(id).get();}

    public void deletarCliente(UUID id, boolean logical) {
        ClienteEntity cliente = this.buscarPeloId(id);
        if (logical) {
            cliente.setAtivo(false);
            this.salvar(cliente);
        } else {
            this.deletar(cliente);
        }
    }

    public void salvar(ClienteEntity cliente) {
        springClienteRepository.save(cliente);
    }

    public void deletar(ClienteEntity cliente) {
        springClienteRepository.deleteById(cliente.getId());
    }
}
