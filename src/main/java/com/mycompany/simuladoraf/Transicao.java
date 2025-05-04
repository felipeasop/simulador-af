package com.mycompany.simuladoraf;

import com.google.gson.annotations.SerializedName;

public class Transicao {

    @SerializedName("from")
    private int estadoAtual;

    @SerializedName("read")
    private String simbolo;

    @SerializedName("to")
    private int proximoEstado;

    public Transicao() {}  // necessário para o Gson

    public int getEstadoAtual() {
        return estadoAtual;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public int getProximoEstado() {
        return proximoEstado;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Transicao other)) return false;
        return estadoAtual == other.estadoAtual
            && proximoEstado == other.proximoEstado
            && ((simbolo == null && other.simbolo == null)
                || (simbolo != null && simbolo.equals(other.simbolo)));
    }

    @Override
    public int hashCode() {
        int h = Integer.hashCode(estadoAtual);
        h = 31*h + (simbolo == null ? 0 : simbolo.hashCode());
        h = 31*h + Integer.hashCode(proximoEstado);
        return h;
    }
}