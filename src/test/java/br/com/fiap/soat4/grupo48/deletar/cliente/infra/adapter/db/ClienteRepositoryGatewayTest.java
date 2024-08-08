package br.com.fiap.soat4.grupo48.deletar.cliente.infra.adapter.db;

import br.com.fiap.soat4.grupo48.deletar.cliente.cliente.infra.adapter.db.ClienteEntity;
import br.com.fiap.soat4.grupo48.deletar.cliente.cliente.infra.adapter.db.ClienteRepositoryGateway;
import br.com.fiap.soat4.grupo48.deletar.cliente.cliente.infra.adapter.db.SpringClienteRepository;
import br.com.fiap.soat4.grupo48.deletar.cliente.utils.ClienteHelper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class ClienteRepositoryGatewayTest {
    AutoCloseable mock;
    @Mock
    private ClienteRepositoryGateway clienteRepositoryGateway;
    @Mock
    private SpringClienteRepository springClienteRepository;

    @BeforeEach
    void setUp() {
        mock = MockitoAnnotations.openMocks(this);
        clienteRepositoryGateway = new ClienteRepositoryGateway(springClienteRepository);
    }

    @AfterEach
    void tearDown() throws Exception {
        mock.close();
    }

    @Nested
    class Buscar {
        @Test
        void deveBuscarPorId() {
            // Arrange
            ClienteEntity clienteEntity = ClienteHelper.gerarClienteEntity();
            clienteEntity.setId(UUID.randomUUID());

            when(springClienteRepository.findById(any(UUID.class)))
                    .thenReturn(Optional.of(clienteEntity));

            // Act
            var cliente = clienteRepositoryGateway.buscarPeloId(clienteEntity.getId());

            // Assert
            assertThat(cliente)
                    .isInstanceOf(ClienteEntity.class)
                    .isNotNull();

            assertThat(cliente.getId())
                    .isNotNull()
                    .isEqualTo(clienteEntity.getId());
            assertThat(cliente.getNome())
                    .isNotNull()
                    .isEqualTo(clienteEntity.getNome());
            assertThat(cliente.getEndereco())
                    .isNotNull()
                    .isEqualTo(clienteEntity.getEndereco());
            assertThat(cliente.getPagamentoInfo())
                    .isNotNull()
                    .isEqualTo(clienteEntity.getPagamentoInfo());
            assertThat(cliente.getTelefone())
                    .isNotNull()
                    .isEqualTo(clienteEntity.getTelefone());
        }
    }

    @Nested
    class Deletar {
        @Test
        void deveDeletarClienteLogico() {
            // Arrange
            var id = UUID.randomUUID();
            ClienteEntity clienteEntity = ClienteHelper.gerarClienteEntity();
            clienteEntity.setId(id);
            clienteEntity.setAtivo(true);
            when(springClienteRepository.findById(any(UUID.class)))
                    .thenReturn(Optional.of(clienteEntity));
            when(springClienteRepository.save(any(ClienteEntity.class)))
                    .thenAnswer(invocation -> invocation.getArgument(0));

            // Act
            clienteEntity.setAtivo(false);
            clienteRepositoryGateway.salvar(clienteEntity);

            // Assert
            verify(springClienteRepository, times(1)).save(clienteEntity);
            assertThat(clienteEntity.isAtivo()).isFalse();
        }


        @Test
        void deveDeletarClienteNaoLogico() {
            // Arrange
            var id = UUID.randomUUID();
            ClienteEntity clienteEntity = ClienteHelper.gerarClienteEntity();
            clienteEntity.setId(id);
            when(springClienteRepository.findById(id)).thenReturn(Optional.of(clienteEntity));
            clienteRepositoryGateway.salvar(clienteEntity);

            // Act
            clienteRepositoryGateway.deletarCliente(clienteEntity.getId(), false);

            // Assert
            verify(springClienteRepository, times(1)).deleteById(clienteEntity.getId());
        }

    }
}
