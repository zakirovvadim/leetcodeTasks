package newStart.leetcode75;
//605. Can Place Flowers
/*
### Алгоритм решения:
1. **Итерируемся по клумбе (`flowerbed`).**
2. **Проверяем возможность посадки цветка в текущую ячейку:**
    - Левая соседняя ячейка (`flowerbed[i - 1]`) пуста или текущая ячейка на самой границе массива.
    - Правая соседняя ячейка (`flowerbed[i + 1]`) пуста или текущая ячейка на противоположной границе массива.

3. Если цветок можно посадить:
    - Сажаем цветок и уменьшаем счётчик `n`.
    - Пропускаем следующую ячейку (так как цветы не могут быть соседними).

4. Если на момент итерации `n` становится равно 0, возвращаем `true` (все цветы посажены).
5. После завершения проверки возвращаем `false`, если `n > 0`.

 */
public class CanPlaceFlowers {
    public static void main(String[] args) {
//        int[] flowerbed = {1,0,0,0,0,0,1};
        int[] flowerbed2 = {1,0,0,0,0,1};
        int n = 2;
        CanPlaceFlowers canPlaceFlowers = new CanPlaceFlowers();
        boolean result = canPlaceFlowers.canPlaceFlowers(flowerbed2, n);
        System.out.println(result);
    }
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) return true; // Если не нужно сажать цветы, сразу true

        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                boolean leftEmpty = (i == 0) || (flowerbed[i - 1] == 0);
                boolean rightEmpty = (i == flowerbed.length - 1) || (flowerbed[i + 1] == 0);

                if (leftEmpty && rightEmpty) {
                    flowerbed[i] = 1; // Садим цветок
                    n--; // Уменьшаем количество нужных цветов

                    if (n == 0) return true; // Все цветы посажены

                    i++; // 🔥 Пропускаем следующую ячейку, т.к. уже посадили рядом
                }
            }
        }
        return n == 0; // Если посадили все цветы, true, иначе false
    }
}
