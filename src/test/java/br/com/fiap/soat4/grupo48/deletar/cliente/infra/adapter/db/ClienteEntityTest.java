package br.com.fiap.soat4.grupo48.deletar.cliente.infra.adapter.db;

import br.com.fiap.soat4.grupo48.deletar.cliente.cliente.infra.adapter.db.ClienteEntity;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ClienteEntityTest {

    @Nested
    class construtures {

        @Test
        void testConstrutor() {
            ClienteEntity clienteEntity = new ClienteEntity();

            assertNotNull(clienteEntity);
        }

        @Test
        void testConstrutorComParametros() {
            // Arrange & Act
            UUID id = UUID.randomUUID();
            ClienteEntity clienteEntity = new ClienteEntity(
                    id,
                    "Cliente teste Entity",
                    "Avenida Y",
                    "(11) 91111-1112",
                    "Processamento",
                    true
            );

            // Assert
            assertNotNull(clienteEntity);
            assertNotNull(clienteEntity.getId());
            assertNotNull(clienteEntity.getNome());
            assertNotNull(clienteEntity.getEndereco());
            assertNotNull(clienteEntity.getTelefone());
            assertNotNull(clienteEntity.getPagamentoInfo());
            assertEquals(id, clienteEntity.getId());
            assertEquals("Cliente teste Entity", clienteEntity.getNome());
            assertEquals("Avenida Y", clienteEntity.getEndereco());
            assertEquals("Processamento", clienteEntity.getPagamentoInfo());
            assertEquals("(11) 91111-1112", clienteEntity.getTelefone());
        }

        @Test
        void testConstrutorComParametrosNull() {
            // Arrange & Act
            ClienteEntity clienteEntity = new ClienteEntity(
                    null,
                    null,
                    null,
                    null,
                    null,
                    false
            );
            // Assert
            assertNotNull(clienteEntity);
            assertNull(clienteEntity.getId());
            assertNull(clienteEntity.getNome());
            assertNull(clienteEntity.getEndereco());
            assertNull(clienteEntity.getTelefone());
            assertNull(clienteEntity.getPagamentoInfo());
        }
    }

    @Nested
    class atribucoesCampos {

        @Test
        void testSetters() {
            // Arrange
            ClienteEntity clienteEntity = new ClienteEntity();

            // Act
            UUID id = UUID.randomUUID();
            clienteEntity.setId(id);
            clienteEntity.setNome("Cliente teste Entity");
            clienteEntity.setEndereco("Avenida Y");
            clienteEntity.setPagamentoInfo("Processamento");
            clienteEntity.setTelefone("(11) 91111-1112");
            clienteEntity.setAtivo(true);

            // Assert
            assertNotNull(clienteEntity);
            assertNotNull(clienteEntity.getId());
            assertEquals("Cliente teste Entity", clienteEntity.getNome());
            assertEquals("Avenida Y", clienteEntity.getEndereco());
            assertEquals("Processamento", clienteEntity.getPagamentoInfo());
            assertEquals("(11) 91111-1112", clienteEntity.getTelefone());
            assertTrue(clienteEntity.isAtivo());

        }
    }
}
