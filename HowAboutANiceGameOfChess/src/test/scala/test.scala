import org.scalatest.FunSuite
import advent.Main

class Test extends FunSuite {

  test("sample inputs") {
    assert(Main.getPassword("abc") == "18f47a30")
  }
}
