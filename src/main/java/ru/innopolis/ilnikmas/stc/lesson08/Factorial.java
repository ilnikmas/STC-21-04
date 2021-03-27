package ru.innopolis.ilnikmas.stc.lesson08;

import java.math.BigInteger;

/**
 * Класс, содержащий метод для вычисления факториала
 */

public class Factorial {
    // Массив для хранения промежуточных значений вычисления факториала
    private static BigInteger[] factorials = new BigInteger[1000];

    /**
     * Метод для вычисления факториала.
     * Для ускорения вычисления используется массив
     * с промежуточными значениями вычисленных в цикле
     * факториалов
     * @param number
     * @return
     */
    public String calculate(int number){
        BigInteger result = BigInteger.valueOf(1);
        if (number ==0 || number ==1) {
            result = BigInteger.valueOf(1);
            factorials[number] = result;
        }
        for (int i = 2; i <= number; i++){
            if (getFactorial(i) == null){
                result = result.multiply(BigInteger.valueOf(i));
                putFactorial(i, result);
            } else result = getFactorial(i);

        }
        return "Факториал " + number + " = " + result;
    }

    /**
     * Метод помещает вычисленное значение факториала в таблицу
     * на позицию с индексом number
     * @param number
     * @param factorial
     */
    public void putFactorial(int number, BigInteger factorial){
        factorials[number] = factorial;
    }

    /**
     * Метод возвращает значение вычисленного факториала
     * из таблицы
     * @param number
     * @return
     */
    public BigInteger getFactorial(int number){
        return factorials[number];
    }
}
