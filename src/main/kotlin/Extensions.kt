fun Array<IntArray>.print() {
    this.forEach { row ->
        print("[")
        for (j in row) {
            print(" $j")
        }
        println(" ]")
    }
}

fun <T> Array<T>.prettyPrint() {
    if (this.size == 1) {
        println("[${this[0]}]")
        return
    }
    this.forEachIndexed { index, item ->
        if (index == 0) print("[$item")
        else if (index == this.size - 1) print(", $item]")
        else {
            print(", $item")
        }
    }
    println()
}

fun IntArray.prettyPrint() {
    if (this.size == 1) {
        println("[${this[0]}]")
        return
    }
    this.forEachIndexed { index, item ->
        if (index == 0) print("[$item")
        else if (index == this.size - 1) print(", $item]")
        else {
            print(", $item")
        }
    }
    println()
}


fun <T> List<T>.prettyPrint() {
    if (this.size == 1) {
        println("[${this[0]}]")
        return
    }
    this.forEachIndexed { index, item ->
        if (index == 0) print("[$item")
        else if (index == this.size - 1) print(", $item]")
        else {
            print(", $item")
        }
    }
    println()
}
