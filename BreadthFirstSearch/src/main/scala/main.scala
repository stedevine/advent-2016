package advent
object Main {
  // Breadth First Search 
  type Vertex=Int
  type Graph=Map[Vertex,Set[Vertex]]

  def main(args: Array[String]): Unit = {
    val g:Graph=Map(1 ->Set(2,4), 2->Set(1,3), 3->Set(2,4), 4->Set(1,3))
    println(g)
    println(BFS(3,g))
  }

  def BFS(start: Vertex, g:Graph): List[List[Vertex]] = {
    val visited = Set(start)
    val result = Set(Set(start))

    def BFS0(elems: Set[Vertex], result: Set[Set[Vertex]], visited: Set[Vertex]):Set[Set[Vertex]] = {
      val newNeighbors = elems.flatMap(g(_)).filterNot(visited.contains).distinct
      println("newNeighbors " + newNeighbors)
      if (newNeighbors.isEmpty) result 
      else BFS0(newNeighbors, newNeighbors :: result, visited ++ newNeighbors)
    }

    BFS0(Set(start), result, visited)
  }

  def getAnswer(input: String): Int = {
    0
  }
}

