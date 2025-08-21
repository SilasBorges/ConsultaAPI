package com.silasborges.consultaapi.model;

import com.silasborges.consultaapi.utils.CepOmdb;

public class Cep {
    private String logradouro;
    private String bairro;
    private String localidade;
    private String estado;

    public Cep(CepOmdb myCepOmdb) {
        this.logradouro = myCepOmdb.logradouro();
        this.bairro = myCepOmdb.bairro();
        this.localidade = myCepOmdb.localidade();
        this.estado = myCepOmdb.estado();
    }

    public Cep() {
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public String getEstado() {
        return estado;
    }

    @Override
    public String toString() {
        return "( " + logradouro + ", " +
                bairro + ", " + localidade + ","
                + estado + " )";
    }
}
