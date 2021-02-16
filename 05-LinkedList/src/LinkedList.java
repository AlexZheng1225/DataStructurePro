/**
 * @Author Alex Zheng
 * @Date 2021/2/15 18:48
 * @Annotation
 */
public class LinkedList<E> {

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

    private Node dummyHead;
    private int size;

    public LinkedList(){
        dummyHead = new Node(null,null);
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
            Node prev = dummyHead;
        //只需要遍历index次就好
            for (int i = 0; i < index; i++) {
                prev = prev.next;
            }
            prev.next = new Node(e,prev.next);
            size++;
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
        Node current = dummyHead.next;
        //get不需要index-1，因为我们要找的就是index节点
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.e;
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
        Node current = dummyHead.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.e = e;
    }

    //查找链表中是否存在元素e
    public boolean contains(E e){
        Node current = dummyHead.next;
        while (current!=null){
            if (current.e.equals(e)){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer();
//        Node current = dummyHead.next;
//        while (current!=null){
//            sb.append(current + "->");
//            current = current.next;
//        }
        for (Node current = dummyHead.next;current != null;current = current.next){
            sb.append(current + "->");
        }
        sb.append("NULL");
        return sb.toString();
    }

}
