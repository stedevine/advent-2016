import org.scalatest.FunSuite
import advent.Main

class Test extends FunSuite {

  test("sample inputs") {
    assert(Main.getAnswer("""cpy 41 a
inc a
inc a
dec a
jnz a 2
dec a""") == 42)
  }

}
