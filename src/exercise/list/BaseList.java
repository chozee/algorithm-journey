package exercise.list;

public class BaseList {
    public SimpleNode build(int count) {
        SimpleNode head = buildNode(count);
        SimpleNode cur = head;
        while (count > 0) {
            cur.next = buildNode(count--);
            cur = cur.next;
        }

        return head;
    }

    private SimpleNode buildNode(int i) {
        return new SimpleNode(i);
    }
}
