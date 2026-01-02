package org.example;

public class maxArray {
    public int maxValue(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Invalid Array");
        }
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        maxArray maxArray = new maxArray();
        System.out.println(maxArray.maxValue(new int[]{5, 6, 4, 3}));
    }
}
