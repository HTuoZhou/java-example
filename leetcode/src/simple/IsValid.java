package simple;

import java.util.*;

/**
 * @author TuoZhou
 * @date 2022/3/2
 * 20-有效的括号
 */
public class IsValid {

    public static boolean isValid(String s) {
        // 1、
        // if (s == null || s.length() == 0) {
        //     return true;
        // } else {
        //     Map<Character,Character> map = new HashMap<>();
        //     map.put('(',')');
        //     map.put('[',']');
        //     map.put('{','}');
        //     Stack<Character> stack = new Stack<>();
        //     char[] chars = s.toCharArray();
        //     for (char c : chars) {
        //         if (c == '(' || c == '[' || c == '{') {
        //             stack.push(c);
        //         } else if (!stack.isEmpty() && c == map.get(stack.peek())) {
        //             stack.pop();
        //         } else {
        //             return false;
        //         }
        //     }
        //     return stack.isEmpty();
        // }

        // 2、
        if (s == null || s.length() == 0) {
            return true;
        } else {
            Stack<Character> stack = new Stack<>();
            char[] chars = s.toCharArray();
            for (char c : chars) {
                if (c == '(') {
                    stack.push(')');
                } else if (c == '[') {
                    stack.push(']');
                } else if (c == '{') {
                    stack.push('}');
                } else if (stack.isEmpty() || c != stack.pop()) {
                    return false;
                }
            }
            return stack.isEmpty();
        }
    }

    public static void main(String[] args) {
        System.out.println(isValid("]"));
    }

}
