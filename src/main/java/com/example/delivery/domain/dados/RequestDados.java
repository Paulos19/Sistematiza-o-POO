package com.example.delivery.domain.dados;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RequestDados(
        String id,
        @NotBlank
        String name,
        @NotNull
        Integer cpf,
        @NotNull
        Integer capacidadeveiculo) {
}
