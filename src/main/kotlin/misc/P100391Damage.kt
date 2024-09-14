package misc

import java.util.*

class P100391Damage {
    fun minDamage(power: Int, damage: IntArray, health: IntArray): Long {
        val stack = Stack<Long>()
        stack.push(Long.MAX_VALUE)
        for (index in damage.indices) {
            solve(index, power, damage, health, stack, 0)
        }
        return stack.pop()
    }

    fun solve(currIndex: Int, power: Int, damage: IntArray, health: IntArray, s: Stack<Long>, currDamage: Long) {
        if (currDamage > s.peek()) return
        var extraDamage = 0L
        damage.forEachIndexed { index, item ->
            if (health[index] > 0) {
                extraDamage += item
            }
        }
        health[currIndex] -= power
        val allDead = health.all { it <= 0 }
        if (allDead) {
            s.pop()
            s.push(currDamage)
            health[currIndex] += power
            return
        }
        for (i in health.indices) {
            if (health[i] > 0) {
                solve(i, power, damage, health, s, currDamage + extraDamage)
            }
        }
        health[currIndex] += power
    }
}



fun main() {
    val power = 1
    val damage = intArrayOf(1, 1, 1, 1)
    val health = intArrayOf(1, 2, 3, 4)

    val ans = P100391Damage().minDamage(power, damage, health)
    println(ans)
}
