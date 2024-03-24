package programmers.혼자서_하는_틱택토

class Solution {
    companion object {
        private const val SIZE = 3
    }

    private val map: Array<Array<Char>> = Array(SIZE) { Array(SIZE) { '.' } }

    fun solution(board: Array<String>): Int {
        var o = 0
        var x = 0

        for (row in board.indices) {
            for (column in 0 until board[0].length) {
                map[row][column] = board[row][column]
                if (map[row][column] == 'O') {
                    o++
                } else if (map[row][column] == 'X') {
                    x++
                }
            }
        }

        val resultO = playGame('O')
        val resultX = playGame('X')

        if (resultO && resultX) return 0
        if (resultO) return if (o == x + 1) 1 else 0
        if (resultX) return if (o == x) 1 else 0
        return if ((o == x) || (o == x + 1)) 1 else 0
    }

    private fun playGame(symbol: Char): Boolean {
        for (idx in 0 until 3) {
            val rowCheck = checkRows(idx, symbol)
            val columnCheck = checkColumns(idx, symbol)
            if (rowCheck || columnCheck) {
                return true
            }
        }
        return checkDiagonal(symbol)
    }

    private fun checkDiagonal(symbol: Char): Boolean {
        var leftDownDiagonal = true
        var rightDownDiagonal = true
        for (idx in 0 until 3) {
            if (map[idx][idx] != symbol) {
                rightDownDiagonal = false
            }
            if (map[idx][3 - idx - 1] != symbol) {
                leftDownDiagonal = false
            }
        }
        return leftDownDiagonal || rightDownDiagonal
    }

    private fun checkColumns(
        row: Int,
        symbol: Char
    ): Boolean {
        for (column in 0 until 3) {
            if (map[row][column] != symbol) {
                return false
            }
        }
        return true
    }

    private fun checkRows(
        column: Int,
        symbol: Char
    ): Boolean {
        for (row in 0 until 3) {
            if (map[row][column] != symbol) {
                return false
            }
        }
        return true
    }
}
