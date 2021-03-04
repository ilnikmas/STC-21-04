package ru.innopolis.ilnikmas.stc.lesson02.task1;

public class Exception {
    public static void main(String[] args) {
        //ArrayIndexOutOfBoundsException
        try {
            int arr[] = {1};
            arr[2] = 3;
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        //NullPointerException
        try {
            Object obj = null;
            obj.hashCode();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        //ArithmeticException
        try {
            throw new ArithmeticException();
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
        System.out.println("Hello, World!");
    }
}
