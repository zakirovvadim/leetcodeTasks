package topKFrequentWords;

import java.util.*;

/**
 * Сделал другой алгоритм чем с циффрами, более эффективынй
 * Создаем мапу с ключем - слово и значение это частотая появления и инкрементируем в итерациях.
 * Далее помещаем коллекцию ключей в лист.
 * у листа вызываем метод сортировки, заводим две переменны в лямбде и пишем тернарный оператор
 * Если значение фрекуенси из мапы с ключом первой переменной равно с ключом второй переменной, то сравниваем просто ключи через compareTo, иначе вычитаем фрекуенси из мапы по второму ключу минус по первому.
 * w2 всегда идет больше w1, если вычитать наоборот, то порядок в сортировки изменится на asc. т.е. с меньшего к большему.
 * Далее возвращаем у этого же листа метод саблист от 0 до k.
 */
public class Main {
    public static void main(String[] args) {
        String[] str = new String[]{"the","day","is","sunny","the","the","the","sunny","is","is"};
        List<String> list = topKFrequent(str, 4);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(str[i]);
        }
    }

    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        List<String> result = new ArrayList<>(map.keySet());
        result.sort((w1, w2) -> map.get(w1).equals(map.get(w2)) ? w1.compareTo(w2) : map.get(w2) - map.get(w1));
        return result.subList(0, k);
    }
}
