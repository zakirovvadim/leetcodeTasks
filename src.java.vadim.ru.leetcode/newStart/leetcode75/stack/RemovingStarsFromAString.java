package newStart.leetcode75.stack;

import java.util.Stack;
/*
Задача не сложная, вместо стека можно использовать стрингБилдер. Если видем в итерации по строке что это звездочка, тогда
удаляем из стрингБилдера последний элемент, если нет, то добавляем в символ в конец новой строки стрингшбилдера
 */
public class RemovingStarsFromAString {

    public static void main(String[] args) {
        System.out.println(removeStars("leet**cod*e"));
        System.out.println(removeStars("erase*****"));
    }
    public static String removeStars(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(s.charAt(i));
            }
        }
        return  sb.toString();
    }

}
