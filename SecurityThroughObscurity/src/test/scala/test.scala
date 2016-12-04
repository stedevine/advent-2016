import org.scalatest.FunSuite
import advent.Main

class Test extends FunSuite {

  test("sample inputs") {
    assert(Main.isRealRoom("aaaaa-bbb-z-y-x-123[abxyz]") == true)
    assert(Main.isRealRoom("a-b-c-d-e-f-g-h-987[abcde]") == true)
    assert(Main.isRealRoom("not-a-real-room-404[oarel]") == true)
    assert(Main.isRealRoom("totally-real-room-200[decoy]") == false)
  }

}
