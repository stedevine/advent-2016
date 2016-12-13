package advent
object Main {
  // Balance Bots
  def main(args: Array[String]): Unit = {
    getAnswer(Input.problem)
  }

  def getAnswer(input: String): Unit = {

    val nodeMap = processInput(input)
    var outputMap = Map[String, Int]()
    // Get the bots that contain 2 values - these are the ones that can be processed
    var actionNodeMap = nodeMap.filter(m => m._2.canProceed)
    // Continue until there are no more processable bots
    while (actionNodeMap.size > 0) {
      for (entry <- actionNodeMap) {
        val (lowKey, lowValue, highKey, highValue) = entry._2.getValues
        if (!lowKey.contains("output")) {
          nodeMap(lowKey).setValue(lowValue)
        } else {
          outputMap += (lowKey -> lowValue)
        }
        if (!highKey.contains("output")) {
          nodeMap(highKey).setValue(highValue)
        } else {
          outputMap += (lowKey -> lowValue)
        }

      }
      actionNodeMap = nodeMap.filter(m => m._2.canProceed)
    }
    // Problem 2 : output0 x output1 x output2
    println("output0 x output1 x output2 = " + outputMap("output0") * outputMap("output1") * outputMap("output2"))
  }

  def processInput(input: String): Map[String, Bot] = {
    var bots = Map[String, Bot]()
    var lines = input.split("\n")
    // Populate the Map of bots before we attempt to initialise them
    for (line <- lines.filter(_.startsWith("bot"))) {
      val command = line.split(" ")
      val key = command(0).toString + command(1).toString
      val low = command(5).toString + command(6).toString
      val high = command(10).toString + command(11).toString
      bots += (key.trim -> new Bot(key, low.trim, high.trim))
    }
    // They all exist, initialize them
    for (line <- lines.filter(_.startsWith("value"))) {
      val command = line.split(" ")
      val key = command(4).toString + command(5).toString
      bots(key.trim).setValue(command(1).toInt)
    }
    bots
  }

  class Bot(key: String, lowKey: String, highKey: String) {
    var values = Array[Int]()
    var isUsed = false
    def setValue(v: Int): Unit = {
      values = values :+ v
      // Problem 1 - which bot is responsible for comparing 61 and 17?
      if (canProceed && (values(0) == 61 || values(1) == 61) && (values(0) == 17 || values(1) == 17)) {
        println(key + " compares 61 and 17")
      }
    }

    def canProceed(): Boolean = {
      isUsed == false && values.size == 2
    }

    def getValues(): (String, Int, String, Int) = {
      // We only need to process each bot once - if we don't mark the bot as used the
      // program will not terminate.
      isUsed = true
      (lowKey, Math.min(values(0), values(1)), highKey, Math.max(values(0), values(1)))
    }
  }
}
