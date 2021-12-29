package algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shanruiyu <shanruiyu@kuaishou.com>
 * Created on 2021-12-28
 */
public class MinCoverSubStr {
    public static void main(String[] args) {
        String s = "a", t = "a";
        String res = minWindow(s, t);
        System.out.println(res);
    }

    public static String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        String res = s + "#";
        if (t.length() > s.length()) {
            return "";
        }
        int needCnt = t.length();
        for (int i = 0; i < t.length(); i++) {
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
        }
        int left = 0, right = 0;
        while (left < s.length()) {
            while (needCnt > 0 && right < s.length()) {
                char ch = s.charAt(right);
                if (need.containsKey(ch)) {
                    if (need.get(ch) > 0) {
                        needCnt--;
                    }
                    need.put(ch, need.get(ch) - 1);
                }
                right++;
            }
            while (needCnt == 0 && left <= right) {
                if (right - left < res.length()) {
                    res = s.substring(left, right);
                }
                char leftCh = s.charAt(left);
                if (need.containsKey(leftCh)) {
                    if (need.get(leftCh) + 1 > 0) {
                        needCnt++;
                    }
                    need.put(leftCh, need.get(leftCh) + 1);
                }
                left++;
            }
            if (right == s.length()) {
                left++;
            }
        }
        return res.length() <= s.length() ? res : "";
    }
}
