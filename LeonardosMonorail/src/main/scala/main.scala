package advent
object Main {
  // Leonardos Monorail
  def main(args: Array[String]): Unit = {
    println(getAnswer(Input.problem))
  }

  def getAnswer(input: String): Int = {
    val programList = input.split("\n")
    var instructionPointer = 0
    var a = 0
    var b = 0
    // set to 0 for Part 1, 1 for part 2
    var c = 1
    var d = 0
    var registers = scala.collection.mutable.Map("a" -> a, "b" -> b, "c" -> c, "d" -> d)
    while (instructionPointer < programList.size) {
      val instruction = programList(instructionPointer).split(" ")
      instruction(0) match {
        case "cpy" => {
          // copy instruction
          registers.contains(instruction(1)) match {
            case true => registers(instruction(2).trim) = registers(instruction(1))
            case false => registers(instruction(2).trim) = instruction(1).trim.toInt
          }
        }
        case "inc" => registers(instruction(1).trim) += 1
        case "dec" => registers(instruction(1).trim) -= 1
        case "jnz" =>
          {
            var zeroCheck = 0
            registers.contains(instruction(1)) match {
              case true => zeroCheck = registers(instruction(1).trim)
              case false => zeroCheck = instruction(1).trim.toInt
            }

            if (zeroCheck != 0) {
              instructionPointer += instruction(2).trim.toInt - 1
            }
          }
      }

      instructionPointer += 1

    }
    registers("a")
  }
}
