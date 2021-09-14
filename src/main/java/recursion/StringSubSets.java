package recursion;

public class StringSubSets {
    public static void main(String[] args) {
        printOneToN(7);
    }

   static void printOneToN(int n) {
        if(n == 0)
            return;
       printOneToN(n-1);
       System.out.println(n);
    }

    private static void printSubSet(String input, String output, int idx) {

    }
}
