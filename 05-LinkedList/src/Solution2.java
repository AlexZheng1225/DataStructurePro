/**
 * @Author Alex Zheng
 * @Date 2021/2/17 20:35
 * @Annotation
 */
public class Solution2 {
    public ListNode removeElements(ListNode head, int val) {

        //随意给值，因为不会用到
        ListNode dummyHead = new ListNode(-1);
        //创建虚拟头节点
        dummyHead.next = head;

        ListNode prev = dummyHead;
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
        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] nums = {6,5,6,3,9,6,4,7,8,5,2,3,6};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = new Solution2().removeElements(head,6);
        System.out.println(res);
    }
}
