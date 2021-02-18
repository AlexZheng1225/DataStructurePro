/**
 * @Author Alex Zheng
 * @Date 2021/2/18 11:21
 * @Annotation leetcode 206号问题 反转链表
 */
public class LC206 {

    //非递归实现
//    public ListNode reverseList(ListNode head) {
//        //需要三个节点 包括一个前置节点
//        ListNode prev = null;
//        ListNode current = head;
//        while (current != null){
//            ListNode next = current.next;
//            //开始调整数据 为下一轮做准备
//            current.next = prev;
//            prev = current;
//            current = next;
//        }
//        //current为空时，则prev就是最后一个元素 即链表头head
//        return prev;
//    }

    //递归实现
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }

        ListNode rev = reverseList(head.next);
        //head.next --> rev 因为rev.next == null 这一步操作使得rev.next为head，成功接上(反转)
        head.next.next = head;
        head.next = null;
        return rev;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = new LC206().reverseList(head);
        System.out.println(res);
    }

}
