/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package br.com.orangegreen.pkgilinks;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author andre
 */
public class PKGiLinks {

    public static void main(String[] args) throws IOException {
        System.out.println("___PKGiLinks___");

        criarArquivo();
    }

    public static void criarArquivo() throws IOException {

        try ( FileWriter fileWriter = new FileWriter("/home/andre/Downloads/pkgi.txt")) {

            File file = new File("/home/andre/Downloads/PS3_GAMES.tsv");
            List<String[]> collect = Files.lines(file.toPath()).map(line -> line.split("\t")).collect(Collectors.toList());

            for (String[] next : collect) {
                if (!Arrays.toString(next).contains("MISSING,") && !Arrays.toString(next).contains("PKG direct link")) {
                    fileWriter.write(next[5] + ",1," + next[2] + "," + next[2] + "," + next[4] + "," + next[3] + "," + next[8] + "," + System.lineSeparator());
                }
            }
            
            file = new File("/home/andre/Downloads/PS3_DLCS.tsv");
            collect = Files.lines(file.toPath()).map(line -> line.split("\t")).collect(Collectors.toList());

            for (String[] next : collect) {
                if (!Arrays.toString(next).contains("MISSING,") && !Arrays.toString(next).contains("PKG direct link")) {
                    fileWriter.write(next[5] + ",2," + next[2] + "," + next[2] + "," + next[4] + "," + next[3] + "," + next[8] + "," + System.lineSeparator());
                }
            }
        }

        System.out.println("Successfully wrote to the file.");
    }
}
