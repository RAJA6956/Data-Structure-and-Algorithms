class Solution:
    def maxSubarraySum(self, nums: List[int], k: int) -> int:
        N = len(nums)
        hashMap = {-1 : 0}
        pref = 0
        max_total = float("-inf")

        for i in range(N):
            pref += nums[i]
            if i - k in hashMap:
                max_total = max(max_total, pref - hashMap[i - k])
                hashMap[i] = min(hashMap[i - k], pref)
            else:
                hashMap[i] = pref
        
        return max_total