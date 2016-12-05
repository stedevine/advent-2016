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

  test("break up molecule") {
    val molecule = "LiHCaCKArB"
    var elements = Main.getElements(molecule)
    assert(elements.size == 7)
  }
}
