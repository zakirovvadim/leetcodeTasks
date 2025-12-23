package old.mergeToSortedList;

import java.util.Objects;

/*
 * Merge Two Sorted Lists (слияние двух отсортированных односвязных списков).
 *
 * Идея: используем "фиктивную голову" (head/dummy) и указатель tail на хвост результата.
 * Пока оба списка не закончились, сравниваем текущие головы list1 и list2,
 * выбираем меньшую и "пришиваем" этот узел в конец результата (узлы не копируем — переставляем ссылки).
 * Когда один список закончился, оставшийся хвост второго списка уже отсортирован,
 * поэтому его можно присоединить целиком одной операцией: tail.next = остаток.
 *
 * Сложность: O(n + m) по времени, O(1) по дополнительной памяти (кроме фиктивного узла).
 */
public class MergeToSortedList {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(4)));
//        ListNode listNode2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode listNode2 = null;
        ListNode result = mergeTwoLists(listNode, listNode2);
        System.out.println(1);
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Если оба входных списка пустые — нечего объединять
        if (list1 == null && list2 == null) return null;

// Если один из списков пустой — ответом будет второй (он уже отсортирован)
        if (list2 == null) {
            return list1;
        } else if (list1 == null) {
            return list2;
        }

// Фиктивная голова (sentinel/prehead):
// нужна, чтобы не обрабатывать отдельно "первый добавленный узел".
// Реальная голова результата будет head.next
        ListNode head = new ListNode(0);

// tail — указатель на текущий хвост результирующего списка.
// Инвариант: tail всегда указывает на последний узел результата.
        ListNode tail = head;

// Пока оба списка не закончились — выбираем меньшую голову и пришиваем её в конец результата
        while (list1 != null && list2 != null) {

            // Берём узел с меньшим значением, чтобы сохранялась сортировка результата
            if (list1.val <= list2.val) {

                // "Пришиваем" текущий узел list1 к хвосту результата (узлы НЕ копируем)
                tail.next = list1;

                // Сдвигаем list1 на следующий узел, т.к. текущий уже использовали
                list1 = list1.next;
            } else {
                // Аналогично — пришиваем узел из list2
                tail.next = list2;

                // Сдвигаем list2 вперёд
                list2 = list2.next;
            }

            // Сдвигаем хвост результата на только что пришитый узел
            tail = tail.next;
        }

// После цикла один список пуст, второй может содержать оставшиеся элементы.
// Их можно пришить целиком, т.к. они уже отсортированы и заведомо >= всего, что мы добавили.
        tail.next = (list1 != null) ? list1 : list2;

// Возвращаем реальную голову (пропускаем фиктивный head)
        return head.next;
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
