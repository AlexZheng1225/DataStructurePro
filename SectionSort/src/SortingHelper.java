/**
 * @Author Alex Zheng
 * @Date 2021/2/9 21:23
 * @Annotation
 */
public class SortingHelper {

    private SortingHelper(){}

    //泛型数组--判断数组是否有序--类型必须可比较
    public static <E extends Comparable<E>> boolean isSorted(E[] arr){
        for (int i=1;i<arr.length;i++){
            if(arr[i-1].compareTo(arr[i])>0){
                return false;
            }
        }
        return true;
    }

    public static <E extends Comparable<E>> void sortTest(String sortname,E[] arr){
        long startTime = System.nanoTime();

        if (sortname.equals("SelectionSort")){
            SelectionSort.sort(arr);
        }else if (sortname.equals("InsertionSort")){
            InsertionSort.sort(arr);
        }
//        else if (sortname.equals("sort2")){
//            SelectionSort.sort2(arr);
//        }

        long endTime = System.nanoTime();

        double time = (endTime-startTime)/1000000000.0;

        //需要验证多数情况下排序后数组的情况(是否排序)
        if (!SortingHelper.isSorted(arr)){
            throw new RuntimeException(sortname+" failed");
        }
        System.out.println(String.format("%s,n=%d: %fs",sortname,arr.length,time));
    }

}
