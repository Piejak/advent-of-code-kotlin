data class Instruction(val direction: String, val amount: Int)

fun main() {
  fun linesToInstructions(input: List<String>): List<Instruction> {
    return input.map {
      val (direction, amount) = it.split(" ")
      Instruction(direction, amount.toInt())
    }
  }

  fun part1(input: List<Instruction>): Int {
    var vertical = 0
    var horizontal = 0
    input.forEach {
      when (it.direction) {
        "up" -> vertical -= it.amount
        "down" -> vertical += it.amount
        "forward" -> horizontal += it.amount
      }
    }
    return vertical * horizontal
  }

  fun part2(input: List<Instruction>): Int {
    var vertical = 0
    var horizontal = 0
    var aim = 0
    input.forEach {
      when (it.direction) {
        "up" -> aim -= it.amount
        "down" -> aim += it.amount
        "forward" -> {
          horizontal += it.amount
          vertical += aim * it.amount
        }
      }
    }
    return vertical * horizontal
  }

  val testInput = readInput("Day02_test")
  val testInstructions = linesToInstructions(testInput)
  check(part1(testInstructions) == 150)
  check(part2(testInstructions) == 900)

  val input = readInput("Day02")
  val instructions = linesToInstructions(input)
  println(part1(instructions))
  println(part2(instructions))
}
