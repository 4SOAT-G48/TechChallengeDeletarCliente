package br.com.fiap.soat4.grupo48.deletar.cliente.application.service;

import br.com.fiap.soat4.grupo48.deletar.cliente.cliente.application.service.ClienteUsecaseImpl;
import br.com.fiap.soat4.grupo48.deletar.cliente.cliente.application.service.port.out.IClienteRepositoryGateway;
import br.com.fiap.soat4.grupo48.deletar.cliente.cliente.domain.model.Cliente;
import br.com.fiap.soat4.grupo48.deletar.cliente.cliente.infra.adapter.db.ClienteEntity;
import br.com.fiap.soat4.grupo48.deletar.cliente.utils.ClienteHelper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

public class ClienteUsecaseImplTest {
    AutoCloseable autoCloseable;
    private ClienteUsecaseImpl clienteUsecase;
    @Mock
    private IClienteRepositoryGateway clienteRepositoryGateway;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        clienteUsecase = new ClienteUsecaseImpl(clienteRepositoryGateway);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Nested
    class BuscarCliente {

        @Test
        void buscarPeloId() {
            // Arrange
            var id = UUID.randomUUID();
            var cliente = ClienteHelper.gerarClienteEntity();
            cliente.setId(id);
            when(clienteRepositoryGateway.buscarPeloId(id))
                    .thenReturn(cliente);

            // Act
            var clienteRetornado = clienteUsecase.buscarPeloId(id);

            // Assert
            assertThat(clienteRetornado.toCliente())
                    .isNotNull();
            verify(clienteRepositoryGateway, times(1))
                    .buscarPeloId(any());
        }
    }

    @Nested
    class DeletarCliente {
        @Test
        void deletarClienteLogico() {
            // Arrange
            var id = UUID.randomUUID();
            ClienteEntity cliente = ClienteHelper.gerarClienteEntity();
            cliente.setId(id);
            cliente.setAtivo(true); // Assume cliente is initially active
            when(clienteRepositoryGateway.buscarPeloId(id)).thenReturn(cliente);

            // Act
            clienteUsecase.deletarCliente(id, true);

            // Assert
            verify(clienteRepositoryGateway, times(1)).deletarCliente(cliente.getId(), true);
        }

        @Test
        void deletarClienteNaoLogico() {
            // Arrange
            var id = UUID.randomUUID();
            ClienteEntity cliente = ClienteHelper.gerarClienteEntity();
            cliente.setId(id);
            when(clienteRepositoryGateway.buscarPeloId(id)).thenReturn(cliente);

            // Act
            clienteUsecase.deletarCliente(cliente.getId(), false);

            // Assert
            verify(clienteRepositoryGateway, times(1)).deletarCliente(cliente.getId(), false);
        }
    }
}
