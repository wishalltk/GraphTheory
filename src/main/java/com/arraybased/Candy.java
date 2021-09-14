package com.arraybased;

import java.util.Arrays;

public class Candy {
    public static void main(String[] args) {
        int[] a = {1,0,2};
        int total = onePass(a);
        int t2 = nPass(a);
        System.out.println("One Pass="+total+"\nN Pass="+t2);
    }

    static int nPass(int[] a) {
        int[] c = new int[a.length];

        c[0] = 1;
        for (int i = 1; i < a.length; i++) {
            if (a[i] > a[i - 1])
                c[i] = c[i - 1] + 1;
            else {
                c[i] = 1;
            }
        }
        System.out.println(Arrays.toString(c));
        int min=c[a.length-1];
        for (int i = a.length - 2; i >= 0; i--) {
            if (a[i] > a[i + 1])
                c[i] = Math.max(c[i], c[i + 1] + 1);
            min+=c[i];
        }
        System.out.println(Arrays.toString(c));
        System.out.println(min);
        return min;
    }

    static int onePass(int[] a) {
        int total = 1;
        int last = 0;
        for(int i=1;i<a.length;i++) {
            if(a[i] <= a[i-1]) {
                total+=1;
                last++;
            } else {
                total = total+last+a[i-1]+1;
                last=0;
            }
        }
        return total;
    }
}
