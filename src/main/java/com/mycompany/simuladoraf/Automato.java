package com.mycompany.simuladoraf;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Set;

public class Automato {

    @SerializedName("initial")
    private int estadoInicial;

    @SerializedName("final")
    private Set<Integer> estadosFinais;

    @SerializedName("transitions")
    private List<Transicao> transicoes;

    public Automato() {}  // necessário para o Gson

    public int getEstadoInicial() {
        return estadoInicial;
    }

    public Set<Integer> getEstadosFinais() {
        return estadosFinais;
    }

    public List<Transicao> getTransicoes() {
        return transicoes;
    }

    public String verificarTipo() {
        for (Transicao t : transicoes) {
            if (t.getSimbolo() == null || t.getSimbolo().isEmpty()) {
                return "AFNDe";
            }
        }
        for (Transicao t1 : transicoes) {
            for (Transicao t2 : transicoes) {
                if (t1.getEstadoAtual() == t2.getEstadoAtual()
                        && t1.getSimbolo().equals(t2.getSimbolo())
                        && !t1.equals(t2)) {
                    return "AFND";
                }
            }
        }
        return "AFD";
    }
}