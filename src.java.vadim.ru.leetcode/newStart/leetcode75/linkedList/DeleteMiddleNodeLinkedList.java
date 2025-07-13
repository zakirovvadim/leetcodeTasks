package newStart.leetcode75.linkedList;

import java.util.LinkedList;
/*
Используется алгоритм зайца и черепахи, т е быстрого и медленного указателя. Согласно нему, создаем два указателя, так как нам нужно
найти середину, то это быстрый указатель деленный на два, т.е. в два раза быстрее чем медленный. Т.о. быстрый указатель это некст.некст,
а медленынй просто некст. Также добавяляем предмедленный указатель, так как это кастомный клас без указания не предыдущего, а он нам нужен чтобы при удалении среднего
у предыдущего некст поменять на средняяНода.некст.
Потом в цикле пока быстрый указатель не упрется в конец, т.е. станет налл, или его некст, станет налл если список четный.
Внутри цикла размечаем ноды для последующего переход.
Как выйдем из цикла у  предсредней ноды меняем некст на следующю ноду у "бывшей" средней ноды и возвращаем голову.

 */
public class DeleteMiddleNodeLinkedList {
    public static void main(String[] args) {
//        ListNode list6 = new ListNode(6, null);
//        ListNode list2 = new ListNode(2, list6);
//        ListNode list11 = new ListNode(1, list2);
//        ListNode list7 = new ListNode(7, list11);
//        ListNode list4 = new ListNode(4, list7);
//        ListNode list3 = new ListNode(3, list4);
//        ListNode list1 = new ListNode(1, list3);


//        ListNode list4 = new ListNode(4, null);
//        ListNode list3 = new ListNode(3, list4);
//        ListNode list2 = new ListNode(2, list3);
//        ListNode list1 = new ListNode(1, list2);


        ListNode list2 = new ListNode(2, null);
        ListNode list1 = new ListNode(1, list2);
        deleteMiddle(list1);
        System.out.println();
    }

    public static ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head;
        ListNode low = head;
        ListNode beforeLow = null;

        while (fast != null && fast.next != null) {
            beforeLow = low; // прихраниваем предМедленную ноду
            low = low.next; // итерируем медленную ноду на один
            fast = fast.next.next; // итерируем быструю ноду на два вперед

        }
        beforeLow.next = low.next;
        return head;
    }


}
