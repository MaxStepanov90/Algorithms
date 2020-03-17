package com.company;

public class LinearSearch {

    public static int searchLinear(int[] array, int elementToFind) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("searhing at index: " + i + ", value: " + array[i]);
            if (array[i] == elementToFind) {
                System.out.println("found at index: " + i + ", value: " + array[i]);
                return i;
            }
        }
        System.out.println("not found: " + elementToFind);
        return -1;
    }

}
