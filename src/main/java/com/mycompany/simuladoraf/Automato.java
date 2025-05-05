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
        for (int i = 0; i < transicoes.size(); i++) {
            Transicao t1 = transicoes.get(i);
            for (int j = i + 1; j < transicoes.size(); j++) {
                Transicao t2 = transicoes.get(j);
                if (t1.getEstadoAtual() == t2.getEstadoAtual() 
                    && t1.getSimbolo().equals(t2.getSimbolo()) 
                    && t1.getProximoEstado() != t2.getProximoEstado()) {
                    return "AFND";
                }
            }
        }
        return "AFD";
    }
}
