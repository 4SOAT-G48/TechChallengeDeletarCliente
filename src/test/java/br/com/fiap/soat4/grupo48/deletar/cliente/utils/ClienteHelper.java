package br.com.fiap.soat4.grupo48.deletar.cliente.utils;

import br.com.fiap.soat4.grupo48.deletar.cliente.cliente.domain.model.Cliente;
import br.com.fiap.soat4.grupo48.deletar.cliente.cliente.infra.adapter.db.ClienteEntity;

public class ClienteHelper extends FormatoHelper {
    public static Cliente gerarCliente() {
        return Cliente.builder()
                .nome("Cliente teste")
                .endereco("Avenida X")
                .pagamentoInfo("Pago")
                .telefone("(11) 91111-1111")
                .ativo(true)
                .build();
    }

    public static ClienteEntity gerarClienteEntity() {
        return ClienteEntity.builder()
                .nome("Cliente teste Entity")
                .endereco("Avenida Y")
                .pagamentoInfo("Processamento")
                .telefone("(11) 91111-1112")
                .ativo(true)
                .build();
    }
}
