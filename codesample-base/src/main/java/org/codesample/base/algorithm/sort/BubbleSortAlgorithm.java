package org.codesample.base.algorithm.sort;

public class BubbleSortAlgorithm {
    /**
     * 冒泡排序  相邻的数据表达大小  如果满足条件则交换位置
     *
     * @param arr 原始数组
     * @return 从小到大排序的数组
     */
    public int[] sort(int[] arr) {
        if (arr.length <= 1) return arr;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] < arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }
}
