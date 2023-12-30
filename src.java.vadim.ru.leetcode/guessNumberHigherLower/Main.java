package guessNumberHigherLower;

// Угадывание числа похоже на бинарный поиск, где мы мид отправляем в метод guess, если число больше, сдвигаем левый офсет до мид + 1 и наооборот, если равне, возвращаем мид.
// Если вне цикла, возвращаем левый эелемень (p.s. не разобрался почему)
public class Main {
    public static void main(String[] args) {
    }

    public static int guessNumber(int n) {
        int low =0;
        int high = n;
        while (low < high) {
            int mid = low + (high - low) / 2;
            int ans = guess(mid);
            if (ans == -1) {
                high = mid - 1;
            } else if (ans == 1) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return low;
    }

    static int guess(int num) {
        return 0;
    }
}
