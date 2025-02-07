package old.longestPrefix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Prefix {
    public static void main(String[] args) {
        String [] str = {"flower","flow","flag"};
        List<String> list = List.of(str);
        ArrayList<String> list2 = new ArrayList<>(list);
        Collections.sort(list2);
        boolean flag = true;
        int i = 0;
        char[] first = list2.get(0).toCharArray();
        char[] last = list2.get(list.size() - 1).toCharArray();
        StringBuilder builder = new StringBuilder();
        while(flag) {
            if (first.length - 1 < i) {
                break;
            }
            if (last.length - 1< i) {
                break;
            }
            char a = first[i];
            char b = last[i];
            if (a == b) {
               builder.append(a);
            } else {
                flag = false;
            }
            i++;
        }
    }
}
