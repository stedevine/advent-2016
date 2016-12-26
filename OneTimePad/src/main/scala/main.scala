package advent
import java.security.MessageDigest
object Main {
  // Blank
  def main(args: Array[String]): Unit = {
    // Print the index of the  64th key for this salt
    println(getAnswer("abc"))
  }

  def getAnswer(input: String): Int = {
    // build up a map of "characters that are repeated 5 times" to a list of indices at which this happens
    val qMap = Map[Char, List[Int]]()
    var qIndex = 0
    while (qIndex < 10000000) {
      val hash = getHashAtIndex(input, qIndex)
      val qChars = getQuintetCharacters(hash)
      if (!qChars.isEmpty) {
        println(qIndex.toString + " " + qChars)
      }
      qIndex += 1
    }

    0
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
  def getQuintetCharacters(input: String): List[String] = {
    input.sliding(5).filter(a => a.toString.distinct.size == 1).map(b => b.toString.head.toString).toList.distinct
  }

  /*
  def md5(s: String): String = {
    MessageDigest.getInstance("MD5").digest(s.getBytes).map("%02x".format(_)).mkString
  }
  */

}

