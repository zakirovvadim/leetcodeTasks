package newStart.leetcode75.queue;

import java.util.ArrayDeque;
import java.util.Queue;
/*
Алгоритм прописан ниже. Важные замечания, в очереди кладем именно индексы, а не символы и послесравнения индексов, переносим
индекс в конце его очереди, если он победил, с учетом сложения его текущего индекса с длиной строки.
 */
public class Dota2Senate {

    public static void main(String[] args) {
        System.out.println(predictPartyVictory("RD"));
    }

    public static String predictPartyVictory(String senate) {
        Queue<Integer> queueR = new ArrayDeque<>(); // сначала создаем две очереди для двух партий сената
        Queue<Integer> queueD = new ArrayDeque<>();

        for(int i = 0; i < senate.length(); i++) { // заполняем очереди принадлежащим им сенатом, в очередь кладем не символ, а индекс
            if (senate.charAt(i) == 'R') {
                queueR.offer(i);
            } else {
                queueD.offer(i);
            }
        }

        while (!queueR.isEmpty() && !queueD.isEmpty()) { // в цикле, пока обе очереди не будут пустыми
            Integer r = queueR.poll(); // вытаскиваем элемент с начала очереди с удалением
            Integer d = queueD.poll();

            if (r < d) { // если индекс R партии больше чем D
                queueR.offer(r + senate.length()); // значит Р член партии может удалить Д (ничего с ним не делаем) и помещаем Р в конец очереди под индексом = текущий + длина строки
            } else {
                queueD.offer(d + senate.length()); // аналогично с Д
            }
        }

        if (queueD.isEmpty()) return "Radiant"; // смотрим, кто пустой, тот проиграл
        else return "Dire";
    }
}
