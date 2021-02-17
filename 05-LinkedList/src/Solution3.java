/**
 * @Author Alex Zheng
 * @Date 2021/2/17 20:35
 * @Annotation
 */
public class Solution3 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null){
            return null;
        }

        //删除的结果赋值给res
        //res存储的是头节点后面跟的链表中所有值为val的节点删除后剩下的链表
        ListNode res = removeElements(head.next,val);

        //开始解决
        if (head.val == val){
            return res;
        }else{
            head.next = res;
            return head;
        }
    }

    public static void main(String[] args) {
        int[] nums = {6,5,6,3,9,6,4,7,8,5,2,3,6};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = new Solution3().removeElements(head,6);
        System.out.println(res);
    }
}
