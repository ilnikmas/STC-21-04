package ru.innopolis.ilnikmas.stc.lesson11;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.Instant;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Класс реализующий сервер, который может работать в нескольких режимах:
 * unicast;
 * broadcast.
 * Комманды воспринимаемые сервером:
 * unicast - переход в режим личных сообщений, формат сообщений(имя_пользователя_без_пробелов:текст сообщения);
 * broadcast - переход в режим массовых сообщений;
 * stop - остановка сессии, так же останавливается при бездействии определенное время;
 *
 * @author Маслёнченко И. Н.
 */
public class ServerChat implements AutoCloseable {

    private ServerSocket serverSocket;
    private Socket socket;
    private ConcurrentMap<String, Connection> connectionMap;
    private ExecutorService executorService;
    private ConcurrentMap<String, Instant> instantMap;
    private MessageService messageService;
    private ConnectionService connectionService;
    private Thread connectionServiceThread;

    public ServerChat() throws IOException {
        serverSocket = new ServerSocket(9999);
        connectionMap = new ConcurrentHashMap<String, Connection>();
        executorService = Executors.newFixedThreadPool(100);
        instantMap = new ConcurrentHashMap<String, Instant>();
        messageService = new MessageService(connectionMap);
        connectionService = new ConnectionService(connectionMap, instantMap);
        connectionServiceThread = new Thread(connectionService);
    }

    /**
     * Метод для запуска сервера.
     */
    public void start() throws IOException {
        try {
            while (true) {
                socket = serverSocket.accept();
                Connection connection = new Connection(socket, connectionService, messageService);
                System.out.println("Start connection! " + socket);
                executorService.execute(connection);
            }
        } finally {
            try {
                close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void stopConnection(Connection connection) throws IOException {
        connection.getClientSocket().close();

    }

    @Override
    public void close() throws Exception {
        serverSocket.close();
        connectionService.close();
        executorService.shutdown();
        connectionServiceThread.join();
    }
}
