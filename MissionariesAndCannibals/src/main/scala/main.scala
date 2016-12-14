package advent
object Main {
  // Missionaries and Cannibals
  // Not part of Advent of code
  // https://en.wikipedia.org/wiki/Missionaries_and_cannibals_problem

  def main(args: Array[String]): Unit = {
    println(getAnswer)
  }

  def getAnswer: Int = {
    // given a starting position "the Missionaries, the Cannibals and the boat are on the left side of the river"
    // what's the minimum number of legal moves to get eveyone to the right side of the river.

    // express starting position like this:
    val start = Vector(1, 1, 0)
    getNextMoves(start)
    0
  }

  def getNextMoves(input: Vector[Int]): List[Vector[Int]] = {
    var moves = List[Vector[Int]]()
    // Express the move as a vector (Missionaries, Cannibals, Boat)
    if (input(2) == 1) {
      // we're going left to right
      for (m <- Range(0, input(0) + 1)) {
        for (c <- Range(0, input(1) + 1)) {
          val v = Vector(m, c, input(2))
          // must be one or two people in the boat
          if (v(0) + v(1) <= 2 && v(0) + v(1) >= 1) {
            println(v)
            moves = moves :+ v
          }

        }
      }
    } else {
      // we're going right to left
      for (m <- Range(0, 4 - input(0))) {
        for (c <- Range(0, 4 - input(1))) {
          val v = Vector(m, c, 1)
          // must be one or two people in the boat
          if (v(0) + v(1) <= 2 && v(0) + v(1) >= 1) {
            println(v)
            moves = moves :+ v
          }

        }
      }
    }

    moves
  }

  /*
  def isMoveLegal(input: Vector[Int], move: Vector[Int]): Boolean = {
    var state = Vector[Int]()
    if (input(2) == 1) {
      state = input - move
    } else {
      state = input + move
    }

    false
  }
  */
}
