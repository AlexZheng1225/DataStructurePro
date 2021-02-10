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
    public static <E extends Comparable<E>> void sort(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            //将arr[i]插入到合适的位置
            for (int j = i; j-1 >= 0; j--) {
                if (arr[j].compareTo(arr[j - 1]) < 0) {
                    swap(arr, j, j - 1);
                } else {
                    break;
                }
            }

//            for (int j = i; j - 1 >= 0 && arr[j].compareTo(arr[j - 1]) < 0; j--) {
//                swap(arr, j, j - 1);
//            }
        }
    }

    //插入排序法优化版本
    //后续课程中使用此种实现作为选择插入的实现
    public static <E extends Comparable<E>> void sort2(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            //将arr[i]插入到合适的位置
            E temp = arr[i];
            int j; //用于和temp交换的值在arr中的索引
            for (j = i; j - 1 >= 0; j--) {
                if (arr[j].compareTo(arr[j - 1]) < 0) {
                    //向后移动一位，直接覆盖原有元素。
                    arr[j] = arr[j - 1];
                }
            }
            arr[j] = temp;
        }
    }

    private static <E> void swap(E[] arr, int i, int j) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] dataSize = {10000, 100000};
        for (int n : dataSize) {
            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            Integer[] arr2 = Arrays.copyOf(arr,arr.length);
            //抽象出测试方法
            SortingHelper.sortTest("InsertionSort", arr);
            SortingHelper.sortTest("InsertionSort2", arr2);
        }
    }


}
