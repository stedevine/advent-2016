package advent
import java.security.MessageDigest
object Main {
  // How About A Nice Game Of Chess
  def main(args: Array[String]): Unit = {
    println(getPassword("abbhdwsy"))
  }

  def getPassword(input: String): String = {
    ""
  }

  def md5(s: String): String = {
    MessageDigest.getInstance("MD5").digest(s.getBytes).toString
  }
}
