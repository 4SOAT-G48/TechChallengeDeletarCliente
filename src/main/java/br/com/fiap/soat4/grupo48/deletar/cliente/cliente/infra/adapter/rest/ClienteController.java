package br.com.fiap.soat4.grupo48.deletar.cliente.cliente.infra.adapter.rest;

import br.com.fiap.soat4.grupo48.deletar.cliente.cliente.application.service.port.in.IClientPort;
import br.com.fiap.soat4.grupo48.deletar.cliente.cliente.domain.model.Cliente;
import br.com.fiap.soat4.grupo48.deletar.cliente.cliente.infra.adapter.db.ClienteEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.UUID;

@Tag(name = "Deletar Cliente", description = "Endpoint para inativacao de um cliente")
@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    private final IClientPort clientPort;

    public ClienteController(IClientPort clienteServicePort) { this.clientPort = clienteServicePort; }

    @Operation(summary = "Deleta o cliente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuario deletado com sucesso", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = IClientPort.class))})
    })
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteCliente(@PathVariable UUID id, @RequestParam boolean logical) {
        ClienteEntity cliente = this.clientPort.buscarPeloId(id);


        this.clientPort.deletarCliente(cliente.getId(), logical);
        return ResponseEntity.ok("Usuário deletado com sucesso.");
    }
}
