class Solution(object):
    def repeatedNTimes(self, A):
        """
        :type A: List[int]
        :rtype: int
        """
        uniq = set()
        for a in A:
            if a not in uniq:
                uniq.add(a)
            else:
                return a