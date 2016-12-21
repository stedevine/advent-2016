package advent
object Main {
  // Blank
  def main(args: Array[String]): Unit = {
    //drawMaze(1352)
    //drawMaze(10)
    //printMaze(getMaze(10))
    //println(getAnswer(Input.problem))
    //println(getNextPositions(getMaze(10), (6, 5)))
    //println(walkMaze(getMaze(10), List[(Int,Int)]((1, 1)), (7, 4), List[(Int, Int)](), List[List[(Int, Int)]]()))
    println(solveMaze2(getMaze(1352), List[(Int, Int)]((1, 1)), (31, 39), List[(Int, Int)]()))
  }

  def getAnswer(input: String): Int = {
    0
  }

  def solveMaze2(maze: Array[Array[String]], path: List[(Int, Int)], goal: (Int, Int), visited: List[(Int, Int)]): Int = {
    var steps = 0
    //maze(position._2)(position._1) = "O"
    //println()
    //printMaze(maze)
    //println(path)
    val position = path.reverse.head
    if (position == goal) {
      println("solved")
      println(path)
      println("moves + " + (path.size - 1))
    } else {

      for (nextPosition <- getNextPositions(maze, position).filter(!visited.contains(_))) {

        steps = 1 + solveMaze2(maze, path :+ nextPosition, goal, visited :+ position)
      }
    }
    steps
  }

  def solveMaze(maze: Array[Array[String]], position: (Int, Int), goal: (Int, Int), visited: List[(Int, Int)]): Int = {
    var steps = 0
    maze(position._2)(position._1) = "O"
    println()
    printMaze(maze)
    if (position == goal) {
      println("solved")
    } else {

      for (nextPosition <- getNextPositions(maze, position).filter(!visited.contains(_))) {

        steps = 1 + solveMaze(maze, nextPosition, goal, visited :+ position)
      }
    }
    steps
  }

  def walkMaze(maze: Array[Array[String]], path: List[(Int, Int)], goal: (Int, Int), visited: List[(Int, Int)], knownSolutions: List[List[(Int, Int)]]): List[List[(Int, Int)]] = {
    var solutions = knownSolutions
    var currentPosition = path.reverse.head
    if (currentPosition == goal) {
      solutions = solutions :+ path
      println("found " + solutions.size + " solutions")
    } else {
      val nextPositions = getNextPositions(maze: Array[Array[String]], currentPosition)
      if (nextPositions.size != 0) {
        //val newPath = path :+ currentPosition
        val newVisited = visited :+ currentPosition
        for (nextPosition <- nextPositions) {
          solutions = walkMaze(maze, path :+ nextPosition, goal, newVisited, solutions)
        }
      }
    }
    solutions

  }

  def getNextPositions(maze: Array[Array[String]], position: (Int, Int)): List[(Int, Int)] = {
    var nextPositions: List[(Int, Int)] = Nil
    val north = (position._1 - 1, position._2)
    // println("north " + north)
    val south = (position._1 + 1, position._2)
    //println("south " + south)
    val east = (position._1, position._2 + 1)
    //println("east " + east)
    val west = (position._1, position._2 - 1)
    //println("west " + west)

    if (isValid(maze, north)) { nextPositions = nextPositions :+ north }
    if (isValid(maze, south)) { nextPositions = nextPositions :+ south }
    if (isValid(maze, east)) { nextPositions = nextPositions :+ east }
    if (isValid(maze, west)) { nextPositions = nextPositions :+ west }

    nextPositions
  }

  def isValid(maze: Array[Array[String]], position: (Int, Int)): Boolean = {
    //println(maze.size, maze(position._2).size)
    //println(position._2 >= 0)
    //println(position._2 < maze.size)
    //println(position._1 >= 0)
    //println(position._1 < maze(position._2).size)
    //println(maze(position._2)(position._1))
    //println(position) 
    (position._2 >= 0 && position._2 < maze.size && position._1 >= 0 && position._1 < maze(position._2).size && maze(position._2)(position._1) == ".")
  }

  def getMaze(seed: Int): Array[Array[String]] = {
    var maze = Array.tabulate(41, 41)((x, y) => "x")
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
