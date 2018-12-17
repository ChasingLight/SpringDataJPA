package algorithm.sort;

//思想参见URL: https://www.cnblogs.com/chengxiao/p/6103002.html

//"冒泡"基本思想：相邻的元素进行两两比较，顺序相反则进行交换。这样：每一趟会将最小或最大的元素“浮”到顶端，最终达到完全有序

import java.util.Arrays;

public class BubbleSort {

    public static int[] bubbleSortOptimize(int[] arr){

        int bubbleRoundCount = 0;

        for (int i = arr.length-1; i > 0 ; i--) {

            boolean alreadyOrder = true;

            for (int j = 0; j < i; j++) {  //相邻两元素：arr[j]、arr[j+1]
                if (arr[j] > arr[j+1]){
                    swap(arr, j, j+1);
                    alreadyOrder = false;
                }
            }

            System.out.println("第" + (++bubbleRoundCount) + "次冒泡，" + showArray(arr));

            if (alreadyOrder) break;

        }//end for

        return arr;
    }

    public static int[] bubbleSort(int[] arr){

        int bubbleRoundCount = 0;

        for (int i = arr.length-1; i > 0 ; i--) {

            for (int j = 0; j < i; j++) {  //相邻两元素：arr[j]、arr[j+1]
                if (arr[j] > arr[j+1]){
                    swap(arr, j, j+1);
                }
            }

            System.out.println("第" + (++bubbleRoundCount) + "次冒泡，" + showArray(arr));

        }//end for

        return arr;
    }

    /**
     * 交换数组元素
     * @param arr
     * @param a  下标
     * @param b  下标
     * @return
     */
    public static void swap(int[] arr, int a, int b){
        arr[a] = arr[a] + arr[b];
        arr[b] = arr[a] - arr[b];
        arr[a] = arr[a] - arr[b];

    }

    /**
     * 展示数组元素
     * @param arr
     * @return
     */
    public static String showArray(int[] arr){
        StringBuffer sb = new StringBuffer();
        for (int temp : arr){
            sb.append(temp + " ");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        int[] arr = {8,3,2,5,1,7,9,4};
        System.out.println(showArray(bubbleSort(arr)));

        int[] arr2 = {8,3,2,5,1,7,9,4};
        System.out.println("------------优化后--------------");
        System.out.println(showArray(bubbleSortOptimize(arr2)));
    }

}
