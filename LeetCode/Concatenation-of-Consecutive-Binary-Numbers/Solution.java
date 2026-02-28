i = 1 → binary "1", bits = 1
res = (0 << 1) | 1 = 1

i = 2 → binary "10", bits = 2 (2 is power of two, so bits becomes 2)
res = (1 << 2) | 2 = 4 | 2 = 6

i = 3 → binary "11", bits still 2
res = (6 << 2) | 3 = 24 | 3 = 27
Final: 27 mod MOD = 27