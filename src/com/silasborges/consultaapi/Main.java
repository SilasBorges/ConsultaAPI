package com.silasborges.consultaapi;

import com.silasborges.consultaapi.framework.ApiClient;
import com.silasborges.consultaapi.model.BuilderJson;
import com.silasborges.consultaapi.utils.CepOmdb;
import com.silasborges.consultaapi.utils.ValidCep;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<CepOmdb> cep = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        ApiClient apiCep = new ApiClient();
        String search = "";

        try {

            while (true) {
                System.out.println("Digite o cep: ");
                search = sc.nextLine();
                CepOmdb cepOmdb;

                if (search.equalsIgnoreCase("sair")) {
                    System.out.println("Encerrando...");
                    break;
                }

                if (ValidCep.isValid(search)) {

                    cepOmdb = apiCep.getCep(search);
                    System.out.println(cepOmdb);
                    cep.add(cepOmdb);

                } else {
                    System.out.println("Cep invalido, digite novamente.");
                }
                BuilderJson buildJson = new BuilderJson();
                buildJson.createJson(cep);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}