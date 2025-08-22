package com.silasborges.consultaapi.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.silasborges.consultaapi.utils.CepOmdb;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class BuilderJson {

    public void createJson(List<CepOmdb> cep) throws IOException {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        FileWriter jsonCep = new FileWriter("cep.json");
        jsonCep.write(gson.toJson(cep));
        jsonCep.close();
    }
}
