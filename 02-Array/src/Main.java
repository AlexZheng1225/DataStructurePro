/**
 * @Author Alex Zheng
 * @Date 2021/2/14 12:52
 * @Annotation
 */
public class Main {

    public static void main(String[] args) {
        Array<Integer> arr = new Array<>(20);
        for (int i=0;i<10;i++){
            arr.addLast(i);
        }
        System.out.println(arr);
        //Array{data=[0, 1, 2, 3, 4, 5, 6, 7, 8, 9], size=10, length=20}

        arr.add(1,100);
        System.out.println(arr);
        //Array{data=[0, 100, 1, 2, 3, 4, 5, 6, 7, 8, 9], size=11, length=20}

        arr.addFirst(-1);
        System.out.println(arr);
        //Array{data=[-1, 0, 100, 1, 2, 3, 4, 5, 6, 7, 8, 9], size=12, length=20}

        arr.remove(2);
        System.out.println(arr);
        //Array{data=[-1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9], size=11, length=20}

        arr.removeElement(4);
        System.out.println(arr);
        //Array{data=[-1, 0, 1, 2, 3, 5, 6, 7, 8, 9], size=10, length=20}

        arr.removeFirst();
        System.out.println(arr);
        //Array{data=[0, 1, 2, 3, 5, 6, 7, 8, 9], size=9, length=20}

    }

}
