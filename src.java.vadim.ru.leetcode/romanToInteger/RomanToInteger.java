package romanToInteger;

import java.util.List;
import java.util.Map;

public class RomanToInteger {
    public static void main(String[] args) {
        List<String> list = List.of("III", "LVIII", "MCMXCIV");
        //list.forEach(el -> System.out.println(romanToInt(el)));
        list.forEach(el -> System.out.println(romanTwo(el)));
    }

    public static int romanToInt(String s) {
        char [] arrayStr = s.toCharArray();
        Map<String, Integer> dozens = Map.of("I", 1, "X", 10, "C", 100, "M", 1000 ,"V", 5, "L", 50, "D", 500);
        int val = 0;
        for (int i = 0; i < arrayStr.length; i++) {
            String symbol = String.valueOf(arrayStr[i]);
            if (dozens.containsKey(symbol)) {
                if ((symbol.equals("I") && i != arrayStr.length-1)) {
                    if (String.valueOf(arrayStr[i + 1]).equals("X") || String.valueOf(arrayStr[i + 1]).equals("V")) {
                        Integer nextValue = dozens.get(String.valueOf(arrayStr[i + 1]));
                        Integer currentValue = dozens.get(String.valueOf(arrayStr[i]));
                        int result = nextValue - currentValue;
                        val = val + result;
                        i++;
                        continue;
                    }
                }
                if ((symbol.equals("X") && i != arrayStr.length-1)) {
                    if (String.valueOf(arrayStr[i + 1]).equals("L") || String.valueOf(arrayStr[i + 1]).equals("C")) {
                        Integer nextValue = dozens.get(String.valueOf(arrayStr[i + 1]));
                        Integer currentValue = dozens.get(String.valueOf(arrayStr[i]));
                        int result = nextValue - currentValue;
                        val = val + result;
                        i++;
                        continue;
                    }
                }
                if ((symbol.equals("C") && i != arrayStr.length-1)) {
                    if (String.valueOf(arrayStr[i + 1]).equals("D") || String.valueOf(arrayStr[i + 1]).equals("M")) {
                        Integer nextValue = dozens.get(String.valueOf(arrayStr[i + 1]));
                        Integer currentValue = dozens.get(String.valueOf(arrayStr[i]));
                        int result = nextValue - currentValue;
                        val = val + result;
                        i++;
                        continue;
                    }
                }
                val = val + dozens.get(symbol);
            }
        }
        return val;
    }

    public static int romanTwo(String s) {
        int ans = 0, num = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            switch(s.charAt(i)) {
                case 'I': num = 1; break;
                case 'V': num = 5; break;
                case 'X': num = 10; break;
                case 'L': num = 50; break;
                case 'C': num = 100; break;
                case 'D': num = 500; break;
                case 'M': num = 1000; break;
            }
            if (4 * num < ans) ans -= num;
            else ans += num;
        }
        return ans;
    }
}
