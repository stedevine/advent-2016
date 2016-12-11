import org.scalatest.FunSuite
import advent.Main

class Test extends FunSuite {

  test("sample inputs") {
    assert(Main.getDecompressedLength("ADVENT") == 6)
    assert(Main.getDecompressedLength("""A(1x5)BC""") == 7)
    assert(Main.getDecompressedLength("(3x3)XYZ") == 9)
    assert(Main.getDecompressedLength("A(2x2)BCD(2x2)EFG") == 11)
    assert(Main.getDecompressedLength("(6x1)(1x3)A") == 6)
    assert(Main.getDecompressedLength("X(8x2)(3x3)ABCY") == 18)
    assert(Main.getDecompressedLength("(19x14)(3x2)ZTN(5x14)MBPWH") == 266)
  }

}
