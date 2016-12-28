package advent
object Main {
  // Dragon Checksum
  def main(args: Array[String]): Unit = {
    println(getAnswer("10111100110001111", 272))
    println(getAnswer("10111100110001111", 35651584))
  }

  def getAnswer(input: String, diskSize: Int): String = {
    // Generate the DragonChecksum
    var a = input
    while (a.size < diskSize) {
      a = a + "0" + a.reverse.map(x => ((x.toInt + 1) % 2)).mkString
      //println("dragon size " + a.size)
    }

    a = a.take(diskSize)

    var checkSum = a
    while (checkSum.size % 2 == 0) {
      //println("checksum size : " + checkSum.size)
      checkSum = getChecksum(checkSum)
    }

    checkSum
  }

  def getChecksum(input: String): String = {
    var checkSum = input
    val result = new StringBuilder

    for (i <- Range(0, input.size - 1, 2)) {
      result ++= (if (input(i) == input(i + 1)) 1 else 0).toString
    }
    result.toString
  }
}
