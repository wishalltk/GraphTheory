package com.threads;

import lombok.SneakyThrows;
import org.checkerframework.checker.units.qual.C;

import java.util.ArrayList;
import java.util.List;

public class CustomLock {

    final Object lock1 = new Object();
    final Object lock2 = new Object();

    List<Integer> listOne = new ArrayList<>();
    List<Integer> listTwo = new ArrayList<>();

    @SneakyThrows
   synchronized void stageOne() {
        synchronized (this) {
            Thread.sleep(1);
          listOne.add(1);
        }
    }

    @SneakyThrows
   synchronized void stageTwo() {
        synchronized (this) {
            Thread.sleep(1);
            listTwo.add(1);
        }
    }

    public static void main(String[] args) {
        CustomLock obj = new CustomLock();
        long start = System.currentTimeMillis();
        for(int i=0;i<1000;i++) {
            obj.stageOne();
            obj.stageTwo();
        }
        long end = System.currentTimeMillis();
        System.out.println(
                "List 1 size = "+ obj.listOne.size()+"\n"+
                "List 2 size = "+ obj.listTwo.size()+"\n"+
                "Total time taken = "+(end-start)
        );
    }
}
