package practice;

import java.util.Stack;

public class StringBackspace {
    public static void main(String[] args) {
        System.out.println(checkStrings("#a#c","a##c"));
    }

    private static boolean checkStrings(String S, String T) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();

        for (int i=0; i<S.length(); i++) {
            char c = S.charAt(i);
            if(c != '#')
                stack1.push(c);
            else if(!stack1.isEmpty()) stack1.pop();
        }
        for (int i=0; i<T.length(); i++) {
            char c = T.charAt(i);
            if(c != '#')
                stack2.push(c);
            else if(!stack2.isEmpty()) stack2.pop();
        }
        stack1.forEach(System.out::println);
        stack2.forEach(System.out::println);
        return stack1.equals(stack2);
    }
}
