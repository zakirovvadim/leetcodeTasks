package old.addTwoNumbers;


public class AddTwoNumbers {
    public static void main(String[] args) {
//        ListNode listNode = new ListNode(2, new ListNode(4, new ListNode(3)));
//        ListNode listNode2 = new ListNode(5, new ListNode(6, new ListNode(4)));
//        ListNode listNode = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
//        ListNode listNode2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
        ListNode listNode = new ListNode(0);
        ListNode listNode2 = new ListNode(0);

        ListNode foo = foo(listNode, listNode2);
        System.out.println("end");
    }

    public static ListNode foo(ListNode l1, ListNode l2) {
        boolean flag = true;
        int i = 1;
        int p = 0;

        ListNode dummy = new ListNode();
        ListNode dummy2 = dummy;
        while (flag) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int r1 = val1 * i;
            int r2 = val2 * i;
            int r3 = r1 + r2;
            if (p != 0) {
                int ost = r3 + p;
                dummy.next = new ListNode(ost);
                p = 0;
                if (ost > 9) {
                    p = ost / 10 % 10;
                    dummy.next = new ListNode(ost % 10);
                }
            } else {
                dummy.next = new ListNode((r3));
                if (r3 > 9) {
                    p = r3 / 10 % 10;
                    dummy.next = new ListNode(r3 % 10);
                }
            }
            dummy = dummy.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;

            if (l1 == null && l2 == null) {
                flag = false;
                if (p != 0) {
                    dummy.next = new ListNode(p);
                }
            }
        }
        return dummy2.next;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
