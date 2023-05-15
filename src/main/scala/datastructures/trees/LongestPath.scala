package datastructures.trees

import scala.annotation.tailrec
import scala.collection.mutable

object LongestPath extends App {

  /*
  * Suppose we represent our file system as a string.
  * For example, the string "user\n\tpictures\n\tdocuments\n\t\tnotes.txt"
  *
  * find the longest (as determined by the number of characters) absolute path to a file within our system.
  *
  * */
  private def solution(fileSystem: String): Int = {
    val tokens = fileSystem.split("\f")

    def countLevel(string: String): Int = string.length - string.replaceAll("\t", "").length

    @tailrec
    def longestPath(tokens: Array[String], stack: mutable.Stack[Int], currentLength: Int, result: Int): Int = {
      if (tokens.isEmpty) return result

      val string = tokens.head
      val level = countLevel(string)
      if (stack.size > level) return longestPath(tokens, stack.tail, currentLength - stack.pop(), result)

      val length = string.replaceAll("\t", "").length + 1 // "/" needs to be counted following each dir
      val newCurrentLength = currentLength + length
      val newStack = stack.push(length)

      if (!string.contains(".")) return longestPath(tokens.tail, newStack, newCurrentLength, result)

      // found a file!
      val newResult = if (newCurrentLength - 1 > result) newCurrentLength - 1 else result
      longestPath(tokens.tail, newStack, newCurrentLength, newResult)
    }

    longestPath(tokens, mutable.Stack(), 0, 0)
  }

}
