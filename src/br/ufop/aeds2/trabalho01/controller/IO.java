/*
 * Classe de Input/Output do sistema: gerencia o acesso ao arquivo
 */
package br.ufop.aeds2.trabalho01.controller;

import java.io.File;
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
public class IO {

    public void gravarArquivo(String dado, String arquivo, long offset) {
        //grava o dado passado na posição definida por offset no arquivo
        Path file = Paths.get(arquivo);
        byte dados[] = dado.getBytes();

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
    
    public String lertTodoArquivo(String arquivo) {
        try {
            
            if(!(new File(arquivo)).exists()) {
                return "";
            }
            
            RandomAccessFile aFile = new RandomAccessFile(arquivo, "rw");
            FileChannel inChannel = aFile.getChannel();

            ByteBuffer buf = ByteBuffer.allocate(48);
            StringBuilder sb = new StringBuilder();

            inChannel.position(0);
            int bytesRead = 0;

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
                bytesRead = inChannel.read(buf);
            }
            aFile.close();

            return sb.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public String lerBlocoDados(String arquivo, long offset, int tamanhoBloco) {
        try {
            RandomAccessFile aFile = new RandomAccessFile(arquivo, "rw");
            FileChannel inChannel = aFile.getChannel();

            ByteBuffer buf = ByteBuffer.allocate(48);
            StringBuilder sb = new StringBuilder();

            inChannel.position(offset);
            int bytesRead = inChannel.read(buf, tamanhoBloco);

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
                if (c >= tamanhoBloco) {
                    break;
                }
                bytesRead = inChannel.read(buf);
            }
            aFile.close();

            return sb.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public long adicionaAoArquivo(String arquivo, String dado) {
        //adiciona a string ao final do arquivo
        //grava o dado passado na posição definida por offset no arquivo
        Path file = Paths.get(arquivo);
        byte dados[] = dado.getBytes();

        ByteBuffer out = ByteBuffer.wrap(dados);

        try (FileChannel fc = (FileChannel.open(file, READ, WRITE))) {
            //com o objeto de manipulação de arquivos, posiciona o cursor na posição offset
            fc.position(fc.size());
            while (out.hasRemaining()) {
                fc.write(out);
            }
            out.rewind();
            return fc.size();
        } catch (IOException x) {
            System.out.println("I/O Exception: " + x);
        }
        return 0;
        
    }

}
