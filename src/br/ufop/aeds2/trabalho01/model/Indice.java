/*
 * Controla o índice de acesso a um arquivo
 */
package br.ufop.aeds2.trabalho01.model;

import br.ufop.aeds2.trabalho01.controller.IO;
import java.nio.file.Path;
import java.util.ArrayList;

/**
 *
 * @author davidson
 */
public class Indice {

    private ArrayList<EntradaIndice> itens;
    private String arquivoindice, arquivodados;
    private Path path;
    private long posicaofinal; //indica a posição do próximo item a ser inserido
    private IO io;

    public Indice(String arquivoindice, String arquivodados) {
        this.arquivoindice = arquivoindice;
        this.arquivodados = arquivodados;
        //inicializa o array de entradas de indice
        
        /*a estrutura do índice será:
         chave,inicio,fim
         00012,399449,567778
         00234,220334,995533
         */
        
        itens = new ArrayList<>();
        io = new IO();
        String conteudo = io.lertTodoArquivo(arquivoindice);
        if(conteudo.equals("")) {
            return;
        }
        String linhas[] = conteudo.split("\n");
        for (String l : linhas) {
            String a[] = l.split(",");
            EntradaIndice ei = new EntradaIndice(Integer.valueOf(a[0]), Integer.valueOf(a[1]), Integer.valueOf(a[2]));
            itens.add(ei);
        }

    }
    
    
    public void indexar() {
        
    }

    public void add(EntradaIndice i) {
        //adiciona uma entrada ao indice
        this.itens.add(i);
        gravaIndice();
    }

    private void gravaIndice() {
        //grava o arquivo de indice
        
    }
}
