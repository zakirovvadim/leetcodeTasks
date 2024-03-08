package carFleet;

import java.util.*;

/**
 * Данную задачу лучше иллюстрирвоать на графике х и у, для понимания задачи.
 * Здесь нам надо положить в сортированную desc мапу ключ - позиция, значнеие - скорость.
 * Добавить две переменные результружщий флит и самый медленный авто.
 * в фориче по мапе мы дожны найти реультат затраченного времени для достижения таргета.
 * Когда мы находим его, нужно сравнить с самым медленынм значением, если слоуестКар меньше текущего авто, значит прошлая
 * итерация была быстрее и уходит в отрыв делая отдельный флот, а все последующие будут плетсись позади текущего, независимо
 * от их скорости, если только они еще медленнее.
 *
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(carFleet(12, new int[]{10,8,0,5,3}, new int[]{2,4,1,1,3}));
//        System.out.println(carFleet(10, new int[]{6,8}, new int[]{3,2}));
    }

    public static int carFleet(int target, int[] position, int[] speed) {
        SortedMap<Double, Double> map = new TreeMap<>(Comparator.reverseOrder());
        for (int i = 0; i < position.length; i++) {
            map.put((double)position[i], (double)speed[i]);
        }
        int fleet = 0;
        double slowestCar = 0.0;
        for (var es : map.entrySet()) {
            double current = ((double) target - es.getKey()) / es.getValue();
            if (slowestCar < current) {
                fleet++;
                slowestCar = current;
            }
        }
        return fleet;
    }
}
