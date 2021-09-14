package com.aditya.verma;

public class LongPalSubString {
    public static void main(String[] args) {
        String input = "abcbbaa";//"abbakakabccd";
        System.out.println(lpss(input));
    }
    private static int max=0;
    private static int lpss(String input) {
        return lpssBf(input);
        //return lpssRec(input, 0, input.length()-1, 0);
    }

    private static int lpssBf(String string) {
        int best=0;
        for(int i=0;i<string.length();i++) {
            for(int j=i+1;j<string.length();j++) {
                String sub = string.substring(i, j+1);
                if(isPal(sub))
                    best = Math.max(best, (j-i)+1);
            }
        }
        return best;
    }
    // n = number of letters, not index
    private static int lpssRec(String input, int front, int rear, int count) {
        int n=rear-front;
        if(front >= rear)
            return count+1;
        if(input.charAt(front) == input.charAt(rear)) {
            return lpssRec(input, front+1, rear-1, count+2);
        }
        max = Math.max(max, count);
        int way1 = lpssRec(input, front+1, rear, 0);
        int way2 = lpssRec(input, front, rear-1, 0);
        int wayMax = Math.max(way1, way2);
        max = Math.max(max, wayMax);
        return wayMax;
    }

    static boolean isPal(String input) {
        return input.equals(new StringBuilder(input).reverse().toString());
    }

    static String reverse(String input) {
        return new StringBuilder(input).reverse().toString();
    }
}
