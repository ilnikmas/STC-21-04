package ru.innopolis.ilnikmas.stc.lesson10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Реализация моего класслодера.
 */
public class MyClassLoader extends ClassLoader {

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        System.out.println("findClass starts work: " + name);
        if ("ru.innopolis.ilnikmas.stc.lesson10.DynamicWorker".equals(name)) {
            try {
                byte[] bytes = Files.readAllBytes(Paths.get("DynamicWorker.class"));
                return defineClass(name, bytes, 0, bytes.length); // мапит byte[] в Class
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if ("ru.innopolis.ilnikmas.stc.lesson10.Runner".equals(name)) {
            try {
                byte[] bytes = Files.readAllBytes(Paths.get("target/classes/ru/innopolis/ilnikmas/stc/lesson10/Runner.class"));
                return defineClass(name, bytes, 0, bytes.length); // мапит byte[] в Class
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return super.findClass(name);
    }
}
