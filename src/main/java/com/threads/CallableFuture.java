package com.threads;

import lombok.SneakyThrows;

import java.util.Random;
import java.util.concurrent.*;

public class CallableFuture {
    @SneakyThrows
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        Future<String> messageFuture = service.submit(new ABC());
        String message = messageFuture.get(1, TimeUnit.SECONDS);
        //service.shutdown();
        //service.awaitTermination(2, TimeUnit.SECONDS);
        System.out.println("Completed with message : "+message);
        service.shutdown();
    }
}

class ABC implements Callable<String > {

    @Override
    public String call() throws Exception {
        int duration = new Random().nextInt(1000);
        Thread.sleep(duration);
        String message =  "I slept for "+duration+" ms";
    //    System.out.println(message);
        return message;
    }
}