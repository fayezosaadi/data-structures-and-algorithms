package datastructures.trees

object KthSmallestInBST extends App {

  /*

      Given a binary search tree t, find the kth smallest element in it.
      Note that kth smallest element means kth element in increasing order.
  * */

  def solution(t: Option[Tree[Int]], k: Int): Int = {

    def inOrderTraversal(tree: Option[Tree[Int]], lastPosition: Int): (Int, Option[Int]) = {

      tree match
        case Some(node) =>
          val (position, maybeAnswer) = inOrderTraversal(node.left, lastPosition)
          if (maybeAnswer.nonEmpty) return (position, maybeAnswer)
          if (position == k) (position, Some(node.value)) else inOrderTraversal(node.right, position)

        case None => (lastPosition + 1, None)

    }

    val (_, answer) = inOrderTraversal(t, 0)
    answer.get

  }

}