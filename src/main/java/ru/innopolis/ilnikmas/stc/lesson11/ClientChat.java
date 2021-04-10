package ru.innopolis.ilnikmas.stc.lesson11;

import java.io.*;
import java.net.Socket;

/**
 * Класс реализующий клиента для подключения к серверу
 *
 * @author Маслёнченко И. Н.
 */
public class ClientChat {

    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = new Socket("localhost", 9999);
        System.out.println("Start connect to server " + socket);
        ClientMessageReader clientMessageReader = new ClientMessageReader(socket);
        Thread thread = new Thread(clientMessageReader);
        thread.start();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        String s = "";
        while (!s.equals("stop")) {
            s = bufferedReader.readLine();
            bufferedWriter.write(s);
            bufferedWriter.newLine();
            bufferedWriter.flush();
            System.out.println("Send message: " + s);
        }
        clientMessageReader.setStop(true);
        thread.join();
    }
}
