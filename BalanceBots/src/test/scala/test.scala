import org.scalatest.FunSuite
import advent.Main

class Test extends FunSuite {

  test("sample inputs") {
    val input = """value 5 goes to bot 2
bot 2 gives low to bot 1 and high to bot 0
value 3 goes to bot 1
bot 1 gives low to output 1 and high to bot 0
bot 0 gives low to output 2 and high to output 0
value 2 goes to bot 2"""
    val nodes = Main.processInput(input)
    assert(nodes.size == 3)
    assert(nodes("bot0").canProceed == false)
    assert(nodes("bot1").canProceed == false)
    assert(nodes("bot2").canProceed == true)
  }

}
