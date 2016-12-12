package advent

object Main {
  // Explosions in cyber space
  def main(args: Array[String]): Unit = {

    //println(getDecompressedLength(Input.problem))
    println(getLength(Input.problem))
  }

  def getDecompressedLength(input: String): Int = {
    var offset = 0
    var output = ""
    while (offset < input.size) {
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

  def getSuperDecompressedLength(input: String): Int = {
    var offset = 0
    var outputSize = 0
    while (offset < input.size) {
      //println(input(offset))
      println(offset + " / " + input.size)
      if (input(offset) == '(') {
        // Marker in input string, find the new offset
        val (numberOfChars, repeat, sizeOfMarker) = getMarkerData(input.drop(offset + 1))
        // recursively decompress the data covered by this marker
        outputSize += getDecompressedMarkerSizeRecursive(input.drop(offset).dropRight(input.size - offset - (numberOfChars + sizeOfMarker + 1)))

        // move the offset past the data coverd by this marker
        offset += sizeOfMarker + numberOfChars + 1
      } else {
        // Not a marker
        outputSize += 1
        offset += 1
      }
    }
    outputSize
  }

  def getDecompressedMarkerSizeRecursive(input: String): Int = {
    //println("recursive " + input)
    var size = 0
    if (input.contains('(')) {
      size = getDecompressedMarkerSizeRecursive(getDecompressedString(input))
    } else {
      size = input.size
    }

    size
  }

  def getDecompressedString(input: String): String = {
    var offset = 0
    var output = ""
    while (offset < input.size) {
      if (input(offset) == '(') {
        val (numberOfChars, repeat, sizeOfMarker) = getMarkerData(input.drop(offset + 1))
        println("size of input " + input.size)
        println("numberOfChars " + numberOfChars)
        println("repeat " + repeat)
        println("sizeOfMarker " + sizeOfMarker)
        // skip to the end of the marker
        offset += sizeOfMarker + 1
        println("offset " + offset)

        var charsToRepeat = ""
        for (i <- Range(offset, Math.min(numberOfChars + offset, input.size))) {
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
    output

  }

  def getLength(input: String): Long = {
    var size = 0L
    if (!input.contains(')')) {
      // base case
      size = input.size
    } else {
      var nonMarkerChars = 0
      while (input(nonMarkerChars) != '(') {
        nonMarkerChars += 1
      }

      var next = input.drop(nonMarkerChars)
      val (numberOfChars, repeats, markerSize) = getMarker(next)

      size = nonMarkerChars + getLength(next.substring(markerSize, markerSize + numberOfChars)) * repeats + getLength(next.substring(markerSize + numberOfChars, next.size))

    }

    size
  }

  def getMarker(input: String): (Int, Int, Int) = {
    val marker = input.drop(1).split(')')(0)
    val instructions = marker.split('x')
    val numberOfChars = instructions(0).toInt
    var repeats = instructions(1).toInt

    (numberOfChars, repeats, marker.size + 2)
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
