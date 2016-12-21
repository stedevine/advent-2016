package advent
object Main {
  // Maze Of Twisty Little Cubicals
  def main(args: Array[String]): Unit = {

    println("'moves' is path length -1")
    println("shortest path for demo maze " + getShortestPath(getMaze(10, 6, 10), (1, 1), (7, 4)))
    println("shortest path for problem maze " + getShortestPath(getMaze(1352, 41, 41), (1, 1), (31, 39)))
  }

  type Maze = Array[Array[String]]
  type Position = (Int, Int)
  type Path = List[Position]

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
    println("there are " + allSolutions.size + "solutions")
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
