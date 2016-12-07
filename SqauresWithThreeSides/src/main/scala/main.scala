package advent

object Main {
  // Sqaures with three sides
  def main(args: Array[String]): Unit = {
    // Part 1 How many of the input triangles are legal? 
    // The two smaller sides must sum to equal or larger than the longest side
    println(getNumberOfLegalTriangles(Input.problem))
    // Part 2 The triangles expressed in columns, not rows!
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

      val (left1, left2, left3) = getTriangle(data, i, 0)
      if (isLegal(left1, left2, left3)) {
        countOfLegalTriangles += 1
      }
      val (mid1, mid2, mid3) = getTriangle(data, i, 1)
      if (isLegal(mid1, mid2, mid3)) {
        countOfLegalTriangles += 1
      }
      val (right1, right2, right3) = getTriangle(data, i, 2)
      if (isLegal(right1, right2, right3)) {
        countOfLegalTriangles += 1
      }
    }
    countOfLegalTriangles
  }

  def getTriangle(data: Array[String], offset: Int, column: Int): (Int, Int, Int) = {
    (
      data(3 * offset).split(" ").filterNot(_ == "")(column).toInt,
      data((3 * offset) + 1).split(" ").filterNot(_ == "")(column).toInt,
      data((3 * offset) + 2).split(" ").filterNot(_ == "")(column).toInt
    )
  }

   def isLegal((a: Int, b: Int, c: Int)): Boolean = {
    val points = Array(a, b, c)
    val sorted = points.sortWith(_ < _)

    (sorted(0) + sorted(1) > sorted(2))
  }
}
def isLegal(a: Int, b: Int, c: Int): Boolean = {
    val points = Array(a, b, c)
    val sorted = points.sortWith(_ < _)

    (sorted(0) + sorted(1) > sorted(2))
  }
}
