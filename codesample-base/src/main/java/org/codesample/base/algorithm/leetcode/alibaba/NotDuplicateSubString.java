package org.codesample.base.algorithm.leetcode.alibaba;

import java.util.*;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class NotDuplicateSubString {

    /**
     * 暴力求解
     */
    public int getNotDuplicateSubString(String string) {
        int n = string.length();
        String[] subStringArr = new String[n];

        for (int i = 0; i < n; i++) {
            char[] chars = new char[n];
            chars[0] = string.charAt(i);
            for (int j = i + 1, charIndex = 1; j < n; j++) {

                char charAt = string.charAt(j);
                boolean charExist = false;
                for (int k = 0; k < j; k++) {
                    if (chars[k] == charAt) {
                        charExist = true;
                        break;
                    }
                }

                if (charExist) {
                    char[] source = new char[charIndex];
                    System.arraycopy(chars, 0, source, 0, charIndex);
                    subStringArr[i] = new String(source);
                    break;
                } else {
                    chars[charIndex] = charAt;
                    ++charIndex;
                }
            }
        }

        int[] arr = new int[subStringArr.length];
        for (int i = 0; i < subStringArr.length; i++)
            arr[i] = subStringArr[i] == null ? 0 : subStringArr[i].length();
        Arrays.sort(arr);
        return arr[arr.length - 1];
    }

    public static void main(String[] args) {
        System.err.println(new NotDuplicateSubString().getNotDuplicateSubString("abcabcbb"));
        System.err.println(new NotDuplicateSubString().lengthOfLongestSubstring("abcabcbb"));
    }

    /**
     * Leetcode标准答案
     * <p>
     * 滑动窗口求解方法
     */
    public int lengthOfLongestSubstring(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }

        return ans;
    }

}
