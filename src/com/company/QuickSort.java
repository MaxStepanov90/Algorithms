package com.company;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = new int[]{64, 42, 73, 41, 32, 53, 16, 24, 57, 42, 74, 55, 36};
        System.out.println(arrayToString(array));
//        запускаем сортировку массива от первого и до последнего элемента массива.
        quickSort(array, 0, array.length - 1);
    }

    //принимает параметры: массив, границы сортировки(from, to)
    private static void quickSort(int[] arr, int from, int to) {
// проверяются индексы элементов и массивы делятся на подмассивы,
// если иначе то в подмассиве всего один элемент и сортировать его не надо.
        if (from < to) {
//  возвращает индекс элемента по которому происходит деление.
            int divideIndex = partition(arr, from, to);
//  разделение массива на 2 подмассива
            printSortStep(arr, from, to, divideIndex);
//  рекурсивно передается исходный массив,
//  но с границей  от начала массива до элемента по которому происходило деление не включая его.
            quickSort(arr, from, divideIndex - 1);
// с границей от элемента по которому происходило деление до конца массива.
            quickSort(arr, divideIndex, to);
        }
    }

    //выбирается опорный элемент,все элементы
// которые меньше него в правой части -> перемещаются в левую часть,
//которые больше него в левой части -> перемещаются в правую часть массива.
    private static int partition(int[] arr, int from, int to) {
//        начало массива
        int rightIndex = to;
//        конец массива
        int leftIndex = from;
// выбор опорного элемента, в данном случае начального
        int pivot = arr[from+(to-from)/2];
        while (leftIndex <= rightIndex) {
            //  1)начинаем движение от начала массива к концу,
//  до тех пор пока не найдем в левой части массива элемент который больше опорного
            while (arr[leftIndex] < pivot) {
                leftIndex++;
            }
            //  2)начинаем движение от конца массива к началу,
//  до тех пор пока не найдем в правой части массива элемент который меньше опорного
            while (arr[rightIndex] > pivot) {
                rightIndex--;
            }
            if (leftIndex <= rightIndex) {
                //  после того как найдены 2 элемента по пунктам 1 и 2, то они меняются местами.
                swap(arr, rightIndex, leftIndex);
                leftIndex++;
                rightIndex--;
            }
        }
        return leftIndex;
    }
//    обмен 2ух элементов массива местами
    private static void swap(int[]array, int index1, int index2){
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
    private static void printSortStep(int[] arr, int from, int to, int partitionIndex) {
        System.out.print(arrayToString(arr));
        System.out.print("\npartition at index: " + partitionIndex);
        System.out.print(", left: " + arrayToString(Arrays.copyOfRange(arr, from, partitionIndex)));
        System.out.println(", right: " + arrayToString(Arrays.copyOfRange(arr, partitionIndex, to + 1)) + "\n");
    }
    private static String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < array.length; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(array[i]);
        }
        sb.append("]");
        return sb.toString();
    }
}
