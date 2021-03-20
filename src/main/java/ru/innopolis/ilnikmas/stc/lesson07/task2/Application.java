package ru.innopolis.ilnikmas.stc.lesson07.task2;

import java.util.Random;
import java.util.Set;

public class Application {
    private static final int WORD_MAX_LETTERS = 15;
    private static final int SENTENCE_MAX_WORDS = 15;
    private static final int PPARAGRAPH_MAX_SENTENCES = 20;
    private static final int ARRAY_MAX_WORDS = 1000;
    private static final int BOUND = 26; //Количество букв английского алфавита
    private static Random random = new Random();

    /**
     * Метод генерирует случайный символ из таблицы unicode
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
     * @return имя длиной от 3 до 8 символов
     */
    static String wordGenerate() {
        StringBuffer word = new StringBuffer();
        int wordLength = random.nextInt(WORD_MAX_LETTERS);
//        word.append(String.valueOf(letterGen()).toUpperCase());
        for (int j = 1; j <= wordLength - 1; j++) {
            word.append(letterGen());
        }
        return word.toString();
    }

    static Set<String> wordList(){
        return null;
    }

}
