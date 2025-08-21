package com.silasborges.consultaapi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.silasborges.consultaapi.framework.ApiClient;
import com.silasborges.consultaapi.model.Cep;
import com.silasborges.consultaapi.utils.CepOmdb;
import com.silasborges.consultaapi.utils.ValidCep;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        List<Cep> cep = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        ApiClient apiCep = new ApiClient();
        String search = "";

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        try {

            while (true) {
                System.out.println("Digite o cep: ");
                search = sc.nextLine();

                if (search.equalsIgnoreCase("sair")) {
                    System.out.println("Encerrando...");
                    break;
                }

                if (ValidCep.isValid(search)) {
                    String result = apiCep.getCep(search);
                    CepOmdb cepOmdb = gson.fromJson(result, CepOmdb.class);
                    System.out.println(cepOmdb);
                    Cep myCep = new Cep(cepOmdb);
                    cep.add(myCep);

                } else {
                    System.out.println("Cep invalido, digite novamente.");
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        FileWriter jsonCep = new FileWriter("cep.json");
        jsonCep.write(gson.toJson(cep));
        jsonCep.close();
        System.out.println("O programa finalizou corretamente!");
    }
}
