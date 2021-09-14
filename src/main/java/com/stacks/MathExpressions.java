package com.stacks;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class MathExpressions {
    public static void main(String[] args) {
        String[] exp = new String[] {"2","2","+","3","*"};
        int result = evaluate(exp);
        System.out.println(result);
    }

    private static int evaluate(String[] exp) {
        Set<String> operators = new HashSet<>();
        operators.add("+");
        operators.add("-");
        operators.add("*");
        operators.add("/");

        Stack<String> stack = new Stack<>();
        for(String s: exp) {
            if(operators.contains(s)){
                int op1 = Integer.parseInt(stack.pop());
                int op2  = Integer.parseInt(stack.pop());
                int ans;
                switch (s) {
                    case "+":
                        ans = op1+op2;
                        break;
                    case "-":
                        ans = op1-op2;
                        break;
                    case "*":
                        ans = op1*op2;
                        break;
                    default:
                        ans = (op2 == 0)?0:(op1/op2);
                        break;
            }
            stack.push(String.valueOf(ans));
        } else {
                stack.push(s);
            }
    }
        return Integer.parseInt(stack.pop());
}
}
