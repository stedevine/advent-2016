package advent
object Main {
  // Blank
  def main(args: Array[String]): Unit = {
    println(getAnswer(Input.problem))
  }

  def getAnswer(input: String): Int = {
    val programList = input.split("\n")
    var instructionPointer = 0
    var a = 0
    while (instructionPointer < programList.size) {
      val instruction = programList(instructionPointer).split(" ")
      instruction(0) match {
        case "cpy" => a = instruction(1).trim.toInt
        case "inc" => a += 1
        case "dec" => a -= 1
        case "jnz" => if (a != 0) { instructionPointer += instruction(2).trim.toInt - 1 }
      }
      instructionPointer += 1
    }

    a
  }
}

