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
}
