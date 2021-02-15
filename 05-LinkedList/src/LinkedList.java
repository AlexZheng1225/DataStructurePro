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
            final StringBuffer sb = new StringBuffer("Node{");
            sb.append("e=").append(e);
            sb.append(", next=").append(next);
            sb.append('}');
            return sb.toString();
        }
    }

}
