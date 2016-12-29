package advent
import java.security.MessageDigest

object Main {
  // TwoStepsForward
  type Position = (Int, Int)

  def main(args: Array[String]): Unit = {
    println(getShortestPath("pxxbnzuo"))
    println(getLengthOfLongestPath("pxxbnzuo"))
  }

  def getShortestPath(input: String): String = {
    getSolutions(input).map(a => (a.size, a)).sorted.head._2
  }

  def getLengthOfLongestPath(input: String): Int = {
    getSolutions(input).map(a => (a.size, a)).sorted.reverse.head._1
  }

  def getSolutions(input: String): List[String] = {
    // recursively search the 'maze' for solutions, return the shortest one
    var solutions = List[String]()

    def getAllSolutions(currentPosition: Position, path: String): List[String] = {

      // base case - we've reached the end of the maze
      if (currentPosition == (3, 3)) {
        solutions = solutions :+ path
      } else {
        // where can we go now?
        val directions = getDirections(input + path, currentPosition)
        for (direction <- directions) {
          solutions = getAllSolutions(getNextPosition(direction, currentPosition), path + direction)
        }

      }
      solutions
    }

    getAllSolutions((0, 0), "")
  }

  def getNextPosition(direction: Char, position: Position): Position = {
    direction match {
      case 'U' => (position._1, position._2 - 1)
      case 'D' => (position._1, position._2 + 1)
      case 'L' => (position._1 - 1, position._2)
      case 'R' => (position._1 + 1, position._2)
    }
  }

  def getDirections(input: String, position: Position): String = {
    var result = ""
    // The characters in the first four positions of the hash represent the locked/unlocked state 
    // of the door that is up, down, left and right (respectively) from the current position
    var hash = md5(input)
    if ("bcdef".contains(hash(0)) && position._2 > 0) { result += "U" }
    if ("bcdef".contains(hash(1)) && position._2 < 3) { result += "D" }
    if ("bcdef".contains(hash(2)) && position._1 > 0) { result += "L" }
    if ("bcdef".contains(hash(3)) && position._1 < 3) { result += "R" }

    result
  }

  def md5(s: String): String = {
    MessageDigest.getInstance("MD5").digest(s.getBytes).map("%02x".format(_)).mkString
  }

}
