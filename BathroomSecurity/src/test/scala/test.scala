import org.scalatest.FunSuite
import advent.Main

class Test extends FunSuite {
  test("sample input") {
    assert(Main.getCode("""ULL
RRDDD
LURDL
UUUUD""") == "1985")

  }
}
