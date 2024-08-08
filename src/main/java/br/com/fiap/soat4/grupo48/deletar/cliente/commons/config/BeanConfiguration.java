package br.com.fiap.soat4.grupo48.deletar.cliente.commons.config;

import br.com.fiap.soat4.grupo48.deletar.cliente.cliente.application.service.ClienteUsecaseImpl;
import br.com.fiap.soat4.grupo48.deletar.cliente.cliente.application.service.port.in.IClientPort;
import br.com.fiap.soat4.grupo48.deletar.cliente.cliente.application.service.port.out.IClienteRepositoryGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    IClientPort clienteUseCase(IClienteRepositoryGateway clienteRepositoryGateway) {
        return new ClienteUsecaseImpl(clienteRepositoryGateway);
    }
}
