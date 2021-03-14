package ru.innopolis.ilnikmas.stc.lesson02.task3;

/**
 * Пользовательское исключение, возникающее при нахождении
 * в таблице записи с одинаковым именем и возрастом
 */

public class DuplicateRecordException extends Exception {
    DuplicateRecordException(String message) {
        super(message);
    }
}
