/*
 * Trabalho em grupo

   Davidson
   Bárbara
   Guilherme

 */
package br.com.ufop.aeds2.trabalho01;

import br.ufop.aeds2.trabalho01.controller.Cadastro;
import br.ufop.aeds2.trabalho01.exceptions.DadosIncompletosException;
import br.ufop.aeds2.trabalho01.model.TPessoa;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.READ;
import static java.nio.file.StandardOpenOption.WRITE;

/**
 *
 * @author davidson
 */
public class Arquivos {

    public static void anexar(byte dados[], String arquivo) {
        //adiciona o texto ao final do arquivo

    }

    public static String ler(String arquivo, long offset, int tamanho) throws FileNotFoundException, IOException {
        RandomAccessFile aFile = new RandomAccessFile(arquivo, "rw");
        FileChannel inChannel = aFile.getChannel();

        ByteBuffer buf = ByteBuffer.allocate(48);
        StringBuilder sb = new StringBuilder();

        inChannel.position(offset);
        int bytesRead = inChannel.read(buf, tamanho);

        int c = 0;
        while (bytesRead != -1) {

            System.out.println("Read " + bytesRead);
            buf.flip();

            while (buf.hasRemaining()) {
                //System.out.print((char) buf.get());
                sb.append((char) buf.get());
                c++;
            }

            buf.clear();
            if (c >= tamanho) {
                break;
            }
            bytesRead = inChannel.read(buf);
        }
        aFile.close();

        return sb.toString();
    }

    public static void escrever(byte dados[], String arquivo, long offset) {
        //escreve o texto em offset 
        //String s = "I was here!\n";
        Path file = Paths.get(arquivo);
        //byte data[] = s.getBytes();
        ByteBuffer out = ByteBuffer.wrap(dados);

        try (FileChannel fc = (FileChannel.open(file, READ, WRITE))) {
            //com o objeto de manipulação de arquivos, posiciona o cursor na posição offset
            fc.position(offset);
            while (out.hasRemaining()) {
                fc.write(out);
            }
            out.rewind();

        } catch (IOException x) {
            System.out.println("I/O Exception: " + x);
        }
    }

    public static void main(String[] args) throws Exception, DadosIncompletosException {
        //escrever(" YYYYYYYY ".getBytes(), "/sistema/aeds2/teste", 1000);
        //anexar("ufop - aeds2 ".getBytes(), "/sistema/aeds2/teste");

        Cadastro cad = new Cadastro("/sistema/projetos/aeds2/pacientes");
        
        TPessoa p = new TPessoa();
        p.setCpf(123456);
        p.setEndereco("rua xyz, 999");
        p.setNome("davidson esteves nunes");
        p.setRg(325447);
        
        
        cad.adicionaPessoa(p);
        
        
        //teste de cadastro 02
        
        
    }

    
}
