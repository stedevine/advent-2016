package advent
object Main {
  // Blank
  def main(args: Array[String]): Unit = {
    //drawMaze(1352)
    //drawMaze(10)
    printMaze(getMaze(10))
    //println(getAnswer(Input.problem))
  }

  def getAnswer(input: String): Int = {
    0
  }

  def solveMaze(maze: Array[Array[String]], position: (Int, Int), goal: (Int, Int)): Unit = {
    // BFS?

  }

  def getMaze(seed: Int): Array[Array[String]] = {
    var maze = Array.tabulate(7, 10)((x, y) => "x")
    for (y <- Range(0, maze.size)) {
      for (x <- Range(0, maze(y).size)) {
        val isOpen = Integer.bitCount(seed + (x * x) + (3 * x) + (2 * x * y) + y + (y * y)) % 2 == 0
        if (isOpen) {
          maze(y)(x) = "."
        } else {
          maze(y)(x) = "#"
        }
      }
    }
    maze
  }

  def printMaze(maze: Array[Array[String]]): Unit = {
    for (y <- Range(0, maze.size)) {
      for (x <- Range(0, maze(y).size)) {
        print(maze(y)(x))
      }
      println
    }
  }
}
