package advent
object Main {
  // Blank
  def main(args: Array[String]): Unit = {
    println(getAnswer(Input.problem))
  }

  val xSize = 50
  val ySize = 6
  var screen = Array.ofDim[Boolean](xSize, ySize)

  def reset(): Unit = {
    screen = Array.ofDim[Boolean](xSize, ySize)

  }

  def getAnswer(input: String): Int = {
    val command = input.split(' ')
    if (command.size == 2) {
      // rect command
      val x = command(1).split("x")(0).toInt
      val y = command(1).split("x")(1).toInt
      for (i <- Range(0, x)) {
        for (j <- Range(0, y)) {
          screen(i)(j) = true
        }
      }
    }

    // Count lit pixels
    var pixelCount = 0
    for (i <- Range(0, xSize)) {
      pixelCount += screen(i).filter(_ == true).size
    }
    pixelCount
  }
}

