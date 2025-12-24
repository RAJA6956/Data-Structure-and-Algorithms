class Solution:
    def countDigitOne(self, n: int) -> int:
        num = str(n)
        n = len(num)

        @lru_cache(None)
        def dp(ind, tight, csf=0):
            if ind == n:
                return csf

            count = 0
            upto = int(num[ind]) if tight else 9
            for i in range(upto + 1):
                new_tight = tight and (i == int(num[ind]))
                count += dp(ind + 1, new_tight, csf + (1 if i == 1 else 0))
            return count

        return dp(0, True)