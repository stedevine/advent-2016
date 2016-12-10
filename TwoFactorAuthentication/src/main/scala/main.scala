package advent
object Main {
  // Two Factor Authentication

  val xSize = 50
  val ySize = 6
  var screen = Array.ofDim[Boolean](ySize, xSize)

  def main(args: Array[String]): Unit = {
    println(processInput(Input.problem))
  }

  def processInput(input: String): Int = {
    for (line <- input.split("\n")) {
      printScreen
      println(line)
      updateScreen(line)

      printScreen
    }
    countLitPixels
  }

  // takes a single command : 
  // rect 2x4
  // rotate row 4 by 3
  // rotate column 2 by 9 
  def updateScreen(input: String): Unit = {
    val command = input.split(' ')

    if (command.size == 2) {
      // rect command
      val x = command(1).split("x")(0).toInt
      val y = command(1).split("x")(1).trim.toInt
      for (i <- Range(0, y)) {
        for (j <- Range(0, x)) {
          screen(i)(j) = true
        }
      }
    } else {
      // rotate command 
      val shift = command(4).trim.toInt

      if (command(1) == "row") {
        // rotate the row
        val row = command(2).split('=')(1).toInt
        for (i <- Range(0, shift)) {
          screen(row) = (screen(row)(screen(row).size - 1) +: screen(row)).take(screen(row).size)
        }
      } else {
        // rotate the column
        val colIndex = command(2).split('=')(1).toInt

        // get the column 
        var column = new Array[Boolean](screen.size)
        for (i <- Range(0, screen.size)) {
          column(i) = screen(i)(colIndex)
        }

        // perform the rotation
        for (i <- Range(0, shift)) {
          column = (column(column.size - 1) +: column).take(column.size)
        }

        // update the screen
        for (i <- Range(0, screen.size)) {
          screen(i)(colIndex) = column(i)
        }
      }
    }
  }

  def countLitPixels(): Int = {
    var pixelCount = 0
    for (i <- Range(0, ySize)) {
      pixelCount += screen(i).filter(_ == true).size
    }
    pixelCount

  }
  /*
  def getAnswer(input: String): Int = {
    val command = input.split(' ')
    if (command.size == 2) {
      // rect command
      val x = command(1).split("x")(0).toInt
      val y = command(1).split("x")(1).toInt
      for (i <- Range(0, y)) {
        for (j <- Range(0, x)) {
          screen(i)(j) = true
        }
      }
    } else {

      val shift = command(4).toInt

      if (command(1) == "row") {
        // rotate the row
        val row = command(2).split('=')(1).toInt
        for (i <- Range(0, shift)) {
          screen(row) = (screen(row)(screen(row).size - 1) +: screen(row)).take(screen(row).size)
        }
        //println("Row : " + row)
      } else {
        // rotate the column
        val colIndex = command(2).split('=')(1).toInt

        // get the column 
        var column = new Array[Boolean](screen.size)
        for (i <- Range(0, screen.size)) {
          column(i) = screen(i)(colIndex)
        }

        // rotate the column
        for (i <- Range(0, shift)) {
          column = (column(column.size - 1) +: column).take(column.size)
        }

        // update the screen
        for (i <- Range(0, screen.size)) {
          screen(i)(colIndex) = column(i)
        }
      }

    }

    // Count lit pixels
    var pixelCount = 0
    for (i <- Range(0, ySize)) {
      pixelCount += screen(i).filter(_ == true).size
    }
    pixelCount
  }
*/

  // Debug functions 
  def reset(): Unit = {
    screen = Array.ofDim[Boolean](ySize, xSize)

  }

  def printScreen(): Unit = {
    for (i <- Range(0, screen.size)) {
      for (j <- Range(0, screen(i).size)) {
        if (screen(i)(j)) {
          print("#")
        } else {
          print(".")
        }
      }
      println
    }
    println
  }

}

