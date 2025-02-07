package old.groupAnagrams;

import java.util.*;

/**
 * Для првоерки наличия комбинации и тех же букв используем ОТСОРТИРОВАННЫЙ по символам стринг как ключ,
 * таким образом любая комбинация из тех же самых символов
 * после сортировки будет одинаковой.
 */
public class Main {
    public static void main(String[] args) {
        String[] strs = new String[]{"duh", "ill"};
        System.out.println(groupAnagrams(strs));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> collect = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String s = String.valueOf(chars);
            if (collect.containsKey(s)) {
                collect.get(s).add(str);
            } else {
                List<String> newStr = new ArrayList<>();
                newStr.add(str);
                collect.put(s, newStr);
            }
        }
        List<List<String>> result = new ArrayList<>(collect.values());
        return result;
    }
}
