package algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author shanruiyu <shanruiyu@kuaishou.com>
 * Created on 2021-12-16
 */
public class Playground {
    public static void main(String[] args) {
        int []arr = {7,6,7,11,5,12,3,0,1};
        System.out.println("排序前："+ Arrays.toString(arr));
        heapSort(arr);
        System.out.println("排序前："+Arrays.toString(arr));
        
    }

    private static void heapSort(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }

        for (int j = arr.length - 1; j > 0; j--) {
            swap(arr, 0, j);
            adjustHeap(arr, 0, j);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void adjustHeap(int[] arr, int i, int length) {
        for (int k = 2 * i + 1; k < length; k = 2 * k + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k = k + 1;
            }
            if (arr[k] > arr[i]) {
                swap(arr, i, k);
                i = k;
            } else {
                break;
            }
        }
    }

}
