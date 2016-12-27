package advent
import java.security.MessageDigest
object Main {
  // Blank
  def main(args: Array[String]): Unit = {
    // Print the index of the  64th key for this salt
    println(getAnswer("yjdafjpo"))
  }

  def getAnswer(input: String): Int = {
    // build up a map of "characters that are repeated 5 times" to a list of indices at which this happens
    var keys = List[Int]()
    var qMap = scala.collection.mutable.Map[Char, List[Int]]()
    var qIndex = 0
    var tIndex = qIndex - 1000
    while (keys.size < 64) {
      if (tIndex >= 0) {
        var tripletCharacter = getTripletValue(getHashAtIndex(input, tIndex))
        if (!tripletCharacter.isEmpty) {
          // does the triplet value exist in the qMap?
          if (qMap.contains(tripletCharacter.get)) {
            //   println(tIndex + " " + tripletCharacter.get + " " + qMap(tripletCharacter.get))

            val indexInMap = qMap(tripletCharacter.get).reverse.head
            if (indexInMap - tIndex > 0) {
              //    println("within range " + (indexInMap - tIndex))
              keys = keys :+ tIndex
            }
          }
        }
      }

      val qChars = getQuintetCharacters(getHashAtIndex(input, qIndex))
      if (!qChars.isEmpty) {
        //println(qIndex.toString + " " + qChars)
        for (qChar <- qChars) {
          if (qMap.contains(qChar)) {
            qMap(qChar) = qMap(qChar) :+ qIndex
          } else {
            qMap(qChar) = List(qIndex)
          }
        }
      }
      qIndex += 1
      tIndex += 1
    }
    //println(qMap)
    //println(keys)
    println(keys(63))
    keys(63)
  }

  def getHashAtIndex(salt: String, index: Int): String = {
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

  // Get a list of all of the characters that are repeated 5 or more times
  def getQuintetCharacters(input: String): List[Char] = {
    input.sliding(5).filter(a => a.toString.distinct.size == 1).map(b => b.toString.head).toList.distinct
  }

  /*
  def md5(s: String): String = {
    MessageDigest.getInstance("MD5").digest(s.getBytes).map("%02x".format(_)).mkString
  }
  */

}

