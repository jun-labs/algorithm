package boj.boj_20546

fun main() {
    val money = readln().toInt()
    val stocks = readln().split(" ")
        .map { it.toInt() }

    val jhAsset = bnp(stocks, money)
    val smAsset = timing(stocks, money)

    val answer = if (jhAsset > smAsset) "BNP" else if (smAsset > jhAsset) "TIMING" else "SAMESAME"
    println(answer)
}

fun bnp(
    prices: List<Int>,
    money: Int
): Int {
    var jhMoney = money
    var stocks = 0
    prices.forEach { price ->
        stocks += jhMoney / price
        jhMoney %= price
    }
    return jhMoney + stocks * prices.last()
}

fun timing(
    prices: List<Int>,
    money: Int
): Int {
    var smMoney = money
    var stocks = 0
    var upDays = 0
    var downDays = 0

    for (idx in 1 until prices.size) {
        if (prices[idx] > prices[idx - 1]) {
            upDays++
            downDays = 0
        } else if (prices[idx] < prices[idx - 1]) {
            downDays++
            upDays = 0
        } else {
            upDays = 0
            downDays = 0
        }

        if (upDays == 3 && stocks > 0) {
            smMoney += stocks * prices[idx]
            stocks = 0
        }
        if (downDays == 3 && smMoney >= prices[idx]) {
            stocks += smMoney / prices[idx]
            smMoney %= prices[idx]
        }
    }
    return smMoney + stocks * prices.last()
}
