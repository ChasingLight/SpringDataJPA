package algorithm.sort;

//思想参见URL: https://www.cnblogs.com/chengxiao/p/6103002.html

//"简单选择"排序基本思想：每一趟从待排序的数据元素中选择最小（或最大）的一个元素作为首元素，直到所有元素排完为止。

//最直接的一种排序算法，eg：7，8，2，3。排序先找到最小的，然后次小的即可。2，3，7，8
public class SelectSort {

    public static int[] selectSort(int[] arr){

        for (int i = 0; i < arr.length-1; i++) {  //排序n-1次即可

            int minIndex = i;  //每一趟循环比较时，min用于存放较小元素的数组下标，这样当前批次比较完毕最终存放的就是此趟内最小的元素的下标

            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex])
                    minIndex = j;
            }

            if (minIndex != i){  //如果min发生变化，则进行交换
                swap(arr, minIndex, i);
            }

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

    public static void main(String[] args) {
        int[] arr = {6,8,3,2,5,1,7,9,4};
        System.out.println(BubbleSort.showArray(selectSort(arr)));
    }


}
