package algorithm.sort;

//思想参见URL: https://www.cnblogs.com/chengxiao/p/6103002.html

//直接插入排序基本思想：每一步将一个待排序的记录，插入到前面已经排好序的有序序列中去，直到插完所有元素为止。
public class InsertSort {

    //使用元素交换完成插入
    public static int[] insertionSort(int[] arr){

        for (int i = 1; i < arr.length; i++) {   //排序arr.length-1次即可
            int j = i;

            while(j > 0 && arr[j] < arr[j-1]){
                //交换
                SelectSort.swap(arr,j,j-1);
                j--;
            }
        }

        return arr;
    }

    //元素向后移动，完成插入。 这个才是名副其实的插入算法------记这个，更符合算法思想
    public static int[] insertionSort2(int[] arr){

        int j;
        int temp;

        for (int i = 1; i < arr.length; i++) {

            temp = arr[i];  //待插入的元素值
            j = i-1;
            while(j >= 0 && arr[j] > temp){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = temp;

        }//end for

        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {8,3,2,5,1,7,9};
        for (int temp : insertionSort2(arr)) {
            System.out.println(temp);
        }
    }


}
