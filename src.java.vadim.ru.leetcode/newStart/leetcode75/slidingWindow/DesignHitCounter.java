package newStart.leetcode75.slidingWindow;

public class DesignHitCounter {
    public static void main(String[] args) {
        HitCounter hc = new HitCounter();

        hc.hit(1);
        hc.hit(1);
        hc.hit(2);
        System.out.println(hc.getHits(2));   // ожидаем 3 (две в 1, одна в 2)

        hc.hit(301);                         // 301 % 300 == 1 -> тот же слот, что и секунда 1
        System.out.println(hc.getHits(301)); // ожидаем 2 (секунда 2 и 301; секунда 1 уже слишком старая)
    }

    static class HitCounter {
        private final int[] times = new int[300]; // какая секунда записана в слоте
        private final int[] hits  = new int[300]; // сколько хитов в эту секунду

        public void hit(int t) {
            int idx = t % 300;                 // "позиция на круге" 0..299

            if (times[idx] != t) {             // в этом слоте была ДРУГАЯ секунда (устарела)
                times[idx] = t;                // перезаписываем секундой t
                hits[idx] = 1;                 // начинаем счётчик заново
            } else {
                hits[idx]++;                   // та же секунда t -> просто увеличиваем
            }
        }

        public int getHits(int t) {
            int total = 0;

            for (int i = 0; i < 300; i++) {
                // слот "валиден", если записанная секунда попадает в последние 300 секунд
                if (t - times[i] < 300) {
                    total += hits[i];
                }
            }
            return total;
        }
    }
}
