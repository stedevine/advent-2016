package advent
import scala.collection.mutable.Set
import scala.util.control.Breaks._
object Main {
  // No Time for a Taxicab
  def main(args: Array[String]): Unit = {
    val input = "L4, R2, R4, L5, L3, L1, R4, R5, R1, R3, L3, L2, L2, R5, R1, L1, L2, R2, R2, L5, R5, R5, L2, R1, R2, L2, L4, L1, R5, R2, R1, R1, L2, L3, R2, L5, L186, L5, L3, R3, L5, R4, R2, L5, R1, R4, L1, L3, R3, R1, L1, R4, R2, L1, L4, R5, L1, R50, L4, R3, R78, R4, R2, L4, R3, L4, R4, L1, R5, L4, R1, L2, R3, L2, R5, R5, L4, L1, L2, R185, L5, R2, R1, L3, R4, L5, R2, R4, L3, R4, L2, L5, R1, R2, L2, L1, L2, R2, L2, R1, L5, L3, L4, L3, L4, L2, L5, L5, R2, L3, L4, R4, R4, R5, L4, L2, R4, L5, R3, R1, L1, R3, L2, R2, R1, R5, L4, R5, L3, R2, R3, R1, R4, L4, R1, R3, L5, L1, L3, R2, R1, R4, L4, R3, L3, R3, R2, L3, L3, R4, L2, R4, L3, L4, R5, R1, L1, R5, R3, R1, R3, R4, L1, R4, R3, R1, L5, L5, L4, R4, R3, L2, R1, R5, L3, R4, R5, L4, L5, R2"

    // Part 1
    // Given a set of instructions that correspond to a direction (left or right) and a distance in blocks
    // calculate the shortest path from the origin to the destination
    println(getShortestPath(input))
    // Part 2 
    // Find the shortest distance to the first place you visit twice
    println(getShortestPathToFirstPlaceVisitedTwice(input))
  }

  def getShortestPath(input: String): Int = {
    // Seems pretty straightforward  - we need to calculate the "taxicab" distance between the source and the destination.
    // We just need to keep track of our absolute NORTH and EAST values then add them together at the end.
    var northDistance = 0
    var eastDistance = 0
    var currentDirection = "N"
    for (instruction <- input.split(',')) {
      // Get direction
      currentDirection = getDirection(currentDirection, instruction.stripPrefix(" ").take(1))
      val instructionDistance = instruction.stripPrefix(" ").stripPrefix("R").stripPrefix("L").toInt
      currentDirection match {
        case "N" => northDistance += instructionDistance
        case "S" => northDistance -= instructionDistance
        case "E" => eastDistance += instructionDistance
        case "W" => eastDistance -= instructionDistance
      }
    }
    Math.abs(northDistance) + Math.abs(eastDistance)
  }

  def getDirection(currentDirection: String, turn: String): String = {
    currentDirection match {
      case "N" => if (turn == "L") "W" else "E"
      case "S" => if (turn == "L") "E" else "W"
      case "E" => if (turn == "L") "N" else "S"
      case "W" => if (turn == "L") "S" else "N"
    }

  }

  def getShortestPathToFirstPlaceVisitedTwice(input: String): Int = {
    // collect the co-ordinates of each place visited (call the first place 0,0).
    // Note, going from 0,0, to 0,3 means we visit 0,0, 0,1 0,2 and 0,3
    // keep track of the distance
    // when we visit the same place twice return the distance
    // Similar technique as above, but we'll use different variable names
    var xPos = 0
    var yPos = 0
    var currentDirection = "N"
    var places = Set[(Int, Int)]((xPos, yPos))

    for (instruction <- input.split(',')) {
      // Get direction
      currentDirection = getDirection(currentDirection, instruction.stripPrefix(" ").take(1))
      val instructionDistance = instruction.stripPrefix(" ").stripPrefix("R").stripPrefix("L").toInt
      currentDirection match {
        case "N" => for (yPos <- Range(yPos, (yPos + instructionDistance + 1))) {
          if (places.contains((xPos, yPos))) {
            return Math.abs(xPos) + Math.abs(yPos)
          }
          places += ((xPos, yPos))
        }
        case "S" => for (yPos <- Range(yPos - 1, (yPos - instructionDistance - 1), -1)) {
          if (places.contains((xPos, yPos))) {
            return Math.abs(xPos) + Math.abs(yPos)
          }
          places += ((xPos, yPos))
        }
        case "E" => for (xPos <- Range(xPos + 1, (xPos + instructionDistance + 1))) {
          if (places.contains((xPos, yPos))) {
            return Math.abs(xPos) + Math.abs(yPos)
          }
          places += ((xPos, yPos))
        }
        case "W" => for (xPos <- Range(xPos - 1, (xPos - instructionDistance - 1), -1)) {
          if (places.contains((xPos, yPos))) {
            return Math.abs(xPos) + Math.abs(yPos)
          }
          places += ((xPos, yPos))
        }
      }
      println("places " + places)
    }
    -1
  }

}
