package com.mycompany.simuladoraf;

import java.nio.file.*;
import java.io.*;
import java.util.*;

public class SimuladorAF {
    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.err.println("Input esperado: $ ferramenta arquivo_do_automato.aut arquivo_de_testes.in");
            System.exit(1);
        }

        String arquivoAutomato = args[0];
        String arquivoEntradas = args[1];
        String arquivoSaida = arquivoEntradas.replace(".in", "_saida.out");

        Automato automato = Leitor.lerAutomato(arquivoAutomato);
        List<String> linhas = Files.readAllLines(Paths.get(arquivoEntradas));

        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(arquivoSaida))) {
            for (String linha : linhas) {
                if (linha.trim().isEmpty()) continue;

                String[] partes = linha.split(";");
                String palavra = partes[0];
                String esperado = partes[1];

                long inicio = System.nanoTime();
                boolean resultado;
                switch (automato.verificarTipo()) {
                    case "AFD"  -> resultado = Executar.AFD(palavra, automato);
                    case "AFND" -> resultado = Executar.AFND(palavra, automato);
                    case "AFNDe"-> resultado = Executar.AFNDe(palavra, automato);
                    default     -> { System.err.println("Tipo de automato nao reconhecido"); resultado = false; }
                }
                long fim = System.nanoTime();
                double duracaoSegundos = (fim - inicio) / 1e9;

                String linhaSaida = String.join(";",
                    palavra,
                    esperado,
                    resultado ? "1" : "0",
                    String.format("%.3f", duracaoSegundos)
                );

                System.out.println(linhaSaida);
                writer.write(linhaSaida);
                writer.newLine();
            }
        }
    }
}