package advent

object Main {
  // Sqaures with three sides
  def main(args: Array[String]): Unit = {
    // Part 1 How many of the input triangles are legal? 
    // The two smaller sides must sum to equal or larger than the longest side
    println(getNumberOfLegalTriangles(Input.problem))
    println(getNumberOfLegalTrianglesVertical(Input.problem))
  }

  def getNumberOfLegalTriangles(input: String): Int = {
    var countOfLegalTriangles = 0
    for (triangle <- input.split("\n")) {
      var t = triangle.split(" ").filterNot(_ == "").map(_.toInt).sortWith(_ < _)
      if (t(0) + t(1) > t(2)) {
        countOfLegalTriangles += 1
      }
    }

    countOfLegalTriangles
  }

  def getNumberOfLegalTrianglesVertical(input: String): Int = {
    var countOfLegalTriangles = 0
    var data = input.split("\n")

    for (i <- Range(0, data.length / 3)) {

      val left1 = data(3 * i).split(" ").filterNot(_ == "")(0).toInt
      val left2 = data((3 * i) + 1).split(" ").filterNot(_ == "")(0).toInt
      val left3 = data((3 * i) + 2).split(" ").filterNot(_ == "")(0).toInt
      if (isLegal(left1, left2, left3)) {
        countOfLegalTriangles += 1
      }
      val mid1 = data(3 * i).split(" ").filterNot(_ == "")(1).toInt
      val mid2 = data((3 * i) + 1).split(" ").filterNot(_ == "")(1).toInt
      val mid3 = data((3 * i) + 2).split(" ").filterNot(_ == "")(1).toInt
      if (isLegal(mid1, mid2, mid3)) {
        countOfLegalTriangles += 1
      }
      val right1 = data(3 * i).split(" ").filterNot(_ == "")(2).toInt
      val right2 = data((3 * i) + 1).split(" ").filterNot(_ == "")(2).toInt
      val right3 = data((3 * i) + 2).split(" ").filterNot(_ == "")(2).toInt
      if (isLegal(right1, right2, right3)) {
        countOfLegalTriangles += 1
      }

    }
    countOfLegalTriangles
  }

  def isLegal(a: Int, b: Int, c: Int): Boolean = {
    val points = Array(a, b, c)
    val sorted = points.sortWith(_ < _)
    println(sorted)

    (sorted(0) + sorted(1) > sorted(2))
  }
}
