for l in range(n):
    seen, B = set(), 0
    for r in range(l, n):
        x = nums[r]
        if x not in seen:
            seen.add(x)
            B += 1 if (x % 2) == 0 else -1
        if B == 0:
            result = max(result, r - l + 1)