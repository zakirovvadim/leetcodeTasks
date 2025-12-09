# 605. Can Place Flowers
class CanPlaceFlowers:
    def can_place_flowers(self, flowerbed, n):
        if n == 0:
            return True  # Если не нужно сажать цветы, сразу true

        i = 0
        while i < len(flowerbed):
            if flowerbed[i] == 0:
                left_empty = (i == 0) or (flowerbed[i - 1] == 0)
                right_empty = (i == len(flowerbed) - 1) or (flowerbed[i + 1] == 0)

                if left_empty and right_empty:
                    flowerbed[i] = 1  # Садим цветок
                    n -= 1  # Уменьшаем количество нужных цветов

                    if n == 0:
                        return True  # Все цветы посажены

                    i += 1  # 🔥 Пропускаем следующую ячейку, т.к. уже посадили рядом
            i += 1
        return n == 0  # Если посадили все цветы, true, иначе false