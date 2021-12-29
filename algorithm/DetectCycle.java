package algorithm;

import basic.ListNode;

/**
 * @author shanruiyu <shanruiyu@kuaishou.com>
 * Created on 2021-12-29
 */
public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast == null) {
                return null;
            }
            fast = fast.next;
            if (slow == fast) {
                break;
            }
        }
        if (fast == null) {
            return null;
        }
        ListNode l = head;
        while (l != slow) {
            l = l.next;
            slow = slow.next;
        }
        return l;
    }
}
