package datastructures.trees

object DigitTreeSum extends App {

  def solution(t: Option[Tree[Int]]): Long = {

    /*
    *
    * We're going to store numbers in a tree. Each node in this tree will store a single digit (from 0 to 9), and each
    * path from root to leaf encodes a non-negative integer.
    *
    * Given a binary tree t, find the sum of all the numbers encoded in it.
    * */

    // dfs algorithm
    def search(root: Option[Tree[Int]], pref: String): Long = {
      root match
        case Some(node) =>
          (node.left, node.right) match
            case (None, None) => (pref + node.value).toLong
            case (left, None) => search(left, pref + node.value.toString)
            case (None, right) => search(right, pref + node.value.toString)
            case (left, right) => search(left, pref + node.value.toString) + search(right, pref + node.value.toString)
        case None => pref.toLong
    }

    search(t, "0")
  }

}
