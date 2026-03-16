class Solution:
    def getBiggestThree(self, grid: List[List[int]]) -> List[int]:

        n = len(grid)
        m = len(grid[0])
        results = set()

        def get_default_coords(size):
            results = set()
            # these will move up and to the right
            lt, bm = (size // 2, 0), (size - 1, size // 2)
            # these will move down and to the right
            lb, tm = (size // 2, 0), (0, size // 2)

            t = 0
            while t <= size // 2:
                results.add(lt)
                results.add(bm)
                results.add(lb)
                results.add(tm)
                lt = (lt[0] - 1, lt[1] + 1)
                bm = (bm[0] - 1, bm[1] + 1)
                lb = (lb[0] + 1, lb[1] + 1)
                tm = (tm[0] + 1, tm[1] + 1)
                t += 1
            return results

        default_rhombus_coords = {size: get_default_coords(size)
                                  for size in range(3, min(n, m) + 1, 2)}

        def calc_rhombus(i, j, size):
            total = 0
            for r, c in default_rhombus_coords[size]:
                total += grid[i + r][j + c]
            return total


        for i in range(n):
            for j in range(m):
                # add individual cells
                results.add(grid[i][j])

                # determine larger sizes if they fit in the grid
                # for the current i, j
                for size in range(3, min(n, m) + 1, 2):
                    if i + size > n or j + size > m:
                        break
                    results.add(calc_rhombus(i, j, size))

        return sorted(list(results), reverse=True)[:3]