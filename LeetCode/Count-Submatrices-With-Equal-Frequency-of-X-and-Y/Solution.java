class Solution:
    def numberOfSubmatrices(self, grid: List[List[str]]) -> int:
        res = 0

        ROWS = len(grid)
        COLS = len(grid[0])

        for r in range(ROWS):
            for c in range(COLS):
                xCnt = yCnt = 0
                if grid[r][c] == 'X':
                    xCnt+=1
                elif grid[r][c] == 'Y':
                    yCnt+=1
                
                if r>0:
                    xCnt += grid[r-1][c][0]
                    yCnt += grid[r-1][c][1]
                if c>0:
                    xCnt += grid[r][c-1][0]
                    yCnt += grid[r][c-1][1]
                if r>0 and c>0:
                    xCnt -= grid[r-1][c-1][0]
                    yCnt -= grid[r-1][c-1][1]

                if xCnt>=1 and xCnt==yCnt:
                    res+=1
                
                grid[r][c] = (xCnt, yCnt)

        return res