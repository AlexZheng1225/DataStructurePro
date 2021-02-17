import java.util.List;

/**
 * @Author Alex Zheng
 * @Date 2021/2/17 20:35
 * @Annotation
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        while(head != null && head.val == val){
            ListNode delNode = head;
            head = head.next;
            delNode = null;
        }

        if (head == null){
            return head;
        }

        ListNode prev = head;
        while(prev.next!=null){
            if (prev.next.val == val){
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode = null;
                //在这一步不要执行prev = prev.next; 删除元素后prev.next节点已经改变，需要再次进行比较
            }else{
                prev = prev.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        int[] nums = {6,5,6,3,9,6,4,7,8,5,2,3,6};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = new Solution().removeElements(head,6);
        System.out.println(res);
    }

}
