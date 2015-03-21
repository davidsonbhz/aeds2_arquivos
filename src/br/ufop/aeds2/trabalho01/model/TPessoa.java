/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufop.aeds2.trabalho01.model;

import br.ufop.aeds2.trabalho01.controller.Cadastro;

/**
 *
 * @author davidson
 */
public class TPessoa {
    
    private String nome, endereco;
    private int cpf, rg;
    private TConvenio convenio;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public int getRg() {
        return rg;
    }

    public void setRg(int rg) {
        this.rg = rg;
    }

    public TConvenio getConvenio() {
        return convenio;
    }

    public void setConvenio(TConvenio convenio) {
        this.convenio = convenio;
    }

    @Override
    public String toString() {
        //retorna o registro
        return this.cpf + Cadastro.delimitador + this.nome + Cadastro.delimitador + this.rg + Cadastro.delimitador + this.convenio + "#";
    }

    
    
}
