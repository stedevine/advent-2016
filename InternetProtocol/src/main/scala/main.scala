package advent
import scala.io.Source
import scala.collection.mutable.ListBuffer

object Main {
  // Blank
  def main(args: Array[String]): Unit = {
    println(countSupported("/home/stephendevine/advent-2016/InternetProtocol/src/main/scala/input.txt"))
  }

  def countSupported(input: String): Int = {
    var supported = 0
    for (line <- Source.fromFile(input).getLines) {
      if (hasSupport(line)) {
        supported += 1
      }
    }

    supported
  }

  def hasSupport(input: String): Boolean = {
    // supernet (letters outside the square brackets) must contain ABBA
    // hypernet (letters inside the square brackets) must not contain ABBA
    var offest = 0
    var hasAbba = false
    var hasInnerAbba = false
    var isInner = false
    for (offset <- Range(0, input.size - 3)) {
      val four = input.drop(offset).take(4)
      // check if we're between the square brackets
      if (four.contains("[")) {
        isInner = true
      } else if (four.contains("]")) {
        isInner = false
      }
      if (isABBA(four)) {
        if (isInner) {
          hasInnerAbba = true
        } else {
          hasAbba = true
        }
      }
    }

    hasAbba && !hasInnerAbba
  }

  def isABBA(input: String): Boolean = {
    input(0) == input(3) &&
      input(1) == input(2) &&
      input(0) != input(1)
  }

  def hasSuperSupport(input: String): Boolean = {
    // separate the nets
    println(input)
    val supernets = new ListBuffer[String]
    val hypernets = new ListBuffer[String]
    var isSupernet = true
    var currentWord = ""
    for (c <- input) {

      if (c == '[') {
        supernets += currentWord
        currentWord = ""
        //isSupernet = false
      } else if (c == ']') {
        hypernets += currentWord
        currentWord = ""
        //isSupernet = true
      } else
        currentWord += c.toString
    }
    supernets += currentWord
    // find any hypernet ABAs
    //val hypernet = input.split('[')(1).split(']')(0)
    println(supernets)
    println(hypernets)
    // get all the candidate ABAs from the hypernets
    val candidates = new ListBuffer[String]
    for (hypernet <- hypernets) {
      for (offset <- Range(0, hypernet.size - 2)) {
        val three = hypernet.drop(offset).take(3)
        if (three(0) == three(2)) {
          candidates += three(1).toString + three(0).toString + three(1).toString
        }
      }
    }
    println(candidates)
    for (candidate <- candidates) {
      println(candidate)
    }
    false
  }

}

