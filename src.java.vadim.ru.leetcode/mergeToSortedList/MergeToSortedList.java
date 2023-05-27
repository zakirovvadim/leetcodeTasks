//package mergeToSortedList;
//
//import java.util.Objects;
//
//public class MergeToSortedList {
//    public static void main(String[] args) {
//       ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(4)));
//       ListNode listNode2 = new ListNode(1, new ListNode(3, new ListNode(4)));
//        ListNode result = mergeTwoLists(listNode, listNode2);
//        System.out.println(1);
//    }
//
//    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//        ListNode listNode;
//        int offset;
//       while (list1.next !=  null) {
//           if (list2.next != null) {
//               if (list1.val < list2.val) {
//                   new ListNode(list1.val, list2);
//                   offset = list2.val;
//               } else {
//                   new ListNode(list2.val, list1);
//                   offset = list1.val;
//               }
//           }
//       }
//    }
//
//    public static class ListNode {
//        int val;
//        ListNode next;
//        ListNode() {}
//        ListNode(int val) { this.val = val; }
//        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//    }
//}
