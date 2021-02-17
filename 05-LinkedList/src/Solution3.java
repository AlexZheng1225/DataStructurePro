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

        head.next = removeElements(head.next,val);

        //开始解决
        if (head.val == val){
            //跳过一个 == 删除本节点
            return head.next;
        }else{
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
