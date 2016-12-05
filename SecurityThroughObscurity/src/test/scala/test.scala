import org.scalatest.FunSuite
import advent.Main

class Test extends FunSuite {

  test("sample inputs") {
    assert(Main.isRealRoom("aaaaa-bbb-z-y-x-123[abxyz]") == true)
    assert(Main.isRealRoom("a-b-c-d-e-f-g-h-987[abcde]") == true)
    assert(Main.isRealRoom("not-a-real-room-404[oarel]") == true)
    assert(Main.isRealRoom("totally-real-room-200[decoy]") == false)
  }

  test("cycle input") {
    val roomCode = Main.getRoomCode("qzmt-zixmtkozy-ivhz-343")
    val shifted = Main.cycle(roomCode, 343)
    assert(shifted == "veryencryptedname")

    assert(Main.cycle("abcdefghijklmnopqrstuvwxyz", 0) == "abcdefghijklmnopqrstuvwxyz")
    assert(Main.cycle("abcdefghijklmnopqrstuvwxyz", 1) == "bcdefghijklmnopqrstuvwxyza")
    assert(Main.cycle("abcdefghijklmnopqrstuvwxyz", 2) == "cdefghijklmnopqrstuvwxyzab")
    assert(Main.cycle("abcdefghijklmnopqrstuvwxyz", 128830) == "abcdefghijklmnopqrstuvwxyz")
    assert(Main.cycle("abcdefghijklmnopqrstuvwxyz", 128831) == "bcdefghijklmnopqrstuvwxyza")
    assert(Main.cycle("abcdefghijklmnopqrstuvwxyz", 128832) == "cdefghijklmnopqrstuvwxyzab")
  }
}
