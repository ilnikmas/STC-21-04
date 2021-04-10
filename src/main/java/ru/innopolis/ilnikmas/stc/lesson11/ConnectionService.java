package ru.innopolis.ilnikmas.stc.lesson11;

import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentMap;

/**
 * Класс реализующий сервис подключений.
 */
public class ConnectionService implements Runnable {

    private boolean stop = false;
    private ConcurrentMap<String, Connection> connectionMap;
    private ConcurrentMap<String, Instant> instantMap;

    public ConnectionService(ConcurrentMap<String, Connection> connectionMap, ConcurrentMap<String, Instant> instantMap) {
        this.connectionMap = connectionMap;
        this.instantMap = instantMap;
    }

    public void addConnection(String name, Connection connection) {
        instantMap.put(name, Instant.now());
        connectionMap.put(name, connection);
    }

    public void updateTime(String name) {
        instantMap.put(name, Instant.now());
    }

    @Override
    public void run() {
        List<String> listOfConnectionByDelete = new ArrayList<String>();
        while (!stop) {
            connectionMap.entrySet().stream().forEach(con -> {
                if (con.getValue().getConnectionMode() == ConnectionMode.STOP)
                    listOfConnectionByDelete.add(con.getKey());
            });
            for (String con : listOfConnectionByDelete) {
                connectionMap.remove(con);
                instantMap.remove(con);
            }
            listOfConnectionByDelete.clear();
            instantMap.entrySet().stream().forEach(con -> {
                if (Instant.now().toEpochMilli() - con.getValue().toEpochMilli() > 100_000)
                    listOfConnectionByDelete.add(con.getKey());
            });
            for (String con : listOfConnectionByDelete) {
                connectionMap.get(con).setConnectionMode(ConnectionMode.STOP);
                connectionMap.remove(con);
                instantMap.remove(con);
            }
            listOfConnectionByDelete.clear();
        }
    }

    public void close() throws IOException {
        Iterator iterator = connectionMap.values().iterator();
        while (iterator.hasNext()) {
            ((Connection) iterator.next()).getClientSocket().close();
        }
        instantMap.clear();
        connectionMap.clear();
        stop = true;
    }
}
