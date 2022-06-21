package simple;

/**
 * @author TuoZhou
 * 9-回文数
 */
public class Palindrome {

    public static boolean palindrome(int x) {
        boolean result = true;

        // 1、字符串暴力循环
        // String string = String.valueOf(x);
        // char[] chars = string.toCharArray();
        // for (int i = 0; i < chars.length; i++) {
        //     if (chars[i] != chars[chars.length - i - 1]){
        //         result = false;
        //         break;
        //     }
        // }
        // return result;

        // 2、判断原始值 == 逆序值
        // if (x == 0) {
        //     result =  true;
        // } else if (x < 0 || x % 10 == 0){
        //     result =  false;
        // } else {
        //     int origin = x;
        //     int reversed = 0;
        //     while (x > 0) {
        //         reversed = reversed * 10 + x % 10;
        //         x /= 10;
        //     }
        //     result = (origin == reversed);
        // }
        // return result;

        // 3、
        if (x == 0) {
            result = true;
        } else if (x < 0 || x % 10 == 0) {
            result = false;
        } else {
            int reversed = 0;
            while (x > reversed) {
                reversed = reversed * 10 + x % 10;
                x /= 10;
            }
            result = (x == reversed || x == reversed / 10);
        }
        return result;
    }

    public static void main(String[] args) {
        int x = 121;
        System.out.println(palindrome(x));
    }

}
