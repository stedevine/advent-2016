import org.scalatest.FunSuite
import advent.Main

class Test extends FunSuite {

  test("check the first move") {
    val startPosition = Vector(3, 3, 1)
    val expectedMoves = List(
      Vector(0, 1, 1),
      Vector(1, 0, 1),
      Vector(1, 1, 1),
      Vector(2, 0, 1),
      Vector(0, 2, 1)
    )
    val expectedLegalMoves = List(
      Vector(0, 1, 1),
      Vector(1, 1, 1),
      Vector(0, 2, 1)
    )

    checkPositions(startPosition, expectedMoves, expectedLegalMoves)
  }

  test("check one of the second moves") {
    val startPosition = Vector(2, 2, 0)
    val expectedMoves = List(
      Vector(0, 1, 1),
      Vector(1, 1, 1),
      Vector(1, 0, 1)
    )
    val expectedLegalMoves = List(
      Vector(1, 0, 1),
      Vector(1, 1, 1)
    )

    checkPositions(startPosition, expectedMoves, expectedLegalMoves)
  }

  def checkPositions(startPosition: Vector[Int], expectedMoves: List[Vector[Int]], expectedLegalMoves: List[Vector[Int]]) = {
    val nextMoves = Main.getNextMoves(startPosition)
    assert(nextMoves.size == expectedMoves.size)
    for (expectedMove <- expectedMoves) {
      assert(nextMoves.contains(expectedMove))
    }

    val legalMoves = nextMoves.filter(Main.isMoveLegal(startPosition, _)._2)
    assert(legalMoves.size == expectedLegalMoves.size)
    for (expectedLegalMove <- expectedLegalMoves) {
      assert(legalMoves.contains(expectedLegalMove))
    }
  }

}
