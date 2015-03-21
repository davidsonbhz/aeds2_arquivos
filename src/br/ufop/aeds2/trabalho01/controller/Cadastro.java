/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufop.aeds2.trabalho01.controller;

import br.ufop.aeds2.trabalho01.exceptions.DadosIncompletosException;
import br.ufop.aeds2.trabalho01.model.EntradaIndice;
import br.ufop.aeds2.trabalho01.model.Indice;
import br.ufop.aeds2.trabalho01.model.TPessoa;
import java.util.ArrayList;

/**
 *
 * @author davidson
 */
public class Cadastro {

    public ArrayList<TPessoa> pessoas;
    private Indice index;
    public static String delimitador = "|";
    private IO io;
    private String arquivodados;

    public Cadastro(String arquivodados) {
        index = new Indice(arquivodados + "_idx", arquivodados);
        io = new IO();
        this.arquivodados = arquivodados;
        
    }

    public ArrayList<TPessoa> getPessoas() {
        return pessoas;
    }

    public void adicionaPessoa(TPessoa p) throws DadosIncompletosException {
        if (p == null) {
            throw new DadosIncompletosException("REGISTRO DE PESSOA NULO!");
        }
        
        
        String k = p.toString();
        long offset = io.adicionaAoArquivo(arquivodados, k);
        
        EntradaIndice i = new EntradaIndice(p.getCpf(), offset-k.length(), offset);
        index.add(i);
        System.out.println(k);

    }

    public void removePessoa(TPessoa p) {

    }

    public void removePessoa(String id) {

    }

    public void atualizaPessoa(TPessoa p) {

    }

}
