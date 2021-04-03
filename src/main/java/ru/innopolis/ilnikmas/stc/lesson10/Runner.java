package ru.innopolis.ilnikmas.stc.lesson10;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Runner implements Running {

    private static final JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

    public void run() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
        File file = new File("DynamicWorker.java");
        file.createNewFile();
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write("package ru.innopolis.ilnikmas.stc.lesson10;\n" + "\n" + "public class DynamicWorker implements Worker {\n" + "\n" + "    @Override\n" + "    public void doWork() { ");
        Scanner in = new Scanner(System.in);
        String s = "";
        System.out.println("Вводите код построчно:");
        while (true) {
            s = in.nextLine();
            if (s.equals("")) break;
            fileWriter.write(s);
        }
        fileWriter.write("}\n" + "}");
        fileWriter.close();
        compiler.run(null, null, null, file.getAbsolutePath());
        DynamicWorker dynamicWorker = new DynamicWorker();
        System.out.println(dynamicWorker.getClass().getClassLoader().getClass().getCanonicalName());
        System.out.println(this.getClass().getClassLoader().getClass().getCanonicalName());
        dynamicWorker.doWork();
    }
}
