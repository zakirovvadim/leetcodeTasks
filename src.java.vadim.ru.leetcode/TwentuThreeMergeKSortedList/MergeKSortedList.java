package TwentuThreeMergeKSortedList;

import java.util.*;

public class MergeKSortedList {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode listNode2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode listNode3 = new ListNode(2, new ListNode(6));
        ListNode[] arr = new ListNode[] {listNode, listNode2, listNode3};
        mergeKLists(arr);
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode builderList;
        SortedSet<Integer> sortTreeList = new TreeSet<>();
        for (int i = 1; i < lists.length; i++) {
            ListNode nod = lists[i];
            while (nod != null) {
                int val = nod.val;
                sortTreeList.add(val);
                nod = nod.next;
            }
        }
        ListNode listNode = null;
        for (Integer val : sortTreeList) {
            listNode = new ListNode(val);
        }
        return new ListNode();
    }

    private ListNode buildNode(Integer val, Integer nextval) {
        ListNode listNode = new ListNode(val,)
    }
}
