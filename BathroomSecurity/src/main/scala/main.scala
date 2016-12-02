package advent
import scala.collection.mutable.Set
object Main {
  // Bathroom Security
  def main(args: Array[String]): Unit = {
    val input = """ULUULLUULUUUUDURUUULLDLDDRDRDULULRULLRLULRUDRRLDDLRULLLDRDRRDDLLLLDURUURDUDUUURDRLRLLURUDRDULURRUDLRDRRLLRDULLDURURLLLULLRLUDDLRRURRLDULRDDULDLRLURDUDRLLRUDDRLRDLLDDUURLRUDDURRLRURLDDDURRDLLDUUDLLLDUDURLUDURLRDLURURRLRLDDRURRLRRDURLURURRRULRRDLDDDDLLRDLDDDRDDRLUUDDLDUURUULDLUULUURRDRLDDDULRRRRULULLRLLDDUDRLRRLLLLLDRULURLLDULULLUULDDRURUDULDRDRRURLDRDDLULRDDRDLRLUDLLLDUDULUUUUDRDRURDDULLRDRLRRURLRDLRRRRUDDLRDDUDLDLUUDLDDRRRDRLLRLUURUDRUUULUDDDLDUULULLRUDULULLLDRLDDLLUUDRDDDDRUDURDRRUUDDLRRRRURLURLD
LDLUDDLLDDRLLDLDRDDDDDUURUDDDUURLRLRLDULLLDLUDDDULLDUDLRUUDDLUULLDRLDDUDLUDDLURRRLDUURDDRULLURLLRLLUUDRLDDDLDLDRDUDLRDURULDLDRRDRLDLUURRRRLUDDULDULUUUDULDDRLLDDRRUULURRUURRLDUUUDDDDRUURUDRRRDDDDLRLURRRRUUDDDULRRURRDLULRURDDRDRLUDLURDDRDURRUURDUDUDRRDDURRRDURDLUUUURRUDULLDDRLLLURLDUDRRLDDLULUDUDDDDUDLUUULUURUDRURUUDUUURRLDUUDRDRURLLDLLLLLRLLUDURDRRLULRRDDDRLDRDDURLRDULULLDDURURLRRDRULDULUUUURLDURUDUDUDDLUDRRDURULRDULLLDRRDLDLUDURDULULLDDURDDUDRUUUDUDRLDUURDUUUDUURURUDRULRURLDLRDDURDLUU
DDLDRLLDRRDRRLLUUURDDULRDUDRDRUDULURLLDDLRRRUDRDLDLURRRULUDRDLULLULLDUUDRLRUDDLRRURRUULRLDLLLDLRLLLURLLLURLLRDDLULLDUURLURDLLDLDUDLDRUUUDDLLDRRRRRUDRURUURRRDRUURDRDDRLDUUULUDUDRUDLLLLDRDRURRRDUUURLDLRLRDDDRLUDULDRLLULRDLDURDLDURUUDDULLULRDDRLRUURLLLURDRUURUUDUUULRDUDDRDURRRDUUDRRRUDRDLRURDLLDDDURLLRRDDDDLDULULDRLDRULDDLRRRLUDLLLLUDURRRUURUUULRRLDUURDLURRLRLLRDLRDDRDDLRDLULRUUUDDDUDRRURDDURURDDUDLURUUURUUUUDURDDLDRDULDRLDRLLRLRRRLDRLLDDRDLDLUDDLUDLULDLLDRDLLRDULDUDDULRRRUUDULDULRRURLRDRUDLDUDLURRRDDULRDDRULDLUUDDLRDUURDRDR
URDURRRRUURULDLRUUDURDLLDUULULDURUDULLUDULRUDUUURLDRRULRRLLRDUURDDDLRDDRULUUURRRRDLLDLRLRULDLRRRRUDULDDURDLDUUULDURLLUDLURULLURRRDRLLDRRDULUDDURLDULLDURLUDUULRRLLURURLDLLLURDUDRLDDDRDULLUDDRLDDRRRLDULLLLDUURULUDDDURUULUUUDURUDURDURULLLDRULULDRRLDRLDLRLRUDUDURRLURLRUUDRRDULULDLLDRDRRRDUDUURLDULLLURRDLUDDLDDRDDUDLDDRRRUDRULLURDDULRLDUDDDRULURLLUDLLRLRRDRDRRURUUUURDLUURRDULLRDLDLRDDRDRLLLRRDDLDDDDLUDLRLULRRDDRDLDLUUUDLDURURLULLLDDDULURLRRURLDDRDDLD
UDUULLRLUDLLUULRURRUUDDLLLDUURRURURDDRDLRRURLLRURLDDDRRDDUDRLLDRRUDRDRDDRURLULDDLDLRRUDDULLRLDDLRURLUURUURURDLDUDRLUUURRRLUURUDUDUUDDLDULUULRLDLLURLDRUDRLLRULURDLDDLLULLDRRUUDDLRRRUDDLRDRRRULDRDDRRULLLUDRUULURDUDRDLRRLDLRLRLDDULRRLULUUDDULDUDDULRRURLRDRDURUDDDLLRLDRDRULDDLLRLLRDUDDDDDDRLRLLDURUULDUUUDRURRLLRLDDDDRDRDUURRURDRDLLLUDDRDRRRDLUDLUUDRULURDLLLLLRDUDLLRULUULRLULRURULRLRRULUURLUDLDLLUURDLLULLLDDLRUDDRULRDLULRUURLDRULRRLULRLRULRDLURLLRURULRDRDLRRLRRDRUUURURULLLDDUURLDUDLLRRLRLRULLDUUUULDDUUU"""

    // Part 1
    // Find the code to the bathroom given a set of Up,Down,Left,Right instructions.
    // The bathroom input panel looks like a calculator:
    // 1 2 3
    // 4 5 6
    // 7 8 9
    // Starting initially at position 5, read each line of instructions to find the code.
    println(getCode(input))
    // Part 2
    // Same rules but the input panel looks like this : 
    //     1  
    //   2 3 4
    // 5 6 7 8 9
    //   A B C
    //     D
    println(getCodeUpdatedPanel(input))
  }

  val inputPanel = Array(
    Array(1, 2, 3),
    Array(4, 5, 6),
    Array(7, 8, 9)
  )

  def getCode(input: String): String = {
    var position = (1, 1)
    var code = ""
    for (line <- input.split("\r\n")) {
      position = getPosition(line, position)
      code += inputPanel(position._1)(position._2)
    }
    code
  }

  def getPosition(line: String, startPosition: (Int, Int)): (Int, Int) = {
    var position = startPosition
    for (instruction <- line) {
      instruction match {
        case 'L' => position = (position._1, Math.max(0, position._2 - 1))
        case 'R' => position = (position._1, Math.min(2, position._2 + 1))
        case 'U' => position = (Math.max(0, position._1 - 1), position._2)
        case 'D' => position = (Math.min(2, position._1 + 1), position._2)
      }
    }
    position
  }

  // zeros are invalid positions, they're used to put the valid values into a 
  // sqaure.
  val updatedPanel = Array(
    Array("0", "0", "1", "0", "0"),
    Array("0", "2", "3", "4", "0"),
    Array("5", "6", "7", "8", "9"),
    Array("0", "A", "B", "C", "0"),
    Array("0", "0", "D", "0", "0")
  )

  def getCodeUpdatedPanel(input: String): String = {
    var position = (2, 0)
    var code = ""
    for (line <- input.split("\r\n")) {
      position = getPositionUpdatedPanel(line, position)
      code += updatedPanel(position._1)(position._2)
    }
    code
  }

  // The limit to which you can move left is determined by the y position:
  val lLimit = Map(0 -> 2, 1 -> 1, 2 -> 0, 3 -> 1, 4 -> 2)
  // similarly: 
  val rLimit = Map(0 -> 2, 1 -> 3, 2 -> 4, 3 -> 3, 4 -> 2)
  val uLimit = Map(0 -> 2, 1 -> 1, 2 -> 0, 3 -> 1, 4 -> 2)
  val dLimit = Map(0 -> 2, 1 -> 3, 2 -> 4, 3 -> 3, 4 -> 2)

  def getPositionUpdatedPanel(line: String, startPosition: (Int, Int)): (Int, Int) = {
    var position = startPosition
    for (instruction <- line) {
      instruction match {
        case 'L' => position = (position._1, Math.max(lLimit(position._1), position._2 - 1))
        case 'R' => position = (position._1, Math.min(rLimit(position._1), position._2 + 1))
        case 'U' => position = (Math.max(uLimit(position._2), position._1 - 1), position._2)
        case 'D' => position = (Math.min(dLimit(position._2), position._1 + 1), position._2)
      }
    }
    position
  }
}
