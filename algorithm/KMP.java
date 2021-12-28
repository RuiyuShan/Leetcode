package algorithm;

import java.util.Arrays;

/**
 * @author shanruiyu <shanruiyu@kuaishou.com>
 * Created on 2021-11-10
 */
public class KMP {

    public static void main(String[] args) {
        System.out.println(kmp("ababababca", "abababca"));
    }


    /**
     * KMP 匹配
     */
    public static int kmp(String str, String dest){
        //1.首先计算出 部分匹配表
        int[] next = kmpnext(dest);

        char[] strC = str.toCharArray();
        char[] destC = dest.toCharArray();

        System.out.println("next ="+Arrays.toString(next));
        //2.查找匹配位置
        for(int i = 0, j = 0; i < str.length(); i++){
            while(j > 0 && str.charAt(i) != dest.charAt(j)){
                j = next[j-1];
            }
            if(str.charAt(i) == dest.charAt(j)){
                j++;
            }
            if(j == dest.length()){
                return i-j+1;
            }
        }
        return -1;
    }

//    public static int kmp(String s, String pattern) {
//        int[] next = nextTable(pattern);
//        int i = 0;
//        while(i < s.length()) {
//            int j = i;
//            while (j < s.length()) {
//                if (s.charAt(j) != pattern.charAt(j - i)) {
//                    break;
//                }
//                j++;
//            }
//            if (j - i == pattern.length()) {
//                return i;
//            }
//            if (j == i) {
//                i += 1;
//            } else {
//                i += ((j - i - 1) - next[j - i - 1]) + 1;
//            }
//        }
//        return -1;
//    }


    private static int[] nextTable(String pattern) {
        int[] next = new int[pattern.length()];
        char[] c = pattern.toCharArray();
        next[0] = 0;
        int i = 1, j = 0;
        while (i < next.length) {
            while (j > 0 && c[i] != c[j]) {
                j = next[j - 1];
            }
            if (c[i] == c[j]) {
                j++;
            }
            next[i] = j;
            i++;
        }
        return next;
    }

    private static int[] getNextTable(String pattern) {
        int[] next = new int[pattern.length()];
        if (pattern.length() < 2) {
            return next;
        }
        next[0] = -1;
        next[1] = 0;
        int i = 2;
        while (i < next.length) {
            int prefixLength = next[i - 1];
            while (prefixLength >= 0 && pattern.charAt(prefixLength) != pattern.charAt(i - 1)) {
                prefixLength = next[prefixLength];
            }
            next[i] = prefixLength + 1;
            i++;
        }
        return next;
    }

    public static int[] kmpnext(String dest){
        int[] next = new int[dest.length()];
        char[] c = dest.toCharArray();
        next[0] = 0;

        for(int i = 1,j = 0; i < c.length; i++){
            while(j > 0 && c[j] != c[i]){
                j = next[j - 1];
            }
            if(c[i] == c[j]){
                j++;
            }
            next[i] = j;
        }
        return next;
    }

}
