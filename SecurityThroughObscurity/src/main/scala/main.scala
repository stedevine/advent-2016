package advent
import scala.collection.mutable.Set
object Main {
  // Security Through Obscurity
  def main(args: Array[String]): Unit = {
    println(getSectorCount(Input.problem))
    println(getNorthPoleObjectStorageSectorId(Input.problem))
  }

  def getSectorCount(input: String): Int = {
    var sectorCount = 0
    for (line <- input.split("\n")) {
      val sectorId = getSectorId(line)
      if (isRealRoom(line)) {
        sectorCount += sectorId
      }

    }
    sectorCount
  }

  def getNorthPoleObjectStorageSectorId(input: String): Int = {
    for (line <- input.split("\n")) {
      val sectorId = getSectorId(line)
      if (cycle(getRoomCode(line), sectorId).contains("pole")) {
        return sectorId
      }
    }
    // not found
    -1
  }

  def isRealRoom(line: String): Boolean = {
    val roomCode = getRoomCode(line)
    // extract the input checksum
    var inputChecksum = line.trim.split('[')(1).dropRight(1)
    (calculateChecksum(roomCode) == inputChecksum)
  }

  def getRoomCode(line: String): String = {
    // format is room-code-with-dashes-sectorId[checksum]
    // Extract the roomcode from the string
    // The dashes within the code are irrelevant, but we can use them to 
    // cut off the sectorId and checksum
    line.split('-').dropRight(1).mkString
  }

  def getSectorId(line: String): Int = {
    line.split('[')(0).split('-').last.toInt
  }

  def calculateChecksum(roomCode: String): String = {
    // Map each letter in the string to a count of the number of times that letter 
    // appears in the string, convert to a list and sort alphabetically by key 
    // then by count (descending)
    val letters = roomCode.groupBy(c => c).map(x => (x._1, x._2.size)).toList.sortBy(_._1).sortBy(-_._2)
    // The checksum is the most five common letters in the list
    val calculatedChecksum =
      letters(0)._1.toString +
        letters(1)._1.toString +
        letters(2)._1.toString +
        letters(3)._1.toString +
        letters(4)._1.toString

    calculatedChecksum
  }

  def cycle(roomCode: String, shift: Int): String = {
    var decrypted = ""
    for (c <- roomCode) {
      // char a = 97, that's our offset into the character set
      // use % operator to keep the values between 0 and 25
      decrypted += (((c.toInt - 97 + (shift % 26)) % 26) + 97).toChar.toString
    }
    println(decrypted)
    decrypted
  }
}

