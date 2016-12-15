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

    0
  }

  def getPath(startState: Vector[Int], endState: Vector[Int], previousStates: List[Vector[Int]]): List[Vector[Int]] = {
    var pathLength = 0
    println("state " + startState + " with previous " + previousStates)
    // base case - we're at the end state
    if (startState == endState) {
      pathLength = 0
    } else {
      // given where we are, get a list of states to move to next, remove any states we've previously tried
      val nextStates = getNextStates(startState).filter(!previousStates.contains(_))
      if (nextStates.size == 0) {
        // can't get there from here
      }
      val newPreviousStates = previousStates :+ startState
      for (nextState <- nextStates) {
        pathLength += getPathLength(nextState, endState, newPreviousStates)
      }
    }

    pathLength
  }

  def solve(startState: Vector[Int], endState: Vector[Int], previousStates: List[Vector[Int]], solution: List[Vector[Int]]) : (Boolean, List[Vector[Int]]) = {
    var result = (false, new List[Vector[Int]]())
    if (startState == endState) {
        result = (true, solution)
    } else {
      val nextStates = getNextStates(startState).filter(!previousStates.contains(_))
      if (nextStates.size == 0) {
        result = (false, solution :- startState)
      }
      val newPreviousStates = previousStates :+ startState
      if ()
    }

    result
  }

  def getNextStates(startState: Vector[Int]): List[Vector[Int]] = {
    var nextStates = List[Vector[Int]]()

    for (move <- getNextMoves(startState)) {
      var state: Vector[Int] = null
      if (startState(2) == 1) {
        state = Vector(startState(0) - move(0), startState(1) - move(1), startState(2) - move(2))
      } else {
        state = Vector(startState(0) + move(0), startState(1) + move(1), startState(2) + move(2))
      }

      if (state(0) >= state(1)) {
        nextStates = nextStates :+ state
      }
    }
    nextStates
  }

  private def getNextMoves(startState: Vector[Int]): List[Vector[Int]] = {
    var moves = List[Vector[Int]]()
    // Express the move as a vector (Missionaries, Cannibals, Boat)
    if (startState(2) == 1) {
      // we're going left to right
      for (m <- Range(0, startState(0) + 1)) {
        for (c <- Range(0, startState(1) + 1)) {
          val v = Vector(m, c, startState(2))
          // must be one or two people in the boat
          if (v(0) + v(1) <= 2 && v(0) + v(1) >= 1) {
            moves = moves :+ v
          }

        }
      }
    } else {
      // we're going right to left
      for (m <- Range(0, 4 - startState(0))) {
        for (c <- Range(0, 4 - startState(1))) {
          val v = Vector(m, c, 1)
          // must be one or two people in the boat
          if (v(0) + v(1) <= 2 && v(0) + v(1) >= 1) {
            moves = moves :+ v
          }

        }
      }
    }

    moves
  }

}
