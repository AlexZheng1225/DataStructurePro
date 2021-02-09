/**
 * @Author Alex Zheng
 * @Date 2021/2/9 20:07
 * @Annotation 选择排序法 [要可比较]
 */
public class SectionSort {

    private SectionSort(){}

    //arr[0...i)是有序得；arr[i...n)是无序的
    //extend在泛型中表示要实现某个接口
    //类实现了Comparable<E>则代表其是可比较的
    public static <E extends Comparable<E>> void sort(E[] arr){
        //选择arr[i...n)中的最小值索引
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j=i;j<arr.length;j++){
                if (arr[minIndex].compareTo(arr[j])>0){
                    swap(arr,minIndex,j);
                }
            }
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

    private static <E> void swap(E[] arr,int i,int j){
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Integer[] arr = {65,1,98,45,96,3,2,7,85,96,44};
        SectionSort.sort(arr);
        for (int e:arr){
            System.out.print(e+" ");
        }
        System.out.println();

        Student[] students = {
                new Student("Alex",91),
                new Student("Sam",100),
                new Student("Mike",45),
                new Student("John",57)
        };

        SectionSort.sort(students);
        for (Student student:students){
            System.out.print(student+" ");
        }
        System.out.println();

    }

}
