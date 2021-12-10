fun main() {
    fun part1(input: List<Int>): Int {
        val pairs: List<List<Int>> = input.windowed(2)
        return pairs.count { (a, b) -> a < b }
    }

    fun part2(input: List<Int>): Int {
        val groups: List<List<Int>> = input.windowed(4)
        return groups.count { it[0] < it[3] }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInputAsInt("Day01_test")
    check(part1(testInput) == 7)
    check(part2(testInput) == 5)

    val input = readInputAsInt("Day01")
    println(part1(input))
    println(part2(input))
}
