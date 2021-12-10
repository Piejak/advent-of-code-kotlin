fun main() {
    fun part1(input: List<Int>): Int {
        var count = 0
        var prev = input[0]
        for (current in input) {
            if (current > prev) {
                count++
            }
            prev = current
        }
        return count
    }

    fun part2(input: List<Int>): Int {
        var count = 0
        var prev = input[0]
        for (i in input.indices) {
            if (i > 2) {
                val current = input[i]
                if (current > prev) {
                    count++
                }
                prev = input[i - 2]
            }
        }
        return count
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInputAsInt("Day01_test")
    check(part1(testInput) == 7)
    check(part2(testInput) == 5)

    val input = readInputAsInt("Day01")
    println(part1(input))
    println(part2(input))
}
