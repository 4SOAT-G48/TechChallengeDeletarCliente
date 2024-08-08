package br.com.fiap.soat4.grupo48.deletar.cliente.application.domain.model;

import br.com.fiap.soat4.grupo48.deletar.cliente.cliente.domain.model.Cliente;
import br.com.fiap.soat4.grupo48.deletar.cliente.utils.ClienteHelper;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ClienteTest {
    @Nested
    class deveCriarCliente {

        @Test
        void viaConstrutor() {
            // Arrange & Act
            UUID id = UUID.randomUUID();
            Cliente cliente = new Cliente(
                    id,
                    "Cliente teste",
                    "Avenida X",
                    "(11) 91111-1111",
                    "Pago",
                    true
                    );

            // Assert
            assertEquals(id, cliente.getId());
            assertEquals("Cliente teste", cliente.getNome());
            assertEquals("Avenida X", cliente.getEndereco());
            assertEquals("Pago", cliente.getPagamentoInfo());
            assertEquals("(11) 91111-1111", cliente.getTelefone());
        }

        @Test
        void viaBuilder() {
            // Arrange & Act
            Cliente cliente = ClienteHelper.gerarCliente();

            // Assert
            assertEquals("Cliente teste", cliente.getNome());
            assertEquals("Avenida X", cliente.getEndereco());
            assertEquals("Pago", cliente.getPagamentoInfo());
            assertEquals("(11) 91111-1111", cliente.getTelefone());
        }

        @Test
        void viaSetter() {
            // Arrange & Act
            Cliente cliente = new Cliente();
            UUID id = UUID.randomUUID();
            cliente.setId(id);
            cliente.setNome("Novo nome");

            // Assert
            assertEquals(id, cliente.getId());
            assertEquals("Novo nome", cliente.getNome());
        }
    }

    @Nested
    class deveAlterarCliente {

        @Test
        void atualizaNome() {
            // Arrange & Act
            Cliente cliente = ClienteHelper.gerarCliente();

            // Act
            cliente.setNome("Novo nome");

            // Assert
            assertEquals("Novo nome", cliente.getNome());
        }

        @Test
        void atualizaEndereco() {
            // Arrange & Act
            Cliente cliente = ClienteHelper.gerarCliente();

            // Act
            cliente.setEndereco("Avenida Z");

            // Assert
            assertEquals("Avenida Z", cliente.getEndereco());
        }

        @Test
        void atualizaPagamentoInfo() {
            // Arrange & Act
            Cliente cliente = ClienteHelper.gerarCliente();

            // Act
            cliente.setPagamentoInfo("Processando");

            // Assert
            assertEquals("Processando", cliente.getPagamentoInfo());
        }

        @Test
        void atualizaTelefone() {
            // Arrange & Act
            Cliente cliente = ClienteHelper.gerarCliente();

            // Act
            cliente.setTelefone("(11) 91111-1112");

            // Assert
            assertEquals("(11) 91111-1112", cliente.getTelefone());
        }

        @Test
        void atualizaAtivo() {
            // Arrange & Act
            Cliente cliente = ClienteHelper.gerarCliente();

            // Act
            cliente.setAtivo(false);

            // Assert
            assertFalse(cliente.isAtivo());
        }
    }

}
