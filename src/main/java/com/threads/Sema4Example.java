package com.threads;

import lombok.SneakyThrows;
import lombok.var;
import org.checkerframework.checker.units.qual.C;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Sema4Example {
    @SneakyThrows
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(200);
        for (int i = 0; i < 200; i++) {
            service.submit(() -> Connection.getInstance().doWork());
        }
        service.shutdown();
        boolean b = service.awaitTermination(30, TimeUnit.SECONDS);
      //  System.out.println("Total connections created: " + Connection.connectionCount);
    }
}


class Connection {
    public static int connectionCount;
    private static Connection connection = new Connection();
    private final Semaphore semaphore = new Semaphore(10, true);

    private Connection() {
    }


    @SneakyThrows
    static Connection getInstance() {
        return connection;
    }

    @SneakyThrows
    void doWork() {
        semaphore.acquire();
        synchronized (this) {
            connectionCount++;
            System.out.println("Connection count after acquiring " + connectionCount);
        }
        Thread.sleep(1000);
        synchronized (this) {
            connectionCount--;
            System.out.println("Connection count after releasing " + connectionCount);
        }
        semaphore.release();
    }

}
