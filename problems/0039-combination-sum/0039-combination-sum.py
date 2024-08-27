from typing import List


class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        result = []

        def backtrack(remain: int, comb: List[int], start: int):
            if remain == 0:
                result.append(list(comb))
                return
            elif remain < 0:
                return
            for i in range(start, len(candidates)):
                comb.append(candidates[i])
                backtrack(remain - candidates[i], comb, i)
                comb.pop()

        backtrack(target, [], 0)

        return result