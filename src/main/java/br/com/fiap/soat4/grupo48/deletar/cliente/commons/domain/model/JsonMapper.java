package br.com.fiap.soat4.grupo48.deletar.cliente.commons.domain.model;

import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class JsonMapper {
    public String toJson() {
        try {
            return new ObjectMapper().writeValueAsString(this);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
