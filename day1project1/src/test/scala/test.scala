import org.scalatest.FunSuite
import advent.Main

class Test extends FunSuite {
  test("sample input 1") {
    assert(Main.getShortestPath("R2, L3") == 5)
  }
  test("sample input 2") {
    assert(Main.getShortestPath("R2, R2, R2") == 2)
  }
  test("sample input 3") {
    assert(Main.getShortestPath("R5, L5, R5, R3") == 12)
  }
}
