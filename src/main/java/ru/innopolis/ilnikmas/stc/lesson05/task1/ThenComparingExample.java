package ru.innopolis.ilnikmas.stc.lesson05.task1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ThenComparingExample {

    public static void main(String... args) {
        System.out.println("-- without thenComparing --");
        withoutThenComparing();
        System.out.println("-- with thenComparing --");
        withThenComparing();
    }


    private static void withoutThenComparing() {
        List<Book> list = createExampleBooks();
        System.out.println("before sort:");
        for (Book e : list) {
            System.out.println(e);
        }
        Collections.sort(list, Comparator.comparing(Book::getAuthor));
        System.out.println("after sort:");
        for (Book e : list) {
            System.out.println(e);
        }
    }


    private static void withThenComparing() {
        List<Book> list = createExampleBooks();
        System.out.println("before sort: ");
        for (Book e : list) {
            System.out.println(e);
        }
        Collections.sort(list, Comparator.comparing(Book::getAuthor).thenComparing(Book::getName));
        System.out.println("after sort: ");
        for (Book e : list) {
            System.out.println(e);
        }
    }

    private static List<Book> createExampleBooks() {
        return Arrays.asList(
                new Book("Sara", "book1"),
                new Book("Sara", "book3"),
                new Book("Sara", "book2"),
                new Book("John", "book5"),
                new Book("John", "book4")
        );
    }

    private static class Book {
        private String author;
        private String name;

        public Book(String author, String name) {
            this.author = author;
            this.name = name;
        }

        public String getAuthor() {
            return author;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return author + " - " + name;
        }
    }
}
