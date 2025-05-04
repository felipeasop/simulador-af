package com.mycompany.simuladoraf;

import java.util.*;

public class Executar {
    public static boolean AFD(String palavra, Automato automato) {
        int estado = automato.getEstadoInicial();
        
        for (char c : palavra.toCharArray()) {
            boolean transicaoValida = false;
            for (Transicao t : automato.getTransicoes()) {
                if (t.getEstadoAtual() == estado && t.getSimbolo().equals(String.valueOf(c))) {
                    estado = t.getProximoEstado();
                    transicaoValida = true;
                    break;
                }
            }
            if (!transicaoValida) return false;
        }
        return automato.getEstadosFinais().contains(estado);
    }
    
    public static boolean AFND(String palavra, Automato automato) {
        Set<Integer> atuais = new HashSet<>();
        atuais.add(automato.getEstadoInicial());

        for (char c : palavra.toCharArray()) {
            String simbolo = String.valueOf(c);
            Set<Integer> proximos = new HashSet<>();
            for (int estado : atuais) {
                for (Transicao t : automato.getTransicoes()) {
                    if (t.getEstadoAtual() == estado && simbolo.equals(t.getSimbolo())) {
                        proximos.add(t.getProximoEstado());
                    }
                }
            }
            atuais = proximos;
            if (atuais.isEmpty()) return false;
        }

        for (int estado : atuais) {
            if (automato.getEstadosFinais().contains(estado)) return true;
        }
        return false;
    }
    
    public static boolean AFNDe(String palavra, Automato automato) {
        Set<Integer> atuais = fechamentoEpsilon(Set.of(automato.getEstadoInicial()), automato);

        for (char c : palavra.toCharArray()) {
            String simbolo = String.valueOf(c);
            Set<Integer> proximos = new HashSet<>();
            for (int estado : atuais) {
                for (Transicao t : automato.getTransicoes()) {
                    if (t.getEstadoAtual() == estado && simbolo.equals(t.getSimbolo())) {
                        proximos.add(t.getProximoEstado());
                    }
                }
            }
            atuais = fechamentoEpsilon(proximos, automato);
            if (atuais.isEmpty()) return false;
        }

        for (int estado : atuais) {
            if (automato.getEstadosFinais().contains(estado)) return true;
        }
        return false;
    }
    
    private static Set<Integer> fechamentoEpsilon(Set<Integer> estados, Automato automato) {
        Set<Integer> fecho = new HashSet<>(estados);
        Deque<Integer> pilha = new ArrayDeque<>(estados);

        while (!pilha.isEmpty()) {
            int atual = pilha.pop();
            for (Transicao t : automato.getTransicoes()) {
                if (t.getEstadoAtual() == atual &&
                    (t.getSimbolo() == null || t.getSimbolo().isEmpty()) &&
                    !fecho.contains(t.getProximoEstado())) {

                    fecho.add(t.getProximoEstado());
                    pilha.push(t.getProximoEstado());
                }
            }
        }

        return fecho;
    }
}
