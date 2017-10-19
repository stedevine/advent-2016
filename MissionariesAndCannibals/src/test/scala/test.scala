import org.scalatest.FunSuite
import advent.Main

class Test extends FunSuite {

  test("check first next states") {
    val startPosition = Vector(3, 3, 1)
    val expectedLegalStates = List(
      Vector(3, 2, 0),
      Vector(3, 1, 0),
      Vector(2, 2, 0))
    checkNextState(startPosition: Vector[Int], expectedLegalStates: List[Vector[Int]])
  }
  test("check first second next state") {
    val startPosition = Vector(3, 2, 0)
    val expectedLegalStates = List(
      Vector(3, 3, 1))
    checkNextState(startPosition: Vector[Int], expectedLegalStates: List[Vector[Int]])
  }
  test("check second  second next state") {
    val startPosition = Vector(3, 1, 0)
    val expectedLegalStates = List(
      Vector(3, 2, 1),
      Vector(3, 3, 1))
    checkNextState(startPosition: Vector[Int], expectedLegalStates: List[Vector[Int]])
  }

  test("check third second next state") {
    val startPosition = Vector(2, 2, 0)
    val expectedLegalStates = List(
      Vector(3, 2, 1),
      Vector(3, 3, 1))
    checkNextState(startPosition: Vector[Int], expectedLegalStates: List[Vector[Int]])
  }

  def checkNextState(startPosition: Vector[Int], expectedLegalStates: List[Vector[Int]]): Unit = {
    var legalStates = Main.getNextStates(startPosition)
    assert(legalStates.size == expectedLegalStates.size)
    for (expectedLegalState <- expectedLegalStates) {
      assert(legalStates.contains(expectedLegalState))
    }
  }

  test("test recursive") {
    val startPosition = Vector(3, 3, 1)
    val endPosition = Vector(0, 0, 0)
    val allSolutions = Main.solve(List(startPosition), endPosition, List[Vector[Int]](), List[List[Vector[Int]]]())
    println(allSolutions.size)

  }

}
