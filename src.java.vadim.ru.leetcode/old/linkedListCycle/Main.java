package old.linkedListCycle;

import old.Utils.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Main {
    /**
     * Готовим условие для запуска задачи локально
     *
     * @param args
     */
    public static void main(String[] args) {

        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        // Цикл для создания цикличных нод
        ListNode iterateNode = node1;
        while (iterateNode != null) {
            ListNode next = iterateNode;
            if (next.val == 5) {
                next.next = node1;
                break;
            } else {
                iterateNode = iterateNode.next;
            }
        }
        System.out.println(hasCycle(node1));
    }

    /**
     * Бежим по циклу линкед нод, берем хешКод каждой ноды и сохраняем в коллекцию,
     * перед этим проверяем на наличиехешКода в коллекции у текущей итерации, если есть, значит нода уже была
     * и это цикл, далее возвращаем true.
     *
     * @param head
     * @return
     */
    public static boolean hasCycle(ListNode head) {
        Set<Integer> hashes = new HashSet<>();
        while (head != null) {
            ListNode next = head;
            int hashCode = next.hashCode();
            if (hashes.contains(hashCode)) {
                return true;
            }
            hashes.add(hashCode);
            head = head.next;
        }
        return false;
    }
}
