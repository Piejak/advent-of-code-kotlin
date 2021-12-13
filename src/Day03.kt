fun main() {
  fun part1(input: List<String>): Int {
    val counts = mutableMapOf<Int, Map<Char, Int>>()
    input.forEach {
      for (i in it.indices) {
        val count = counts.getOrDefault(i, mapOf()).toMutableMap()
        count[it[i]] = count.getOrDefault(it[i], 0) + 1
        counts[i] = count
      }
    }
    var out = ""
    var other = ""
    counts.forEach {
      (_, u) -> run {
        if (u['0']!! > u['1']!!) {
          out += "0"
          other += "1"
        } else {
          out += "1"
          other += "0"
        }
      }
    }
    return out.toInt(2) * other.toInt(2)
  }

  fun splitLists(list: List<String>, bit: Int): List<List<String>> {
    val ones = mutableListOf<String>()
    val zeros = mutableListOf<String>()
    list.stream().forEach {
      if (it[bit] == '0') {
        zeros.add(it)
      } else {
        ones.add(it)
      }
    }
    return if (zeros.size > ones.size) {
      listOf(zeros, ones)
    } else {
      listOf(ones, zeros)
    }
  }

  fun part2(input: List<String>): Int {
    var bit = 0
    val filtered = splitLists(input, 0)
    var more = filtered[0]
    var less = filtered[1]
    bit += 1
    while (bit < input[0].length && (more.size > 1 || less.size > 1)) {
      if (more.size > 1) {
        more = splitLists(more, bit)[0]
      }
      if (less.size > 1) {
        less = splitLists(less, bit)[1]
      }
      bit += 1
    }
    return more[0].toInt(2) * less[0].toInt(2)
  }


  val testInput = readInput("Day03_test")
  check(part1(testInput) == 198)
  check(part2(testInput) == 230)

  val input = readInput("Day03")
  println(part1(input))
  println(part2(input))
}
