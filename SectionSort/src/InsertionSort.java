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

    private static <E> void swap(E[] arr, int i, int j) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] dataSize = {10000, 100000};
        for (int n : dataSize) {
            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            //抽象出测试方法
            SortingHelper.sortTest("InsertionSort", arr);
        }
    }


}
