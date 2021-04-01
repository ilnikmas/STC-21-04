package ru.innopolis.ilnikmas.stc.lesson08;

import java.util.*;
import java.util.concurrent.*;

/**
 *
 */

public class Task1 {
    private static final int MAX_CALC_NUMBER = 20;
    private static int[] numbersArray = new int[10000];
    public static void main(String []args) throws ExecutionException, InterruptedException {
        for (int i = 0; i < numbersArray.length; i++){
            numbersArray[i] = new Random().nextInt(MAX_CALC_NUMBER);
        }

        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        Factorial factorial = new Factorial();
        long startTime = System.currentTimeMillis();
        List<Future<String>> futures = new ArrayList<>();
        for (int i = 0; i < numbersArray.length; i++){
            final int j = i;
            futures.add(CompletableFuture.supplyAsync(() -> factorial.calculate(numbersArray[j]), threadPool));
        }

        for (Future<String> future : futures){
            System.out.println(future.get());
        }
        long finishTime = System.currentTimeMillis();
        System.out.println(finishTime  - startTime);
        threadPool.shutdown();
    }

}
