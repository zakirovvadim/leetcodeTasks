package newStart.leetcode75.linkedList;

import java.util.ArrayList;
import java.util.List;

public class MaximumTwinSumofList {

    public static void main(String[] args) {
        System.out.println(pairSum(getFirstExample()));
        System.out.println(pairSum2(getFirstExample()));
//        System.out.println(pairSum(getSecondExample()));
//        System.out.println(pairSum(getThirdExample()));
    }

    private static ListNode getFirstExample() {
        ListNode list4 = new ListNode(1, null);
        ListNode list3 = new ListNode(2, list4);
        ListNode list2 = new ListNode(4, list3);
        ListNode list1 = new ListNode(5, list2);
        return list1;
    }

    private static ListNode getSecondExample() {
        ListNode list4 = new ListNode(3, null);
        ListNode list3 = new ListNode(2, list4);
        ListNode list2 = new ListNode(2, list3);
        ListNode list1 = new ListNode(4, list2);
        return list1;
    }

    private static ListNode getThirdExample() {
        ListNode list2 = new ListNode(100000, null);
        ListNode list1 = new ListNode(1, list2);
        return list1;
    }

    // мое решение
    /*
    сначало циклом идем по нодам и кладем в лист
    потом итерируемся по листу слева и справа к центру и складываем и сравниваем с переменной результатом
     */
    public static int pairSum(ListNode head) {
        long s = System.nanoTime();
        List<Integer> res = new ArrayList<>();
        while (head != null) {
            int val = head.val;
            res.add(val);
            head = head.next;
        }
        int l = 0;
        int r = res.size() - 1;
        int sumRes = 0;
        while (l < r) {
            Integer lv = res.get(l);
            Integer rv = res.get(r);
            int sum = lv + rv;
            if (sum > sumRes) {
                sumRes = sum;
            }
            r--;
            l++;
        }
        long f = System.nanoTime();
        System.out.println("time " + (f -s));
        return sumRes;
    }

    // самое оптимальное по памяти решение
    public static int pairSum2(ListNode head) {
        long s = System.nanoTime();
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            ListNode tmp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = tmp;
        }
        var res = 0;
        while(prev != null && slow != null) {
            res = Math.max(prev.val + slow.val, res);
            slow = slow.next;
            prev = prev.next;
        }
        long f = System.nanoTime();
        System.out.println("time " + (f -s));
        return res;
    }
}
