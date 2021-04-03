package ru.innopolis.ilnikmas.stc.lesson10;

import java.io.IOException;

/**
 * Класс для запуска моего класслоадера.
 *
 * @author Маслёнченко И. Н.
 */
public class ApplicationForMyClassLoader {

    private static final ClassLoader cl = new MyClassLoader();

    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> kindClass = cl.loadClass("ru.innopolis.ilnikmas.stc.lesson10.Runner");
        Running runner = (Running) kindClass.newInstance();
        runner.run();
    }
}
