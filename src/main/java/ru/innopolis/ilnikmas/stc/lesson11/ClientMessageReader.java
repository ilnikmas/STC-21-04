package ru.innopolis.ilnikmas.stc.lesson11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Класс работающий на стороне клиента, отслеживающий приходящие сообщения.
 */
public class ClientMessageReader implements Runnable {

    private Socket socket;
    private boolean stop = false;

    public ClientMessageReader(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String s;
            while (!stop) {
                s = bufferedReader.readLine();
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }
}
