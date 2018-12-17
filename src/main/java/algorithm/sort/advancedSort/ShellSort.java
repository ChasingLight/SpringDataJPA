package algorithm.sort.advancedSort;

import algorithm.sort.BubbleSort;

//希尔排序：缩小增量排序，直到增量为1，就变为了简单的"直接插入排序"算法。
public class ShellSort {

    public static int[] shellSort(int[] arr) {
        int gap = arr.length / 2;  //初始增量
        int temp;
        int j;

        while(gap >= 1){

            for (int i = gap; i < arr.length; i++) {

                temp = arr[i];  //待插入的元素值
                j = i - gap;    //已排序的最末位的索引下标

                while(j >= 0 && arr[j] > temp){
                    arr[j + gap] = arr[j];
                    j = j - gap;
                }
                arr[j + gap] = temp;
            }

            gap = gap / 2;  //缩小增量

        }//end while

        return arr;

    }

    public static int[] shellSort2(int[] arr) {

        int j;

        for (int gap = arr.length / 2; gap >= 1; gap = gap / 2){

            for (int i = gap; i < arr.length; i++) {

                j = i;
                while(j-gap >= 0 && arr[j - gap] > arr[j]){   //通过交换元素值，来实现插入
                    BubbleSort.swap(arr, j - gap, j);
                    j = j - gap;
                }
            }

        }//end while

        return arr;

    }

    public static void main(String[] args) {
        int[] arr = {6,8,3,2,5,1,7,9,4};
        System.out.println(BubbleSort.showArray(shellSort2(arr)));
    }
}
