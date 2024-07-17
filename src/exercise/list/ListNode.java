package exercise.list;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ListNode {
    protected int val;
    protected ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}
