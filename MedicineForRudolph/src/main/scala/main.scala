package advent
import scala.collection.mutable.Map
import scala.collection.mutable.Set

object Main {
  // No Time for a Taxicab
  def main(args: Array[String]): Unit = {
  }

  def getNumberOfDistinctMolecules(molecule: String, transitions: String): Int = {
    // Create a map from the transitions string
    val map = Map[String, String]()
    for (transition <- transitions.split("\r\n")) {
      //println(transition)
      map += (transition.split(" => ")(0) -> transition.split(" => ")(1))
    }
    println(map)
    0
  }

}
