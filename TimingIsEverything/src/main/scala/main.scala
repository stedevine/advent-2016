package advent
object Main {
  // Timing Is Everything
  def main(args: Array[String]): Unit = {
    println(getPartOneAnswer)
  }

  def getPartOneAnswer(): Int = {
    var t = -1
    var result = -1
    while (result != 0) {
      t += 1
      result = (
        // Each entry represents a disc at some starting position with a specific number of slots
        ((5 + (t + 1)) % 17)
        + ((8 + (t + 2)) % 19)
        + ((1 + (t + 3)) % 7)
        + ((7 + (t + 4)) % 13)
        + ((1 + (t + 5)) % 5)
        + ((0 + (t + 6)) % 3)
      // + ((0 + (t + 7)) % 11) [part 2]
      )
    }

    t
  }
}
