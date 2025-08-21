package com.silasborges.consultaapi.utils;

public final class ValidCep {

    public ValidCep() {
    }

    public static boolean isValid(String cep) {
        if (cep == null) {
            return false;
        }

        return cep.matches("\\d{8}");
    }
}
