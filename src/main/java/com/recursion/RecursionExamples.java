package com.recursion;

import java.util.HashMap;
import java.util.Map;

public class RecursionExamples {
    int n1=0;
    int n2=1;
    static Map<Long, Long> cache;
    public static void main(String[] args) {
        RecursionExamples obj = new RecursionExamples();
        int N = 3;
        int sum = obj.factorial(N);
        System.out.println(sum);

        int num = 50;
        System.out.println("printing fib series for "+num+" numbers");
        cache = new HashMap<>();
        cache.put(0L, 0L);
        cache.put(1L, 1L);

        long start = System.currentTimeMillis();
        obj.fibNormal(num);
//        for(int i=0;i<num;i++)
//            System.out.println(i+" -> "+obj.fibRecursive(i));
        long end = System.currentTimeMillis();
        System.out.println("\ntotal runtime "+(end-start));
    }

    int factorial(int n){
        if(n == 0)
            return 0;
        return n + factorial(n-1);
    }

    long fibRecursive(long n){
        if(cache.containsKey(n))
            return cache.get(n);
        long answer = fibRecursive(n-1)+fibRecursive(n-2);
        cache.put(n, answer);
        return answer;
    }

    void fibNormal(int n){
        long n1=0;
        long n2=1;
        long n3;
        System.out.print(n1+" "+n2);
        for(int i=2;i<n;i++){
            n3=n1+n2;
            System.out.print(" "+n3);
            n1=n2;
            n2=n3;
        }
    }


}
