1SELECT w1.id
2FROM Weather w1, Weather w2
3WHERE DATEDIFF(w1.recordDate, w2.recordDate) = 1
4AND w1.temperature > w2.temperature;