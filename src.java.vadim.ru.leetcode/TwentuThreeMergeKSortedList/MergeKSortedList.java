package TwentuThreeMergeKSortedList;

import Utils.ListNode;

public class MergeKSortedList {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(0, new ListNode(2, new ListNode(5)));
        ListNode listNode2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode listNode3 = new ListNode(2, new ListNode(6));
        ListNode listNode4 = new ListNode(5, new ListNode(8));
        ListNode[] arr = new ListNode[] {listNode, listNode2, listNode3, listNode4};
        ListNode result = mergeKLists(arr);
        System.out.println(result);
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode compl = null;
        if (lists.length == 1 && lists[0] != null) {
            if (lists[0].next == null) {
                return lists[0];
            }
        }
        for (int i = 0; i < lists.length; i++) {
            ListNode builder = new ListNode(); // нода для построения при сравнении
            ListNode completed = builder; // результирующая нода в рамках итераций по массиву нод
            ListNode first = lists[i];
            if (lists.length == 1) { // проверка на длину == 1
                return first;
            }
            if ((i + 1) >= lists.length) { // проверка на последнюю итерацию
                return compl;
            }
            ListNode second = lists[i + 1]; // берем следующий элемент из массива
            while (first != null || second != null) { // пока обе из нод не налл
                if (first == null) { // первая налл - конец, последняя вторая
                    builder.next = second;
                    break;
                }
                if (second == null) { // вторая налл - конец, последняя первая
                    builder.next = first;
                    break;
                }
                if (first.val > second.val) { // если больше первая
                    builder.next = second; // след ссылка у построителя - присваиваем меньшее значение т.е. значение второго
                    second = second.next; // двигаем оффсет второго некст
                    builder = builder.next; // двигаем оффсет построителя
                } else { // если больше вторая
                    builder.next = first; // след. ссылка построителя - присваиваем меньшее значение, т.е. значение первого
                    first = first.next; // двигаем оффсет у первого
                    builder = builder.next; //двигаем оффсет у построителя
                }
            }
            completed = completed.next; // убираем первое значение, которое возникло при иницияализации
            compl = completed; // присваиваем ноду глобально результрующей ноде
            lists[i + 1] = completed; // так как мы сравнивали первых два элемента с итерацией на первом,
            // результат присваиваем на след по итерации массив, так как он уже сравнивался с предыдущим.
            // Чтобы результат сравнивался уже с i + 2, если она имеется.
        }
        return compl;
    }
}