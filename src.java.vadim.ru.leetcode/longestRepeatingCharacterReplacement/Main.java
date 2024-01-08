package longestRepeatingCharacterReplacement;

import java.util.*;

/**
 * Алгоритм не самый эффективный
 * Создаем левый офсет и правый, правый офсет это i в итерации по строке. Также создаем мапу буква-частотность
 * при каждой итерации повышаем частотность у каждой буквы.
 * потом в этойже итерации считаем у кого максимальное значение
 * првоеряем, если длина мжеду левым и правым минус макс значение больше чем k, тогда уменьшеаем значнеие у мапы по левому ключу и также на один повышаем левый офсет
 * Дальше в переменную резалт записываем максимальное значение между старым резалтом и длиной между левый - правый +1 на текущей итерации
 */
public class Main {
    public static void main(String[] args) {
        int abab = characterReplacement("ABAB", 2);
        System.out.println(abab);
    }
    public static int characterReplacement(String s, int k) {
       int left = 0; // содаем левую переменную
       int result = 0; // результирующая переменная
       Map<String, Integer> map = new HashMap<>(); // мапа где ключ это буква, а значение - частотность
        for (int i = 0; i < s.length(); i++) { // цикл по стринге
            String key = String.valueOf(s.charAt(i)); // берем текущий символ
            map.put(key, map.getOrDefault(key, 0) + 1); // инерементируем частоту появлений в мапе
            int maxFreq = map.values().stream().mapToInt(Integer::intValue).max().getAsInt(); // берем из значений максимальное
            if (((i - left + 1) - maxFreq) > k) { // если длина нашего окна (между левыйм и правым офсетом + 1) минус максимальная частота из мапы больше чем таргет k. Значит нам нужно сдвинуть левый офсет вправо.
                String leftKey = String.valueOf(s.charAt(left)); // достаем ключ по левому офсету
                map.put(leftKey, map.get(leftKey) - 1); // декрементируем в мапе по левому символу частотность
                left++; // инкерементируем левый офсет
            }
            result = Math.max(result, i - left + 1); // результат как максимум между пердыдущим значением результата и новой вычисленной длинной между левым и правым офсетом.
        }
        return result;
    }
}
