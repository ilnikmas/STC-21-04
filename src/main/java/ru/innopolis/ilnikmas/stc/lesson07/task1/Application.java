package ru.innopolis.ilnikmas.stc.lesson07.task1;

import java.io.*;
import java.util.*;

public class Application {
    private static final String INPUT_FILE_NAME = "src/main/java/ru/innopolis/ilnikmas/stc/lesson07/task1/Text.txt";
    private static final String OUTPUT_FILE_NAME = "src/main/java/ru/innopolis/ilnikmas/stc/lesson07/task1/Output.txt";
    private static final int RUSSIAN_LETTER_FIRST = 1040;
    private static final int RUSSIAN_LETTER_LAST = 1103;
    private static Set<String> wordList = new HashSet<>();

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE_NAME))){
            int i = -1;
            StringBuffer sb = new StringBuffer("");
            while ((i = br.read()) != -1){
                if (i <= RUSSIAN_LETTER_LAST && i >= RUSSIAN_LETTER_FIRST){
                    sb.append((char) i);
                } else if (sb.length() > 0){
                    wordList.add(sb.toString().toUpperCase());
                    sb.setLength(0);
                }
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
        }

        List<String> sortedList = new ArrayList<>(wordList);
        Collections.sort(sortedList);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(OUTPUT_FILE_NAME))){
                bw.write(String.valueOf(sortedList));
            } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}

