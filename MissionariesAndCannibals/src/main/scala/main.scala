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
    var position = Vector(3, 3, 1)
    println("for position " + position)
    for (move <- getNextMoves(position)) {
      val (state, isLegal) = isMoveLegal(position, move)
      println(move + " to state " + state + " " + isLegal)
      if (isLegal) {
        for (nMove <- getNextMoves(state)) {
          val (nstate, nisLegal) = isMoveLegal(state, nMove)
          println(nMove + " to state " + nstate + " " + nisLegal)
        }
      }
    }

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
            //println(v)
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

  def isMoveLegal(input: Vector[Int], move: Vector[Int]): (Vector[Int], Boolean) = {

    var state: Vector[Int] = null
    if (input(2) == 1) {
      state = Vector(input(0) - move(0), input(1) - move(1), input(2) - move(2))
    } else {
      state = Vector(input(0) + move(0), input(1) + move(1), input(2) + move(2))
    }

    // there cannot be more cannibals than missionaries
    (state, (state(0) >= state(1)))
  }

}
