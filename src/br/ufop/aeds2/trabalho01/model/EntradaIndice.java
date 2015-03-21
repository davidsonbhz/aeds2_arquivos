/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufop.aeds2.trabalho01.model;

/**
 *
 * @author davidson
 */
public class EntradaIndice {
    private int chave;
    private long inicio, termino;

    public EntradaIndice(int chave, long inicio, long termino) {
        this.chave = chave;
        this.inicio = inicio;
        this.termino = termino;
    }

    public int getChave() {
        return chave;
    }

    public void setChave(int chave) {
        this.chave = chave;
    }

    public long getInicio() {
        return inicio;
    }

    public void setInicio(long inicio) {
        this.inicio = inicio;
    }

    public long getTermino() {
        return termino;
    }

    public void setTermino(long termino) {
        this.termino = termino;
    }
    
    

}
