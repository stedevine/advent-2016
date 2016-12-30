import org.scalatest.FunSuite
import advent.Main

class Test extends FunSuite {

  test("get directions") {
    assert(Main.getDirections("hijkl", (0, 0)) == "D")
    assert(Main.getDirections("hijkl", (0, 1)) == "UD")
    assert(Main.getDirections("hijkl", (1, 1)) == "UDL")
    assert(Main.getDirections("hijkl", (1, 3)) == "UL")
  }

  test("test input") {
    assert(Main.getShortestPath("ihgpwlah") == "DDRRRD")
    assert(Main.getShortestPath("kglvqrro") == "DDUDRLRRUDRD")
    assert(Main.getShortestPath("ulqzkmiv") == "DRURDRUDDLLDLUURRDULRLDUUDDDRR")
    assert(Main.getLengthOfLongestPath("ihgpwlah") == 370)
    assert(Main.getLengthOfLongestPath("kglvqrro") == 492)
    assert(Main.getLengthOfLongestPath("ulqzkmiv") == 830)
  }
}

