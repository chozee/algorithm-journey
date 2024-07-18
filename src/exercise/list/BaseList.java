package exercise.list;

import java.security.SecureRandom;
import java.util.Random;

public class BaseList {
    public static ListNode buildRanomList(int count) {
        ListNode head = buildNode(count);
        ListNode cur = head;
        while (count > 0) {
            cur.next = buildNode(count--);
            cur = cur.next;
        }

        return head;
    }
    public static ListNode buildAscendingList(int count) {
        int preVal = new Random().nextInt(100);
        ListNode head = buildAscendNode(count, preVal);
        ListNode cur = head;
        while (count > 0) {
            cur.next = buildAscendNode(count--, cur.getVal());
            cur = cur.next;
        }

        return head;
    }

    private static ListNode buildNode(int i) {
        return new ListNode(random(i, 100));
    }

    private static ListNode buildAscendNode(int i, int preVal) {
        return new ListNode(random(i, preVal, preVal * 2));
    }

    private static int random(int i, int max) {
        return new SecureRandom(SecureRandom.getSeed(i)).nextInt(max);
    }

    private static int random(int seed, int min, int max) {
        return new SecureRandom(SecureRandom.getSeed(seed)).nextInt(min, max);
    }
}
