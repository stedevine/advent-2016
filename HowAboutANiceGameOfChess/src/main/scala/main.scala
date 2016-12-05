package advent
import java.security.MessageDigest
object Main {
  // How About A Nice Game Of Chess
  def main(args: Array[String]): Unit = {
    println(getPassword("abbhdwsy"))
    println(getInterestingPassword("abbhdwsy"))
  }

  def getPassword(input: String): String = {
    var code = ""
    var i = 0
    while (code.size < 8) {
      val hash = md5(input + i)
      if (i % 10000 == 0) {
        println(hash + " " + i.toString)
      }
      if (hash.take(5) == "00000") {
        code += hash(5).toString
        println(hash)
        println(code)
      }
      i += 1
    }

    println(code)

    code
  }

  def getInterestingPassword(input: String): String = {
    var code = Array.fill(8) { '-' }
    var i = 0
    while (code.contains('-')) {
      val hash = md5(input + i)
      if (i % 100000 == 0) {
        println(hash + " " + i.toString)

      }
      if (hash.take(5) == "00000") {
        println("found match")
        println(hash)
        val position = getPosition(hash)
        println("position " + position)
        if (position > -1 && position < 8 && code(position) == '-') {
          code(position) = hash(6)
        }

        println("code " + code.mkString)
      }
      i += 1

    }

    code.mkString
  }

  def getPosition(hash: String): Int = {
    var position = -1
    try {
      position = hash(5).toString.toInt
    } catch {
      case e: Exception => position = -1
    }
    position
  }

  def md5(s: String): String = {
    MessageDigest.getInstance("MD5").digest(s.getBytes).map("%02x".format(_)).mkString
  }
}
