import org.scalatest.FunSuite
import org.scalatest.BeforeAndAfter
import advent.Main

class Test extends FunSuite with BeforeAndAfter {

  before {
    Main.reset
  }

  test("rect sample inputs") {
    assert(Main.getAnswer("rect 1x1") == 1)
    assert(Main.getAnswer("rect 2x2") == 4)
    assert(Main.getAnswer("rect 50x6") == 300)
  }

  test("rotate commands") {
    assert(Main.getAnswer("rect 2x2") == 4)
  }

}
