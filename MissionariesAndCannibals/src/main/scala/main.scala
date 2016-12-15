package advent
object Main {
  // Missionaries and Cannibals
  // Not part of Advent of code
  // https://en.wikipedia.org/wiki/Missionaries_and_cannibals_problem

  def main(args: Array[String]): Unit = {
    println("The smallest number of moves to get across the river is : " + getAnswer)
  }

  def getAnswer: Int = {
    // given a starting position "the Missionaries, the Cannibals and the boat are on the left side of the river"
    // what's the minimum number of legal moves to get eveyone to the right side of the river.

    // express starting position like this:
    val startPosition = Vector(3, 3, 1)
    val endPosition = Vector(0, 0, 0)
    val allSolutions = Main.solve(List(startPosition), endPosition, List[Vector[Int]](), List[List[Vector[Int]]]())

    allSolutions.map(item => item.size).sorted.head
  }

  def solve(states: List[Vector[Int]], goal: Vector[Int], visited: List[Vector[Int]], knownSolutions: List[List[Vector[Int]]]): List[List[Vector[Int]]] = {
    var solutions = knownSolutions
    var currentState = states.reverse.head
    if (currentState == goal) {
      val solution = states :+ currentState
      //println(solution)
      //println(solution.size)
      solutions = solutions :+ solution
    } else {
      // given where we are, get a list of states to move to next, remove any states we've previously tried
      val nextStates = getNextStates(currentState).filter(!visited.contains(_))
      if (nextStates.size == 0) {
        // can't get there from here

      } else {
        val newVisited = visited :+ currentState

        for (nextState <- nextStates) {
          solutions = solve(states :+ nextState, goal, newVisited, solutions)
        }
      }
    }

    solutions
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
