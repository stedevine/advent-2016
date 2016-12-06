package advent
object Main {
  // Signal to Noise
  def main(args: Array[String]): Unit = {
    println(getMaxMessage(Input.problem))
    println(getMinMessage(Input.problem))
  }

  // Change the limits on the range from 8 to 6 to make the test pass.
  def getMaxMessage(input: String): String = {

    var letters = ""
    for (i <- Range(0, 8)) {
      letters += getLettersAtPosition(input, i).groupBy(a => a).mapValues(_.size).maxBy(_._2)._1.toString
    }
    letters
  }

  def getMinMessage(input: String): String = {

    var letters = ""
    for (i <- Range(0, 8)) {
      letters += getLettersAtPosition(input, i).groupBy(a => a).mapValues(_.size).minBy(_._2)._1.toString
    }
    letters
  }

  def getLettersAtPosition(input: String, position: Int): String = {
    var letters = ""
    for (line <- input.split("\n")) {
      letters += line(position).toString
    }
    letters
  }

}
