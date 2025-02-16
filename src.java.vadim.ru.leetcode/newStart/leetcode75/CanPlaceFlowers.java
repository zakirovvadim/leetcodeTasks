package newStart.leetcode75;
//605. Can Place Flowers
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
