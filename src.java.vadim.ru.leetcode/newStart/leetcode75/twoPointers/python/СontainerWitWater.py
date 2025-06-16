# на повтор, алгоритм описан в дубликат-классе. Реализацию сделал на питоне
def max_area(height):
    l = 0
    r = len(height) - 1
    max_area = 0
    while l != r:
        x = r - l
        y = min(height[l], height[r])
        max_area = max(max_area, x * y)
        if height[l] <= height[r]:
            l += 1
        else:
            r -= 1
    return max_area