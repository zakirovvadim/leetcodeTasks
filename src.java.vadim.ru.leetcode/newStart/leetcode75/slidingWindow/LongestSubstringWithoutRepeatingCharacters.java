package newStart.leetcode75.slidingWindow;

import java.util.HashSet;
import java.util.Set;
/*
Общая логика такая, что имея два указателя, левый и правый, дивгаем правый и добавляем в сет символы до тех пор, пока
какой либо не повторяется + инкермент правого указателя. Если видим повторный символ, тогда двигаем левый указатель и удаляем из коллекции его, и инкре-
ментируем левый указатель. Таким образом из коллекции, что является образом скользящего окна появляются и удаляются символы
с правого и левого края. Если символ повторился, мы его удалили (ту, что была в первый раз) и так как правый указатель в этом случае
не инкерментируется, он на след итерации цикла будет на том же значении символа и снова его добавит.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcbdbefg"));
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int l = 0; // левый указатель
        int r = 0; // правый указатель
        int maxLen = 0; // максимальная зарегистрирвоанная длина униклаьных символов
        Set<Character> set = new HashSet<>(); // сет для расположения "скользящего окна"
        while (r < s.length()) { // цикл пока правый курсор не дойдет до конца
            if (!set.contains(s.charAt(r))) { // если такого символа в окне нет, то
                set.add(s.charAt(r)); // доабвляем в скользящее окно
                maxLen = Math.max(maxLen, r - l + 1); // смотрим, после добавления набор уникльных символов, если их больше то это новая максима
                r++; // двигаем правый указатель
            } else {// иначе
                set.remove(s.charAt(l)); // удаляем текущий элемент из окна - коллекции (п.с. он будет добавлен в сле итерации, так как правый указатель остался на месте и инкерметирвоался только левый указатель// )
                l++; // инкремент левого указателя
            }
        }
        return maxLen;
    }
}
