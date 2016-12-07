import org.scalatest.FunSuite
import advent.Main

class Test extends FunSuite {

  test("sample inputs") {
    assert(Main.hasSupport("abba[mnop]qrst"))
    assert(!Main.hasSupport("abcd[bddb]xyyx"))
    assert(!Main.hasSupport("aaaa[qwer]tyui"))
    assert(Main.hasSupport("ioxxoj[asdfgh]zxcvbn"))
  }
  test("super sample inputs") {
    assert(Main.hasSuperSupport("aba[bab]xyz"))
    assert(!Main.hasSuperSupport("xyx[xyx]xyx"))
    assert(Main.hasSuperSupport("aaa[kek]eke"))
    assert(Main.hasSuperSupport("zazbz[bzb]cdb"))
  }
}

