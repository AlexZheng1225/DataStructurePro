/**
 * @Author Alex Zheng
 * @Date 2021/2/9 20:07
 * @Annotation
 */
public class SectionSort {

    private SectionSort(){}

    //arr[0...i)是有序得；arr[i...n)是无序的
    public static void sort(int[] arr){
        //选择arr[i...n)中的最小值索引
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j=i;j<arr.length;j++){
                if (arr[minIndex]>arr[j]){
                    swap(arr,minIndex,j);
                }
            }
        }
    }

    //自己写
    /*public static void sort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j=i;j<arr.length;j++){
                if (arr[i]>arr[j]){
                    swap(arr,i,j);
                }
            }
        }
    }*/

    private static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {65,1,98,45,96,3,2,7,85,96,44};
        sort(arr);
        for (int e:arr){
            System.out.print(e+" ");
        }
        System.out.println();
    }

}
