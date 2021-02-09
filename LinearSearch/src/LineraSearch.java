import java.util.Arrays;
import java.util.List;

/**
 * @Author Alex Zheng
 * @Date 2021/2/7 22:08
 * @Annotation
 */
public class LineraSearch {

    private LineraSearch(){}

    public static <E> int search(E[] data,E target){
        for (int i=0;i<data.length;i++){
            if (data[i].equals(target)){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Integer[] data = ArrayGenerator.generateOrderedArray(100000);

        long startTime = System.nanoTime();
        for (int k=0;k<10000;k++) {
            LineraSearch.search(data, 100000);
        }
        long endTime = System.nanoTime();

        double time = (endTime-startTime)/1000000000.0;

        System.out.println(time+"S");

//        System.out.println(res);
//
//        int res2 = search(data,666);
//        System.out.println(res2);
//
//        Student[] students = {
//                new Student("Sam"),
//                new Student("Alex"),
//                new Student("Mike"),
//        };
//
//        Student alex = new Student("Alex");
//        int res3 = LineraSearch.search(students,alex);
//        System.out.println(res3);

    }

}
