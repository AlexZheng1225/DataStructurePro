/**
 * @Author Alex Zheng
 * @Date 2021/2/9 20:07
 * @Annotation 选择排序法 [要可比较]
 */
public class SelectionSort {

    private SelectionSort(){}

    //arr[0...i)是有序得；arr[i...n)是无序的
    //extend在泛型中表示要实现某个接口
    //类实现了Comparable<E>则代表其是可比较的
    public static <E extends Comparable<E>> void sort(E[] arr){
        //选择arr[i...n)中的最小值索引
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j=i;j<arr.length;j++){
                if (arr[minIndex].compareTo(arr[j])>0){
                    minIndex = j;
                }
            }
            swap(arr,i,minIndex);
        }
    }

    //自己写
 /*   public static <E extends Comparable<E>> void sort(E[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j=i;j<arr.length;j++){
                if (arr[i].compareTo(arr[j])>0){
                    swap(arr,i,j);
                }
            }
        }
    }*/

    //排序作业 从arr[0...i)是无序得；arr[i...n)是有序的 也就是相反的实现
//    public static <E extends Comparable<E>> void sort2(E[] arr){
//        for (int i = arr.length-1; i >= 0; i--) {
//            int maxIndex = i;
//            for (int j=i;j>=0;j--){
//                if (arr[maxIndex].compareTo(arr[j])<0){
//                    maxIndex = j;
//                }
//            }
//            swap(arr,i,maxIndex);
//        }
//    }

    private static <E> void swap(E[] arr,int i,int j){
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] dataSize = {10000};
        for (int n:dataSize){
            Integer[] arr = ArrayGenerator.generateRandomArray(n,n);
            //抽象出测试方法
            SortingHelper.sortTest("SelectionSort",arr);
//            SortingHelper.sortTest("sort2",arr);
        }
    }

}
