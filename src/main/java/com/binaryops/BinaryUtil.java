package com.binaryops;

public class BinaryUtil {
    public static String toBinary(long decimal){
        long[] binary = new long[40];
        int index = 0;
        while(decimal > 0){
            binary[index++] = decimal%2;
            decimal = decimal/2;
        }
        StringBuilder ans= new StringBuilder();
        for(int i = index-1;i >= 0;i--){
            ans.append(binary[i]);
        }
        return ans.toString();
    }
}
