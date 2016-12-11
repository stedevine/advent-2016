package advent

object Main {
  // Explosions in cyber space
  def main(args: Array[String]): Unit = {

    println(getDecompressedLength(Input.problem))
  }

  def getDecompressedLength(input: String): Int = {
    var offset = 0
    var output = ""
    while (offset < input.size) {
      println(input(offset))
      if (input(offset) == '(') {
        val (numberOfChars, repeat, sizeOfMarker) = getMarkerData(input.drop(offset + 1))
        // skip to the end of the marker
        offset += sizeOfMarker + 1

        var charsToRepeat = ""
        for (i <- Range(offset, offset + numberOfChars)) {
          charsToRepeat += input(i).toString
        }

        for (i <- Range(0, repeat)) {
          output += charsToRepeat
        }
        // skip to over the repeated characters
        offset += charsToRepeat.size

      } else {
        output += input(offset).toString
        offset += 1
      }
    }
    println(output)
    output.trim.size

  }

  def getMarkerData(input: String): (Int, Int, Int) = {
    val marker = input.split(')')(0)
    val instructions = marker.split('x')
    val numberOfChars = instructions(0).toInt
    val repeat = instructions(1).toInt

    val sizeOfMarker = marker.size + 1
    (numberOfChars, repeat, sizeOfMarker)
  }
}
