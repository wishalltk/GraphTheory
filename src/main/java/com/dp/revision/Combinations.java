package com.dp.revision;

public class Combinations {
    public static void main(String[] args) {
        String text = "abc";
        System.out.println("Permutations");
        permute(text, "");
    }



    private static void permute(String input, String answer) {

        if(input.length() == 0) {
            System.out.println(answer);
            return;
        }

        for(int i=0;i<input.length();i++) {
            String leftPart = input.substring(0,i);
            String rightPart = input.substring(i+1);
            String inp = leftPart+rightPart;
            String ans = String.valueOf(input.charAt(i));
            permute(inp,answer+ans);
        }
    }

/*
    private static List<List<String>> printCombinations(String text) {
        if(text.length() == 0 ) return new ArrayList<>();

        String firstChar = text.substring(0,1);
        String restChars = text.substring(1);

        List<List<String>> combosWithoutFirst = printCombinations(restChars);
        List<List<String>> combosWithFirst = new ArrayList<>();
        combosWithFirst.add(new ArrayList<>());// It does not work without this
        combosWithoutFirst.forEach( arr -> {
            List<String> list = new ArrayList<>(arr);
            list.add(firstChar);
            combosWithFirst.add(list);
        } );
        List<List<String>> answer = new ArrayList<>();
        answer.addAll(combosWithFirst);
        answer.addAll(combosWithoutFirst);
        return answer;
    }
*/

}
