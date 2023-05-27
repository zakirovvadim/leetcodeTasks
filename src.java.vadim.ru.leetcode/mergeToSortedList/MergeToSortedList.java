package mergeToSortedList;

import java.util.Objects;

public class MergeToSortedList {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(4)));
//        ListNode listNode2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode listNode2 = null;
        ListNode result = mergeTwoLists(listNode, listNode2);
        System.out.println(1);
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }
        if (list2 == null) {
            return list1;
        } else if (list1 == null) {
            return list2;
        }
        boolean flag = true;
        ListNode dummy = new ListNode();
        ListNode dummy2 = dummy;
        while (flag) {
            int val = list1.val;
            int val2 = list2.val;
            if (val <= val2) {
                //dummy.val = val;
                dummy.next = new ListNode(val);
                list1 = list1.next;
            } else {
               // dummy.val = val2;
                dummy.next = new ListNode(val2);
                list2 = list2.next;
            }
            dummy = dummy.next;
            if (list1 == null) {
                dummy.next = list2;
                flag = false;
            } else if (list2 == null){
                dummy.next = list1;
                flag = false;
            }
        }
        ListNode dummy3 = dummy2.next;
        return dummy3;
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
