package newStart.leetcode75.linkedList;
/*
        * Разделяет связный список на узлы с чётными и нечётными значениями,
 * затем соединяет нечётный список с чётным.
        *
        * Логика:
        * 1. Создаём два фиктивных узла (dummy) для чётных и нечётных
 * 2. Проходим по исходному списку:
        *    - Если значение чётное (val % 2 == 0) -> добавляем в чётный список
 *    - Если нечётное -> добавляем в нечётный список
 * 3. Важно обнулить конец чётного списка (even.next = null)
 * 4. Соединяем конец нечётного списка с началом чётного
 * 5. Возвращаем начало нечётного списка (пропуская dummy-узел)
 */
public class OddEvenLinkedList {

    public static void main(String[] args) {
        ListNode list5 = new ListNode(5, null);
        ListNode list4 = new ListNode(4, list5);
        ListNode list3 = new ListNode(3, list4);
        ListNode list2 = new ListNode(2, list3);
        ListNode list1 = new ListNode(1, list2);
        ListNode listNode = oddEvenList(list1);
        System.out.println(listNode);
    }

    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {return null;}
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while (even != null && even.next != null) {
            odd.next =  even.next;
            odd = odd.next;

            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead;
        return head;
    }
}
