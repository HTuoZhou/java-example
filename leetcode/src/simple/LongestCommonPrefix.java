package simple;

import java.util.Objects;

/**
 * @author TuoZhou
 * @date 2022/3/1
 * 14-最长公共前缀
 */
public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        // 1、
        // String result = "";
        // if (strs.length == 1) {
        //    result = strs[0];
        // } else {
        //     String s = strs[0];
        //     for (int i = 1; i < strs.length; i++) {
        //         while (!strs[i].startsWith(s)) {
        //             s = s.substring(0,s.length() - 1);
        //         }
        //     }
        //     result = s;
        // }
        // return result;

        // 2、横向扫描
        // if (Objects.isNull(strs) || strs.length == 0) {
        //     return "";
        // } else {
        //     String prefix = strs[0];
        //     for (int i = 1; i < strs.length; i++) {
        //         prefix = longestCommonPrefix(prefix,strs[i]);
        //         if (prefix.length() == 0){
        //             break;
        //         }
        //     }
        //     return prefix;
        // }

        // 3、纵向扫描
        // if (Objects.isNull(strs) || strs.length == 0) {
        //     return "";
        // } else {
        //     for (int i = 0; i < strs[0].length(); i++) {
        //         char ch = strs[0].charAt(i);
        //         for (int j = 1; j < strs.length; j++) {
        //             if (i == strs[j].length() || ch != strs[j].charAt(i)) {
        //                 return strs[0].substring(0,i);
        //             }
        //         }
        //     }
        //     return strs[0];
        // }

        // 4、分治
        // if (Objects.isNull(strs) || strs.length == 0) {
        //     return "";
        // } else {
        //     return longestCommonPrefix(strs,0,strs.length - 1);
        // }

        // 5、二分查找
        if (Objects.isNull(strs) || strs.length == 0) {
            return "";
        } else {
            int length = Integer.MAX_VALUE;
            for (String str : strs) {
                length = Math.min(length,str.length());
            }

            int low = 0;
            int high = length;
            while (low < high) {
                int middle = (high - low + 1) / 2 + low;
                if (isCommonPrefix(strs,middle)) {
                    low = middle;
                } else {
                    high = middle - 1;
                }
            }

            return strs[0].substring(0,low);
        }

    }

    public static String longestCommonPrefix(String[] strs,int start,int end) {
        if (start == end) {
            return strs[start];
        } else {
            int middle = (end - start) / 2 + start;
            String left = longestCommonPrefix(strs,start,middle);
            String right = longestCommonPrefix(strs,middle + 1,end);
            return longestCommonPrefix(left,right);
        }
    }

    public static String longestCommonPrefix(String str1,String str2) {
        int length = Math.min(str1.length(),str2.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)) {
            index ++;
        }
        return str1.substring(0,index);
    }

    public static boolean isCommonPrefix(String[] strs,int length) {
        String s = strs[0].substring(0, length);
        for (int i = 1; i < strs.length; i++) {
            for (int j = 0; j < length; j++) {
                if (s.charAt(j) != strs[i].charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"ab","a"};
        System.out.println(longestCommonPrefix(strs));
    }

}
