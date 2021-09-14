package com.binaryops;

public class Masking {
    public static void main(String[] args) {
        long n =  101101L;
        int size = (int) Math.log10(n)+1;
        bitFinder(n, size);

    }
    static void bitFinder(long number, int size) {
        for(int i=0;i<size;i++){
            long mask = (1L << i);
            long leftMask = (number & mask);
            long result = (leftMask >> i);
            System.out.println("bit @ "+i+" is "+result);
        }
    }
    static void printKthBit(long n, long k)
    {
        long leftMask = (1L << (k - 1));
        long postLeftMask = (n & leftMask);
        long result = ( postLeftMask >> (k - 1));
        System.out.println( result );
    }



    static int computeLength(long number){
        return (int) (Math.log10(number)+1);
    }



    static String oddEven(long number){
        long result = number & 1L;
        return (result == 0L)?"even":"odd";
    }

    static String oddEven2(long number){
        return (number%2L == 0)?"even":"odd";
    }
}
