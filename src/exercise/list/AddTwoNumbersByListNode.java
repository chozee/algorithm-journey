package exercise.list;

// 给你两个 非空 的链表，表示两个非负的整数
// 它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字
// 请你将两个数相加，并以相同形式返回一个表示和的链表。
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头
// 测试链接：https://leetcode.cn/problems/add-two-numbers/
public class AddTwoNumbersByListNode {
    public ListNode addTwoNumbers(ListNode head1, ListNode head2) {
        ListNode head = null;
        ListNode cur;
        ListNode cur1 = head1;
        ListNode cur2 = head2;
        int carry = 0;
        while (cur1 != null && cur2 != null) {
            int sum = cur1.val + cur2.val + carry;
            if (head == null) {
                head = new ListNode(getNumber(sum));
                cur = head;
            } else {
                cur = new ListNode(getNumber(sum));
            }

            cur1 = cur1.next;
            cur2 = cur2.next;
            cur = cur.next;
        }
        head.next = cur1 != null ? cur1 : cur2;
        return head;
    }

    private int getNumber(int sum) {
        return 0;
    }
}
