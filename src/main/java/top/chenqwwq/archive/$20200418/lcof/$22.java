package top.chenqwwq.archive.$20200418.lcof;

/**
 * 面试题22. 链表中倒数第k个节点
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * <p>
 * 返回链表 4->5.
 *
 * @author chen
 * @date 2020/4/11 下午1:13
 */
public class $22 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode getKthFromEnd(ListNode head, int k) {
            ListNode fast = head;
            while (--k > 0 && fast != null) {
                fast = fast.next;
            }
            if (k != 0) {
                return null;
            }

            while (fast.next != null) {
                fast = fast.next;
                head = head.next;
            }

            return head;
        }
    }
}
