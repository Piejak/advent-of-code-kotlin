fun main() {
    fun part1(input: List<String>): Int {
        var count = 0
        var prev = input[0].toInt()
        for (i in input) {
            val current = i.toInt()
            if (current > prev) {
                count++
            }
            prev = current
        }
        return count
    }

    fun part2(input: List<String>): Int {
        var count = 0
        var prev = input[0].toInt()
        for (i in input.indices) {
            if (i > 2) {
                val current = input[i].toInt()
                if (current > prev) {
                    count++
                }
                prev = input[i - 2].toInt()
            }
        }
        return count
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 7)
    check(part2(testInput) == 5)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
