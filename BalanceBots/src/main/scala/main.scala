package advent
object Main {
  // Blank
  def main(args: Array[String]): Unit = {
    val nodes = Map[String, Node]()
    println(getAnswer(Input.problem))
  }

  def ProcessInput(input: String): Node = {
    val node: Node = null
    if (input.startsWith("bot")) {

    }
    node
  }

  def getAnswer(input: String): Int = {
    0
  }

  class Node(lowKey: String, highKey: String) {
    var values = Array[Int]()

    def setValue(v: Int): Unit = {
      values = values :+ v
    }

    def canProceed(): Boolean = {
      values.size == 2
    }

    def getLow(): (String, Int) = {
      (lowKey, Math.min(values(0), values(1)))
    }
    def getHigh(): (String, Int) = {
      (highKey, Math.max(values(0), values(1)))
    }
  }
}

