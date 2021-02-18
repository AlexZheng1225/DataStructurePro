/**
 * @Author Alex Zheng
 * @Date 2021/2/15 18:48
 * @Annotation 使用递归调用实现链表
 */
public class LinkedList2<E> {

    private class Node{
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this.e = e;
            this.next = null;
        }

        public Node() {
            this(null,null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node head;
    private int size;

    public LinkedList2(){
        head = new Node(null,null);
        size = 0;
    }

    //获取链表中元素个数
    public int getSize(){
        return size;
    }

    //返回链表是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    //在链表的index(0-based)位置添加新的元素e
    //在链表中这不是一个常用的操作 练习用(考题、面试题、练习题)
    public void add(int index,E e){
        if (index < 0 || index > size){ //可以取到size，即在链表的尾部添加元素
            throw new IllegalArgumentException("Add faile.Illegal index.");
        }
        head = add(head,index,e);
        size++;
    }

    private Node add(Node node, int index, E e) {
        if (index == 0){
            return new Node(e,node);
        }
        node.next = add(node,--index,e);
        return node;
    }

    //在链表头添加新的元素
    public void addFirst(E e){
        add(0,e);
    }

    //向链表末尾添加新元素e
    public void addLast(E e) {
        add(size, e);
    }

    //获得链表的index(0-based)位置的元素e
    //在链表中这不是一个常用的操作 练习用(考题、面试题、练习题)
    public E get(int index){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("Get faile.Illegal index.");
        }
        return get(head,index);
    }

    private E get(Node head,int index){
        if (index == 0){
            return head.e;
        }
        return get(head.next,--index);
    }

    //获取链表的第一个元素
    public E getFirst() {
        return get(0);
    }

    //获得链表最后一个元素
    public E getLast() {
        return get(size - 1);
    }

    //更新链表的index(0-based)位置的元素e
    //在链表中这不是一个常用的操作 练习用(考题、面试题、练习题)
    public void set(int index,E e){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("Set faile.Illegal index.");
        }
        head = set(head,index,e);
    }

    private Node set(Node node,int index,E e){
        if (index == 0){
            node.e = e;
        }
        Node current = set(node.next,--index,e);
        return current;
    }

    //查找链表中是否存在元素e
    public boolean contains(E e){
        return contains(head,e);
    }

    private boolean contains(Node node,E e){
        if (node == null){
            return false;
        }
        if (node.e.equals(e)){
            return true;
        }
        return contains(node.next,e);
    }

    //从链表中删除index(0-based)位置的元素，并返回删除的元素
    //在链表中这不是一个常用的操作 练习用(考题、面试题、练习题)
    public E remove(int index){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("Remove faile.Illegal index.");
        }
        return remove(head,index);
    }

    private E remove(Node node,int index){
        if (index == 1){
            Node delNode = node.next;
            node.next = delNode.next;
            delNode.next = null;
            return delNode.e;
        }
        return remove(node.next,--index);
    }

    //从链表中删除第一个元素
    public E removeFirst() {
        return remove(0);
    }

    //从链表中删除最后一个元素
    public E removeLast() {
        return remove(size - 1);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer();
//        Node current = dummyHead.next;
//        while (current!=null){
//            sb.append(current + "->");
//            current = current.next;
//        }
        for (Node current = head;current != null;current = current.next){
            sb.append(current + "->");
        }
        sb.append("NULL");
        return sb.toString();
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }
        System.out.println("------------------");

        linkedList.add(2,666);
        System.out.println(linkedList); //4->3->666->2->1->0->NULL

        linkedList.remove(2);
        System.out.println(linkedList); //4->3->2->1->0->NULL

        linkedList.removeFirst();
        System.out.println(linkedList); //3->2->1->0->NULL

        linkedList.removeLast();
        System.out.println(linkedList); //3->2->1->NULL

        System.out.println(linkedList.contains(2)); //true
    }

}
