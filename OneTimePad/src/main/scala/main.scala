package advent
import java.security.MessageDigest
object Main {
  // Blank
  def main(args: Array[String]): Unit = {
    println(getAnswer(Input.problem))
  }

  type Candidate = (Int, Char)

  def getAnswer(input: String): Int = {
    var candidates = List[Candidate]()
    var keyIndices = List[Int]()
    var index = 0
    while (keyIndices.size < 10) {
      val hash = getHashAtIndex(index)
      val tripletValue = getTripletValue(hash)
      if (!tripletValue.isEmpty) {
        println("candidate hash : " + hash + "(" + tripletValue.get + ") at index " + index)
        candidates = candidates :+ (index, tripletValue.get)
        //println("candidate count " + candidates.size)
      }
      // for each candidate check
      // should candidate be removed ? (index > candidate index + 1000)
      // should candidate be moved to list of keys? (hash contains 5 candidate chars in a row)
      for (candidate <- candidates) {
        if (index > candidate._1 + 1000) {
          println("removing " + candidate)
          candidates = candidates diff List(candidate)
        }
        val quintet = getQuintetValue(hash)
        if (!quintet.isEmpty) {
          if (quintet.get == candidate._2) {
            println("key at : " + candidate._1 + "hash is " + hash)
            keyIndices = keyIndices :+ candidate._1
            candidates = candidates diff List(candidate)
            //println("candidate count " + candidates.size)
            //println("key count " + keyIndices.size)
          }
        }
      }
      index += 1
    }

    println(keyIndices)

    //println(getHashAtIndex(18))
    //val z :String = "aabbbaacccccbb"

    //  z.sliding(3).filter(a => a.toString.distinct.size ==1).size > 0

    0
  }
  def getHashAtIndex(index: Int): String = {
    val salt = "abc"

    MessageDigest.getInstance("MD5").digest((salt + index.toString).getBytes).map("%02x".format(_)).mkString
  }

  def getQuintetValue(input: String): Option[Char] = {
    getRepeatedValue(input, 5)
  }

  def getTripletValue(input: String): Option[Char] = {
    getRepeatedValue(input, 3)
  }

  def getRepeatedValue(input: String, repeats: Int): Option[Char] = {
    val result = input.sliding(repeats).filter(a => a.toString.distinct.size == 1)
    result.hasNext match {
      case true => Some(result.next.head)
      case false => None
    }

  }

  /*
  def md5(s: String): String = {
    MessageDigest.getInstance("MD5").digest(s.getBytes).map("%02x".format(_)).mkString
  }
  */

}

