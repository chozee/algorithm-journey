package exercise.list;

import static exercise.list.BaseList.buildAscendingList;
import static exercise.list.BaseList.buildRanomList;

/**
 * 合并list
 */
public class MergeList {
    public static void main(String[] args) {
        ListNode list1 = buildAscendingList(3);
        ListNode list2 = buildAscendingList(3);

        ListNode merge = merge(list1, list2);
    }

    public static ListNode merge(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return head1 == null ? head2 : head1;
        }

        ListNode head = head1.val <= head2.val ? head1 : head2;
        ListNode cur1 = head.next;
        ListNode cur2 = head == head1 ? head2 : head1;
        ListNode pre = head;

        while (cur1 != null && cur2 != null) {
            if (cur1.val <= cur2.val) {
                pre.next = cur1;
                cur1 = cur1.next;
            } else {
                pre.next = cur2;
                cur2 = cur2.next;
            }
            pre = pre.next;
        }

        pre.next = cur1 != null ? cur1 : cur2;
        return head;
    }

    private static ListNode min(ListNode head1, ListNode head2) {
        ListNode min;
        if (head1.val > head2.val) {
            min = head2;
            head2 = head2.next;
        } else {
            min = head1;
            head1 = head1.next;
        }

        return min;
    }
}
