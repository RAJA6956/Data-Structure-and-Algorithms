class Solution {
public:
    int minOperations(string s, int k) {
        const uint n = s.size(), z = count(s.begin(), s.end(), '0');
        if (z == 0) return 0;
        if (k == z) return 1;
        if (k == 1) return z;
        if (n == k || z & ~k & 1) return -1;
        auto ceil = [](uint a, uint b) { return (a + b - 1) / b; };
        uint c = ceil(z, k);
        uint r0 = max(c, ceil(z, n - k)), r1 = max(c, ceil(n - z, n - k));
        r0 += 1 & r0, r1 += 1 & ~r1;
        uint m0 = (1 & ~z) - 1, m1 = (1 & ~(z ^ k)) - 1;
        return min(m0 | r0, m1 | r1);
    }
};