package old.addTwoNumbers;

import old.Utils.ListNode;

/**
 * Алгоритм сход со сложением в столбик и сохранением десятков, если сложение единиц больше десяти.
 */
public class SolutionTwo {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode listNode2 = new ListNode(5, new ListNode(6, new ListNode(7)));
        System.out.println(addTwoNumbers(listNode, listNode2));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        int carry = 0; // переменная для хранения дестяка
        while (l1 != null || l2 != null || carry != 0) {
            int val1;
            int val2;
            if (l1 != null) {
                val1 = l1.val;
            } else val1 = 0;
            if (l2 != null) {
                val2 = l2.val;
            } else val2 = 0;

            int val = val1 + val2 + carry; // складываем знаменатели и десятку (т.е. единицу, или двойику или тд)
            carry = val / 10; // вычисляем сколько десятков нуно перенести
            val = val % 10; // если есть остаток от деления на десять, т.е. берем единицы,а не десятки, записываем его, если нет, значит ноль
            curr.next = new ListNode(val);

            curr = curr.next;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        return dummy.next;
    }

}
