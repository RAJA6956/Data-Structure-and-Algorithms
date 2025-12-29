from collections import defaultdict
from itertools import pairwise, product


class Solution:
    def pyramidTransition(self, bottom: str, allowed: list[str]) -> bool:
        m = defaultdict(list)

        for a, b, c in allowed:
            m[a, b].append(c)

        def can_build_pyramid(pattern: str | list[str]) -> bool:
            return (
                len(pattern) == 1

                or

                any(
                    map(
                        can_build_pyramid,
                        product(*(m[a, b] for a, b in pairwise(pattern)))
                    )
                )
            )

        return can_build_pyramid(bottom)