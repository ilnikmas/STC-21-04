package ru.innopolis.ilnikmas.stc.lesson11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Класс подключения.
 */
public class Connection implements Runnable {

    private Socket clientSocket;
    private BufferedReader in;
    private ConnectionMode connectionMode = ConnectionMode.BROADCAST;
    private ConnectionService connectionService;
    private String name;
    private MessageService messageService;

    public Connection(Socket clientSocket, ConnectionService connectionService, MessageService messageService) {
        this.clientSocket = clientSocket;
        this.connectionService = connectionService;
        this.messageService = messageService;
    }

    @Override
    public void run() {
        //считывание имени и его регистрация
        try {
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            name = in.readLine();
            connectionService.addConnection(name, this);

        } catch (IOException e) {
            e.printStackTrace();
        }
        //цикл получения от клиента сообщений
        while (connectionMode != ConnectionMode.STOP) {
            try {
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                String s = in.readLine();
                connectionService.updateTime(name);
                if (s != null) {
                    if (s.equals("broadcast")) {
                        connectionMode = ConnectionMode.BROADCAST;
                        continue;
                    } else if (s.equals("unicast")) {
                        connectionMode = ConnectionMode.UNICAST;
                        continue;
                    } else if (s.equals("stop")) {
                        connectionMode = ConnectionMode.STOP;
                        continue;
                    }
                    if (connectionMode == ConnectionMode.UNICAST) messageService.sendUnicastMessage(s.substring(0,s.indexOf(':')),s);
                    if (connectionMode == ConnectionMode.BROADCAST) messageService.sendBroacastMessage(s, name);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void stop() {
        connectionMode = ConnectionMode.STOP;
    }

    public Socket getClientSocket() {
        return clientSocket;
    }

    public BufferedReader getIn() {
        return in;
    }

    public ConnectionMode getConnectionMode() {
        return connectionMode;
    }

    public void setConnectionMode(ConnectionMode connectionMode) {
        this.connectionMode = connectionMode;
    }
}
