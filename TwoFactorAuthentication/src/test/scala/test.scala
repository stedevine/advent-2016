import org.scalatest.FunSuite
import org.scalatest.BeforeAndAfter
import advent.Main

class Test extends FunSuite with BeforeAndAfter {

  before {
    Main.reset
  }

  test("rect sample inputs") {
    Main.updateScreen("rect 1x1")
    assert(Main.countLitPixels == 1)
    Main.updateScreen("rect 3x3")
    assert(Main.countLitPixels == 9)
    Main.updateScreen("rect 50x6")
    assert(Main.countLitPixels == 300)
  }

  test("rotate commands") {
    Main.updateScreen("rect 2x2")
    Main.printScreen
    Main.updateScreen("rotate row x=0 by 98")
    Main.updateScreen("rotate row x=1 by 98")

    Main.printScreen
    Main.updateScreen("rotate column y=48 by 10")
    Main.updateScreen("rotate column y=49 by 10")
    Main.printScreen
  }

}
