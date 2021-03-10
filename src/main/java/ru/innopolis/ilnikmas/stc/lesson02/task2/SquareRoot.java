package ru.innopolis.ilnikmas.stc.lesson02.task2;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class SquareRoot {
    public static void main(String[] args) {
        System.out.println("Введите положительное целое число: ");
        Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            if (n > 0) {
                for (int i = 0; i < n; i++) {
                    final Random random = new Random();
                    int k = 0;
                    try {
                        k = random.nextInt();
                        if (k < 0) throw new MyException("Сгенерировано отрицательное число");
                    } catch (MyException e) {
//                        System.out.println(e.getMessage());
                    }
                    double q;
                    int q2;
                    q = Math.sqrt(k);
                    q2 = (int) q;
                    if (q2 * q2 == k) {
                        System.out.println((int) q);
                    }
                }
            } else {
                System.out.println("Вводить нужно положительное число!");
            }
    }
}

class MyException extends InputMismatchException {
    MyException(String message) {
        super(message);
    }
}
