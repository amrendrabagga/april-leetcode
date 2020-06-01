package practice;

import java.util.Stack;

public class StringValidator {
    public static void main(String[] args) {
        System.out.println(checkValidString("()"));
    }
    public static boolean checkValidString(String s) {
        if (s.length()==0 || (!s.contains("(") && !s.contains(")")))
            return true;
        char c[] = s.toCharArray();
        Stack<Integer> paranthesis = new Stack<>();
        Stack<Integer> symbol = new Stack<>();
        for (int i=0;i<s.length();i++) {
            // check is character is ( or )
            if (c[i] != '*'){
                if (paranthesis.empty() && c[i]==')') {
                    if (!symbol.empty()){
                        symbol.pop();
                        continue;
                    }
                    return false;
                }

                if (c[i]==')'){
                    if (!paranthesis.empty()) {
                        paranthesis.pop();
                        continue;
                    }
                    return false;
                }
                else {
                    paranthesis.push(i);
                }
            }
            else {
                symbol.push(i);
            }
        }

        while (!paranthesis.isEmpty() && !symbol.isEmpty()) {
            if (paranthesis.pop()  >  symbol.pop())
                return false;
        }
        if (paranthesis.size() >0 && symbol.isEmpty())
            return false;
        return true;
    }
}
