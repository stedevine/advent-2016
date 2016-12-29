package advent
import java.security.MessageDigest

object Main {
  // TwoStepsForward
  def main(args: Array[String]): Unit = {
    println(getAnswer("ihgpwlah"))
  }

  def getAnswer(input: String): String = {
    ""
  }

  def md5(s: String): String = {
    MessageDigest.getInstance("MD5").digest(s.getBytes).map("%02x".format(_)).mkString
  }

}
