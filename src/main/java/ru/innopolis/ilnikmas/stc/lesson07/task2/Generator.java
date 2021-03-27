package ru.innopolis.ilnikmas.stc.lesson07.task2;

import java.util.*;

public class Generator {
    private static final int WORD_MAX_LETTERS = 15;
    private static final int SENTENCE_MAX_WORDS = 15;
    private static final int PARAGRAPH_MAX_SENTENCES = 20;
    private static final int ARRAY_MAX_WORDS = 1000;
    private static final int BOUND = 26; //Количество букв английского алфавита
    private static Random random = new Random();

    /**
     * Метод генерирует случайный символ из таблицы unicode
     *
     * @return сивмол в диапазоне от a до z
     */
    static char letterGen() {
        int dec = random.nextInt(BOUND) + 'a';
        String hexStr = Integer.toHexString(dec);
        return (char) Integer.parseInt(hexStr, 16);
    }

    /**
     * Метод генерирует слово, составленное из сгенерированных
     * символов от a до z
     *
     * @return имя длиной от 3 до 8 символов
     */
    static String wordGenerate() {
        StringBuffer word = new StringBuffer();
        int wordLength = random.nextInt(WORD_MAX_LETTERS) + 1;
        for (int i = 0; i < wordLength; i++) {
            word.append(letterGen());
        }
        return word.toString();
    }

    static String sentenceGenerate(int probability) {
        int sentenceLength = random.nextInt(SENTENCE_MAX_WORDS) + 1;
        char emotion = ' ';
        StringBuffer sentence = new StringBuffer();
        String[] wordsList = wordList();
        sentence.append(firstUpperCase(wordsList[random.nextInt(wordsList.length - 1)]));
        for (int i = 0; i < sentenceLength; i++) {
            if (random.nextInt(3) == 0 && i != sentenceLength - 1) {
                sentence.append(", ");
            } else {
                sentence.append(" ");
            }
            sentence.append(wordsList[random.nextInt(wordsList.length - 1)]);
        }
        String result = sentence.toString().trim();
        switch (random.nextInt(2) + 1){
            case 0: emotion = '.';
            break;
            case 1: emotion = '!';
            break;
            case 2: emotion = '?';
            break;
        }
        return result + emotion;
    }

    static String[] wordList() {
        Set<String> list = new HashSet<>();
        int wordsNum = random.nextInt(ARRAY_MAX_WORDS) + 1;
        while (list.size() < wordsNum){
            list.add(wordGenerate());
        }
        return list.toArray(new String[list.size()]);
    }

    static String paragraphGenerate(){
        int paragraphLength = random.nextInt(PARAGRAPH_MAX_SENTENCES) + 1;
        StringBuffer paragraph = new StringBuffer();
        for (int i = 0; i < paragraphLength; i++){
            if (i == paragraphLength - 1)
                paragraph.append('\n');
            else {
                paragraph.append(sentenceGenerate(2));
                paragraph.append(" ");
            }
        }
        return paragraph.toString();
    }

    static String firstUpperCase(String word) {
        if (word.length() >= 2) return word.substring(0, 1).toUpperCase() + word.substring(1);
        else return word.toUpperCase();
    }

    public static void main(String[] args) {
        System.out.println(paragraphGenerate());
    }
}
