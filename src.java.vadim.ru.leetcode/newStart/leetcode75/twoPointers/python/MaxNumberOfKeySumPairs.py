"""
        Алгоритм поиска максимального количества пар чисел в массиве, дающих сумму k.
        Использует подход двух указателей после сортировки.

        Шаги:
        1. Сортируем массив для возможности использования двух указателей
        2. Инициализируем указатели: l=0 (начало), r=len(nums)-1 (конец)
        3. Пока левый указатель меньше правого:
           - Если сумма элементов == k:
             * Увеличиваем счетчик пар
             * Сдвигаем оба указателя (элементы использованы)
           - Если сумма > k: двигаем правый указатель влево (уменьшаем сумму)
           - Если сумма < k: двигаем левый указатель вправо (увеличиваем сумму)

        Сложность: O(n log n) из-за сортировки, O(1) по памяти
"""
class Solution:
    def maxOperations(self, nums: List[int], k: int) -> int:
        l = 0
        r = len(nums) - 1
        result = 0
        nums = nums.sort()
        while l < r:
            if k == (nums[l] + nums[r]):
                result += 1
                r -= 1
                l += 1
            elif k < nums[l] + nums[r]:
                r -= 1
            else:
                l += 1
        return result