package reverseLinkedList;

import Utils.ListNode;

/**
 * 1 Алгоритм: во время цикла с головы до хвоста линкедЛиста сохраняем отедльные переменные на предыдущую и на следующую ноду.
 * 2 Далее у ноды текущей итерации в значении некст присваиваем переменную предыдущего значения,
 * 3 переменная предыдущего далее берет значение ноды текущей итерации.
 * 4 Далее двигаем офсет, беря переменную некст из ранее сохраненной переменной, так как некст у ноды текущей итерации, перезатерли на шаге 2.
 * 5 Переменная предыдущего значения будет записывать ноды с некстами обратного порядка, ее и выдаем в качестве результата.
 */
public class Main {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(listNode);
        ListNode listNode1 = reverseList(listNode);
        System.out.println(listNode1);

    }

    public static ListNode reverseList(ListNode head) {
        ListNode previous = null;
        ListNode nextStep = head;
        while (head != null) {
            nextStep = head.next;
            head.next = previous;
            previous = head;
            head = nextStep;
        }
        return previous;
    }
}
