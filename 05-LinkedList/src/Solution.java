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
}
