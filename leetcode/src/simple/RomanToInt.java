package simple;

import java.util.HashMap;
import java.util.Map;

/**
 * @author TuoZhou
 * @date 2022/2/25
 * 13-罗马数字转整数
 */
public class RomanToInt {

    public static int romanToInt(String s) {
        int result = 0;

        Map<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        // 1、
        // char[] chars = s.toCharArray();
        // if (chars.length == 1) {
        //     result = map.get(chars[0]);
        // } else {
        //     boolean flag = false;
        //     for (int i = 0; i < chars.length - 1; i++) {
        //         Integer pre = map.get(chars[i]);
        //         Integer next = map.get(chars[i + 1]);
        //         if (pre >= next) {
        //             result += pre;
        //             if (i == chars.length - 2) {
        //                 flag = true;
        //             }
        //         } else {
        //             result += (next - pre);
        //             if (++i == chars.length - 2) {
        //                 flag = true;
        //             }
        //         }
        //     }
        //     if (flag) {
        //         result += map.get(chars[chars.length - 1]);
        //     }
        // }
        // return result;

        // 2、
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int value = map.get(chars[i]);
            if (i < chars.length -1 && value < map.get(chars[i + 1])) {
                result -= value;
            } else {
                result += value;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("IV"));
    }

}
