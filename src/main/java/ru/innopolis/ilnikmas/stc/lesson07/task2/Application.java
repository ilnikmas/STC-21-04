package ru.innopolis.ilnikmas.stc.lesson07.task2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.security.SecureRandom;
import java.time.Instant;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Класс для генерации тектовых файлов.
 *
 * @autor Маслёнченко И. Н.
 */
public class Application {

    private static final char[] LAST_CHAR_DICTIONARY = new char[]{'.', '!', '?'};
    private static final int ARRAY_MAX_WORDS = 1000;
    private static final int BOUND = 26; //Количество букв английского алфавита
    private static final Random random = new SecureRandom();

    public static void main(String[] args) throws IOException {
        getFiles("src/main/java/ru/innopolis/ilnikmas/stc/lesson07/task2/", 10, 2048, wordList(), 50);
    }

    /**
     * Метод генерирует файлы.
     *
     * @param path        - путь
     * @param n           - количество файлов
     * @param size        - размер файлов
     * @param words       - массив слов
     * @param probability - вероятность вхождения слова из words в предложение
     */
    public static void getFiles(String path, int n, int size, String[] words, int probability) throws IOException {
        for (int i = 0; i < n; i++) {
            generateFile(path, size, words, probability);
        }
    }

    /**
     * Метод генерирует файл, текст которого состоит из абзацев.
     *
     * @param path        - путь
     * @param size        - размер файлов в абзацах
     * @param words       - массив слов
     * @param probability - вероятность вхождения слова из words в предложение
     */
    public static void generateFile(String path, int size, String[] words, int probability) throws IOException {
        File file = new File(path + "-" + Instant.now().toEpochMilli());
        System.out.println(file.getName());
        file.createNewFile();
        Writer writer = new FileWriter(file);
        for (int i = 0; i < size; i++) {
            writer.write(generateParagraph(words, probability).toString());
        }
        writer.close();
    }

    /**
     * Метод генерирует абзац, в одном абзаце 1<=n3<=20 предложений.
     * В конце абзаца стоит разрыв строки и перенос каретки.
     *
     * @param words       - массив слов
     * @param probability - вероятность вхождения слова из words в предложение
     */
    private static StringBuilder generateParagraph(String[] words, int probability) {
        StringBuilder paragraph = new StringBuilder();
        int length = random.nextInt(20) + 1;
        for (int i = 0; i < length; i++) {
            paragraph.append(generateProposal(words, probability));
        }
        paragraph.append("\r\n");
        return paragraph;
    }

    /**
     * Метод генерирует предложение, которое состоит из 1<=n1<=15 слов.
     * Cлова разделены одним пробелом.
     * Предложение начинается с заглавной буквы
     * Предложение заканчивается (.|!|?)
     *
     * @param words       - массив слов
     * @param probability - вероятность вхождения слова из words в предложение
     */
    private static StringBuilder generateProposal(String[] words, int probability) {
        StringBuilder stringBuilder = new StringBuilder();
        int length = random.nextInt(14) + 1;
        boolean flagOfInsertFromWords = false;
        int indexOfWord = 0;
        if (random.nextInt(99) < probability) flagOfInsertFromWords = true;
        if (flagOfInsertFromWords) indexOfWord = random.nextInt(length);
        StringBuilder newWord;
        for (int i = 0; i < length; i++) {
            if (flagOfInsertFromWords && indexOfWord == i) {
                newWord = new StringBuilder(words[random.nextInt(words.length)]);
            } else {
                newWord = generateWord();
            }
            if (i == 0) {
                newWord.setCharAt(0, Character.toUpperCase(newWord.charAt(0)));
                stringBuilder.append(newWord);
                if (random.nextInt(5) > 3) stringBuilder.append(',');
                stringBuilder.append(' ');
            }
            if (i == length - 1) {
                stringBuilder.append(newWord).append(LAST_CHAR_DICTIONARY[random.nextInt(3)]).append(" ");
            }
            if (i != 0 && i != length - 1){
                stringBuilder.append(newWord);
                if (random.nextInt(5) > 3) stringBuilder.append(',');
                stringBuilder.append(' ');
            }
        }
        return stringBuilder;
    }

    /**
     * Метод генерирует слово, которое состоит из 1<=n2<=15 латинских букв
     */
    private static StringBuilder generateWord() {
        StringBuilder stringBuilder = new StringBuilder();
        int length = random.nextInt(14) + 1;
        for (int i = 0; i < length; i++) {
            stringBuilder.append((char) (random.nextInt(BOUND) + 'a'));
        }
        return stringBuilder;
    }

    /**
     * Метод создаёт массив из сгенерированных слов
     * @return массив слов
     */
    static String[] wordList() {
        Set<String> list = new HashSet<>();
        int wordsNum = random.nextInt(ARRAY_MAX_WORDS) + 1;
        while (list.size() < wordsNum) {
            list.add(generateWord().toString());
        }
        return list.toArray(new String[list.size()]);
    }
}

