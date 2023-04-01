package datastructures.trees

object HasPathWithGivenSum extends App {

  /*

      Given a binary tree t and an integer s, determine whether there is a root to leaf path in t such that the sum of
      vertex values equals s.

  * */

  def solution(t: Option[Tree[Int]], s: Int): Boolean = {

    // Binary Tree Traversal

    def search(node: Option[Tree[Int]], s: Int): Boolean = {
      if (node.isEmpty) return false // not a leaf node
      if (node.head.left.isEmpty && node.head.right.isEmpty) s == node.head.value // leaf node
      else search(node.head.left, s - node.head.value) || search(node.head.right, s - node.head.value)
    }

    search(t, s)

  }

}
