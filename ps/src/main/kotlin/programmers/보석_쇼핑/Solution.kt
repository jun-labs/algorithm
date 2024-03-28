package programmers.보석_쇼핑

/**
 * 종료조건 잘 확인.
 * gems = ["D", "A", "B", "A", "C", "A", "D"]
 * */
class Solution {
    private val gemMap = mutableMapOf<String, Int>()
    fun solution(gems: Array<String>): IntArray {
        val totalCount = gems.toSet()
            .count()

        var start = 0
        var end = 0

        var left = 0
        var right = 0
        var distance = Int.MAX_VALUE - 100_000

        while (true) {
            if (gemMap.size >= totalCount) {
                val gem = gems[left]
                gemMap[gem] = gemMap.getOrDefault(gem, 0) - 1
                if (gemMap[gem]!! <= 0) {
                    gemMap.remove(gem)
                }
                left++
            } else if (right == gems.size) {
                break
            } else {
                val gem = gems[right]
                gemMap[gem] = gemMap.getOrDefault(gem, 0) + 1
                right++
            }
            if (gemMap.size == totalCount) {
                if (distance > (right - left)) {
                    start = left + 1
                    end = right
                    distance = right - left
                }
            }
        }
        return intArrayOf(start, end)
    }
}
