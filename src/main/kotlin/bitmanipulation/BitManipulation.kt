package bitmanipulation

/**
 * N = 10 0000
 * M = 101
 * i = 2, j = 4
 *
 * ans = 110100
 */
fun bit_manipulations_5_1_insertions(N: Int, M: Int, i: Int, j: Int): Int {
    val width = j - i + 1
    val mask = (((1 shl width) - 1) shl i).inv()

    val ans = (N and mask) or (M shl i)
    return ans
}


fun bit_manipulations_5_3_flipToWin(num: Int): Int {
    var r = -1
    var l = 0
    var count = 0
    var zeros = 0
    var nextZeroIndex = -1

    var mask = 1
    var isCurrBitZero = true

    while (l < 32) {
        isCurrBitZero = (num and mask) == 0
        if (zeros == 0) {
            if (isCurrBitZero) {
                zeros = 1
                nextZeroIndex = l
            }
        } else {
            if (isCurrBitZero) {
                count = count.coerceAtLeast(l - r - 1)
                r = nextZeroIndex
                nextZeroIndex = l
            }
        }
        l++
        mask = mask shl 1
    }
    if (isCurrBitZero.not()) {
        count = count.coerceAtLeast(l - r - 1)
    }
    return count
}

fun bit_manipulations_5_4_nextNumber(num: Int): Int {
    TODO()
}


fun bit_manipulations_5_5_debugger(num: Int) {
    //if c & c-1  == 0 it means c =  1 << n
}


fun bit_manipulations_5_6_conversion(num1: Int, num2: Int): Int {
    var xored = num1 xor num2

    var count = 0
    while (xored != 0) {
        xored = xored and (xored - 1)
        count++
    }
    return count
}

fun bit_manipulations_5_7_pairwise_swap(num: Int): Int {
    val hexEven: Int = -0x55_55_55_56
    val hexOdd: Int = 0x55_55_55_55

    return ((num and hexEven) ushr 1) or ((num and hexEven) shl 1)
}

fun main() {
    //val ans2 = bit_manipulations_5_3_flipToWin(1775)
    println(Integer.toHexString(2147483647))
}