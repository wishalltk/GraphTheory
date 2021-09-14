package com.binaryops;

import static com.binaryops.BinaryUtil.toBinary;

public class BitManipulation {
    public static void main(String[] args) {
        long num1 = 100L;
        long num2 = 103L;
        long diff = findDifferentBits(num1, num2);
        int count = countNumberOfSetBits(diff);
        System.out.println("num1 = "+toBinary(num1)+"\nnum2 = "+toBinary(num2)+"\ndiff = "+toBinary(diff)+"\ncount: "+count);


    }

    static long findDifferentBits(long num1, long num2) {
        return num1 ^ num2;
    }

    static int countNumberOfSetBits(long number) {
        int counter = 0;
        while (number>0){
            number = number & number-1;
            counter++;
        }
        return counter;
    }

    static void clearingBits(){
        long before = 100L;
        String beforeString = toBinary(before);
        double size = Math.floor(binarySize(before));
        for(int i=0;i<size;i++){
            System.out.println("bit @ "+i+" "+beforeString+"->"+toBinary(clearBit(before, i)));
        }
    }

    static long clearBit(long number, long position){
        long mask = (~(1L << position));
        return number & mask;
    }

    static void flippingBits(){
        long before = 100L;
        String beforeString = toBinary(before);
        System.out.println("setting each bit");
        double size = Math.floor(binarySize(before));
        for(int i=0;i<size;i++) {
            System.out.println("bit @ "+i+" before: "+beforeString+", after: "+toBinary(setBit(before, i)));
        }
    }

    static long setBit(long number, long position){
        long mask = (1L << position);
        return (number | mask);
    }

    static double binarySize(long number){
        return Math.log10(number)/Math.log10(2)+1;
    }
}
