/**
 * @Author Alex Zheng
 * @Date 2021/2/16 9:28
 * @Annotation
 */
public class Main {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }

        linkedList.add(2,666);
        System.out.println(linkedList); //4->3->666->2->1->0->NULL

        linkedList.remove(2);
        System.out.println(linkedList); //4->3->2->1->0->NULL

        linkedList.removeFirst();
        System.out.println(linkedList); //3->2->1->0->NULL

        linkedList.removeLast();
        System.out.println(linkedList); //3->2->1->NULL
    }

}
