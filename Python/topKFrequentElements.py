class Solution:
    def topKFrequent(self, nums: list[int], k: int) -> list[int]:
        freq_map = {}
        for num in nums:
            freq_map[num] = freq_map.get(num, 0) + 1

        min_heap = []
        for num, freq in freq_map.items():
            heappush(min_heap, (freq, num))
            if len(min_heap) > k:
                heappop(min_heap)

        result = []
        while min_heap:
            result.append(heappop(min_heap)[1])

        return result
