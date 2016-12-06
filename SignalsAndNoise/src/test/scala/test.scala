import org.scalatest.FunSuite
import advent.Main

class Test extends FunSuite {

  test("sample inputs") {
    assert(Main.getMessage("""eedadn
drvtee
eandsr
raavrd
atevrs
tsrnev
sdttsa
rasrtv
nssdts
ntnada
svetve
tesnvt
vntsnd
vrdear
dvrsen
enarar""") == "easter")
  }
}
