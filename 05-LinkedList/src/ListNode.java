/**
 * @Author Alex Zheng
 * @Date 2021/2/17 20:36
 * @Annotation leetcode203问题提供的条件
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    ListNode(int[] arr){
        if (arr == null || arr.length == 0){
            throw new IllegalArgumentException("arr can not be empty");
        }

        this.val = arr[0];
        ListNode current = this;
        for (int i = 1;i < arr.length;i++){
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        ListNode current = this;
        while (current != null){
            sb.append(current.val + "->");
            current = current.next;
        }
        sb.append("NULL");
        return sb.toString();
    }
}
