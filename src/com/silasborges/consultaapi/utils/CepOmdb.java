package com.silasborges.consultaapi.utils;

public record CepOmdb(
        String cep,
        String logradouro,
        String bairro,
        String localidade,
        String estado
) {
}
