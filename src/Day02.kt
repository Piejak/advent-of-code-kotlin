fun main() {
  fun part1(input: List<String>): Int {
    var vertical = 0
    var horizontal = 0
    input.forEach {
      var modifier = 1
      val row = it.split(" ")
      val amount = row[1].toInt()
      if (row[0] in setOf("up")) {
        modifier = -1
      }
      if (row[0] in setOf("up", "down")) {
        vertical += modifier * amount
      } else {
        horizontal += modifier * amount
      }
    }
    return vertical * horizontal
  }

  fun part2(input: List<String>): Int {
    var vertical = 0
    var horizontal = 0
    var aim = 0
    input.forEach {
      var modifier = 1
      val row = it.split(" ")
      val amount = row[1].toInt()
      if (row[0] in setOf("up")) {
        modifier = -1
      }
      if (row[0] in setOf("up", "down")) {
        aim += modifier * amount
      } else {
        horizontal += modifier * amount
        vertical += aim * amount
      }
    }
    return vertical * horizontal
  }

  val testInput = readInput("Day02_test")
  check(part1(testInput) == 150)
  check(part2(testInput) == 900)

  val input = readInput("Day02")
  println(part1(input))
  println(part2(input))
}
