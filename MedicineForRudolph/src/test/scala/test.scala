import org.scalatest.FunSuite
import advent.Main

class Test extends FunSuite {
  test("sample input 1") {
    assert(Main.getNumberOfDistinctMolecules(
      "HOH",
      """H => HO
H => OH
O => HH"""
    ) == 4)
  }
}
