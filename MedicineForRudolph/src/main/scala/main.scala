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
    var map = list.map(s => (s.split(" => ")(0), s.split(" => ")(1))).groupBy(_._1).mapValues(_.map(_._2))

    println(map)
    0
  }

}
