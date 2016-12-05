package advent
import scala.collection.mutable.Map
import scala.collection.mutable.Set
import scala.collection.mutable.ListBuffer
object Main {
  // No Time for a Taxicab
  def main(args: Array[String]): Unit = {
  }

  def getNumberOfDistinctMolecules(molecule: String, transitions: String): Int = {
    // Create a map from the transitions string
    val list = ListBuffer[String]()
    for (transition <- transitions.split("\n")) {
      list += transition
    }
    val map = list.map(s => (s.split(" => ")(0), s.split(" => ")(1))).groupBy(_._1).mapValues(_.map(_._2))

    println(map)

    for (element <- getElements(molecule)) {

    }

    0
  }

  def getElements(molecule: String): List[String] = {
    // Break up the molecule into its elements
    // Elements can be a single upper case char or
    // An uppercase char followed by a lowercase char
    var elements = new ListBuffer[String]
    var i = 0
    while (i < molecule.size) {
      if ((i < molecule.size - 1) && molecule(i + 1).isLower) {
        elements += molecule(i).toString + molecule(i + 1).toString
        i += 1
      } else {
        elements += molecule(i).toString
      }
      i += 1
    }

    elements.toList
  }

}
