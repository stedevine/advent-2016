package advent
object Main {
  // Maze Of Twisty Little Cubicles
  def main(args: Array[String]): Unit = {

    //println("'moves' is path length -1")
    //println("shortest path for demo maze " + getShortestPath(getMaze(10, 6, 10), (1, 1), (7, 4)))
    println("shortest path for problem maze " + getShortestPath(getMaze(1352, 41, 41), (1, 1), (31, 39)))
    // How many unique locations can we reach starting from 1,1 and making no more than 50 moves (the total
    // path length can be no more than 51)
    println("number of locations covered " + getNumberOfLocations(getMaze(1352, 41, 41), (1, 1), 51))
  }

  type Maze = Array[Array[String]]
  type Position = (Int, Int)
  type Path = List[Position]

  def getNumberOfLocations(maze: Maze, start: Position, maxPathLength: Int): Int = {
    // get all paths that are maxPathLength or shorter
    var allPaths = List[Path]()

    def getAllPaths(path: Path, visited: Set[Position]): List[Path] = {
      if (path.size == maxPathLength) {
        allPaths = allPaths :+ path
      } else {
        val currentPosition = path.reverse.head
        val nextPositions = getNextPositions(maze, currentPosition).filter(!visited.contains(_))
        if (nextPositions.size == 0) {
          // no moves left, path is less than maxLength
          allPaths = allPaths :+ path
        } else {
          for (nextPosition <- nextPositions) {
            allPaths = getAllPaths(path :+ nextPosition, visited + currentPosition)
          }
        }

      }
      allPaths
    }

    val paths = getAllPaths(List[Position](start), Set[Position]())
    // debug number of times each element was reached in our path finding.
    //val pMap = paths.flatMap(a=>a)
    //println(pMap.map(b => (pMap.count(_ == b),b)).distinct.sorted.reverse)

    println("total paths less than or equal to " + maxPathLength + " " + paths.size)
    // For all the paths get the number of unique locations 
    paths.flatMap(a => a).distinct.size
  }

  def getShortestPath(maze: Maze, start: Position, goal: Position): Int = {
    var solutions = List[Path]()

    def getAllSolutions(path: Path, visited: Set[Position]): List[Path] = {
      val currentPosition = path.reverse.head
      if (currentPosition == goal) {
        solutions = solutions :+ path
      } else {
        for (nextPosition <- getNextPositions(maze, currentPosition).filter(!visited.contains(_))) {
          solutions = getAllSolutions(path :+ nextPosition, visited + currentPosition)
        }
      }
      solutions
    }

    val allSolutions = getAllSolutions(List[Position](start), Set[Position]())
    println("there are " + allSolutions.size + " paths from " + start + " to " + goal)
    val shortestPath = allSolutions.map(p => p.size).sorted.head
    shortestPath
  }

  def getNextPositions(maze: Maze, position: Position): List[Position] = {
    var nextPositions: List[(Int, Int)] = Nil
    val north = (position._1 - 1, position._2)
    val south = (position._1 + 1, position._2)
    val east = (position._1, position._2 + 1)
    val west = (position._1, position._2 - 1)

    if (isValid(maze, north)) { nextPositions = nextPositions :+ north }
    if (isValid(maze, south)) { nextPositions = nextPositions :+ south }
    if (isValid(maze, east)) { nextPositions = nextPositions :+ east }
    if (isValid(maze, west)) { nextPositions = nextPositions :+ west }

    nextPositions
  }

  def isValid(maze: Maze, position: Position): Boolean = {
    (position._2 >= 0 && position._2 < maze.size && position._1 >= 0 && position._1 < maze(position._2).size && maze(position._2)(position._1) == ".")
  }

  def getMaze(seed: Int, xSize: Int, ySize: Int): Maze = {
    var maze = Array.tabulate(xSize, ySize)((x, y) => "x")
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

  def printMaze(maze: Maze): Unit = {
    for (y <- Range(0, maze.size)) {
      for (x <- Range(0, maze(y).size)) {
        print(maze(y)(x))
      }
      println
    }
  }
}
