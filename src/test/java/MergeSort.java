public class MergeSort {

    public static void mergeSort(int[] arr,int len) {
        if(arr == null || len < 2) {
            return;
        }
        sortProcess(arr, 0, len-1);
    }

    public static void sortProcess(int[] arr,int L,int R) {
        if(L == R) {
            return;
        }
        int mid = (L+R)/2;
        sortProcess(arr, L, mid);
        sortProcess(arr, mid+1, R);
        merge(arr, L, R, mid);
    }

    public static void merge(int[] arr,int L,int R,int mid) {
        int[] help = new int[R-L+1];
        int i = 0;
        int p1 = L;
        int p2 = mid+1;
        while(p1 <= mid && p2 <= R) {
            help[i++] = arr[p1] > arr[p2] ? arr[p2++] : arr[p1++];
        }

        if (p1 > mid){
            while(p2 <= R){
                help[i++] = arr[p2++];
            }
        }

        /*while(p1 > mid) {
            help[i++] = arr[p2++];
        }*/

        if (p2 > R){
            while(p1 <= mid){
                help[i++] = arr[p1++];
            }
        }

        /*while(p2 > R) {
            help[i++] = arr[p1++];
        }*/


        for(int j = 0; j < R-L+1; j++) {
            arr[L+j] = help[j];
        }
        /*for(int j=0; j<arr.length; j++) {
            arr[L+j] = help[j];
        }*/
    }



    public static void main(String[] args) {
        int[] arr = { 8, 2, 6, 9, 5, 3, 4, 1, 10};
        mergeSort(arr,arr.length);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}