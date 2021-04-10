package ru.innopolis.ilnikmas.stc.lesson11;

import java.io.IOException;

public class Application {

    public static void main(String[] args) throws IOException {
        ServerChat serverChat = new ServerChat();
        serverChat.start();
    }
}
