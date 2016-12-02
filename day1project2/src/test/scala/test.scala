import org.scalatest.FunSuite
import advent.Main

class Test extends FunSuite {
  test("sample input 1") {
    assert(Main.getDistanceToFirstLocationVisitedTwice("R8, R4, R4, R8") == 4)
  }

}
