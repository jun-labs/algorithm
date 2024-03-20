package programmers.혼자서_하는_틱택토

class Solution {
    companion object {
        private const val SIZE = 3
    }

    private val map: Array<Array<Char>> = Array(SIZE) { Array(SIZE) { '.' } }

    fun solution(board: Array<String>): Int {
        var countO = 0
        var countX = 0

        for (x in 0 until 3) {
            for (y in 0 until 3) {
                map[x][y] = board[x][y]
                if (map[x][y] == 'O') {
                    countO++
                } else if (map[x][y] == 'X') {
                    countX++
                }
            }
        }

        val winO = isWin('O')
        val winX = isWin('X')

        if (winO && winX) return 0
        if (winO) return if (countO == countX + 1) 1 else 0
        if (winX) return if (countO == countX) 1 else 0
        return if ((countO == countX) || (countO == countX + 1)) 1 else 0
    }

    private fun isWin(
        symbol: Char
    ): Boolean {
        for (idx in 0 until SIZE) {
            if (checkRow(idx, symbol) || checkColumn(idx, symbol)) {
                return true
            }
        }
        return checkDiagonal(symbol)
    }

    private fun checkRow(
        column: Int,
        symbol: Char
    ): Boolean {
        for (row in 0 until SIZE) {
            if (map[row][column] != symbol) {
                return false
            }
        }
        return true
    }

    private fun checkColumn(
        row: Int,
        symbol: Char
    ): Boolean {
        for (column in 0 until SIZE) {
            if (map[row][column] != symbol) {
                return false
            }
        }
        return true
    }

    private fun checkDiagonal(symbol: Char): Boolean {
        var diagonalA = true
        var diagonalB = true
        for (idx in 0 until SIZE) {
            if (map[idx][idx] != symbol) {
                diagonalA = false
            }
            if (map[idx][SIZE - idx - 1] != symbol) {
                diagonalB = false
            }
        }
        return diagonalA || diagonalB
    }
}
