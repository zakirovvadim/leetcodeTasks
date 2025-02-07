package old.containerWithWater;

/**
 * Алгоритм схож с бинарным поиском, когда мы имеем две точки левая и правая
 * в цикле сдвигаемся к центру, сравнивая что меньше тот и двигается к центру.
 * Паралелльно с этим записываем максимальное значение площади контейнра с водой.
 * Длина между офсетами умноженная на минимальное значение между значением левого и правого офсета.
 * Площадь записываем в отдельную переменную и сравниваем, еслибтольше перезаписываем.
 */
public class Main {
    public static void main(String[] args) {
        int [] nums = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(nums));
    }

    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxValue = 0;
        while (left <= right) {
            int p = (right - left) * (Math.min(height[left], height[right])); // расчет площади
            if (p > maxValue) {
                maxValue = p;
            }
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxValue;
    }
}
