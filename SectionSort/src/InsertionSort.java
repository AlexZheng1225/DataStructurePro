import java.util.Arrays;

/**
 * @Author Alex Zheng
 * @Date 2021/2/10 17:11
 * @Annotation 插入排序法
 */
public class InsertionSort {

    private InsertionSort() {
    }

    //算法复杂度O(n^2)
    //插入排序法优化版本
    //后续课程中使用此种实现作为选择插入的实现
    public static <E extends Comparable<E>> void sort(E[] arr) {
        for (int i = 0; i < arr.length ; i++) {
            //将arr[i]插入到合适的位置
            E temp = arr[i];
            int j; //用于和temp交换的值在arr中的索引
            for (j = i; j - 1 >= 0 && temp.compareTo(arr[j - 1]) < 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = temp;
        }
    }

    //作业：重新实现插入排序法
    //思路：arr[0...i)是无序的；arr[i...n)是有序的---也就是相反的实现
    public static <E extends Comparable<E>> void sort1(E[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            //将arr[i]插入到合适的位置
            E temp = arr[i];
            int j; //用于和temp交换的值在arr中的索引
            for (j = i; j < arr.length-1 && temp.compareTo(arr[j + 1]) > 0; j++) {
                arr[j + 1] = arr[j];
            }
            arr[j] = temp;
        }
    }


    public static void main(String[] args) {
        int[] dataSize = {10000, 100000};
        for (int n : dataSize) {
            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            Integer[] arr2 = Arrays.copyOf(arr,arr.length);
            //抽象出测试方法
//            SortingHelper.sortTest("InsertionSort", arr);
//            SortingHelper.sortTest("SelectionSort", arr2);

            System.out.println();

            //顺序数据测试数据时...
            System.out.println("Ordered Array...");

            arr = ArrayGenerator.generateOrderedArray(n);
            arr2 = Arrays.copyOf(arr,arr.length);

            SortingHelper.sortTest("InsertionSort", arr);
//            SortingHelper.sortTest("SelectionSort", arr2);

            System.out.println();
        }
    }
}
