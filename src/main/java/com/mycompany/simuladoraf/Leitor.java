package com.mycompany.simuladoraf;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import java.io.FileReader;

public class Leitor {
    public static Automato lerAutomato(String nomeArquivo) throws Exception {
        try (JsonReader reader = new JsonReader(new FileReader(nomeArquivo))) {
            return new Gson().fromJson(reader, Automato.class);
        }
    }
}