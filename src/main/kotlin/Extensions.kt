fun Array<IntArray>.print() {
    this.forEach { row ->
        print("[")
        for (j in row) {
            print(" $j")
        }
        println(" ]")
    }
}