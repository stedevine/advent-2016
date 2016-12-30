package advent

object Main {
  // Like A Rogue

  def main(args: Array[String]): Unit = {
    println(getAnswer(".^^.^.^^^^", 10))
    println(getAnswer("^.....^.^^^^^.^..^^.^.......^^..^^^..^^^^..^.^^.^.^....^^...^^.^^.^...^^.^^^^..^^.....^.^...^.^.^^.^", 40))
    println(getAnswer("^.....^.^^^^^.^..^^.^.......^^..^^^..^^^^..^.^^.^.^....^^...^^.^^.^...^^.^^^^..^^.....^.^...^.^.^^.^", 400000))
  }

  def getAnswer(input: String, rows: Int): Int = {
    // To produce the next tile  consider the current row
    var safeCount = 0

    var previousRow = input
    for (i <- Range(0, rows)) {
      safeCount += previousRow.count(_ == '.')
      //println(previousRow)
      previousRow = "." + previousRow + "."
      var nextRow = ""
      for (threeCharacters <- previousRow.sliding(3)) {
        if ((threeCharacters.count(_ == '^') == 1) && threeCharacters(1) != '^') {
          nextRow = nextRow + '^'
        } else if ((threeCharacters.count(_ == '^') == 2) && threeCharacters(1) == '^') {
          nextRow = nextRow + '^'
        } else {
          nextRow = nextRow + '.'
        }
      }
      previousRow = nextRow
    }

    safeCount
  }

}
