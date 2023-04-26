package datastructures.trees

object DeleteFromBST extends App {

  /*
  *
    Removing a value x from a BST t is done in the following way:

    - If there is no x in t, nothing happens;
    - Otherwise, let t' be a subtree of t such that t'.value = x.
      - If t' has a left subtree, remove the rightmost node from it and put it at the root of t';
      - Otherwise, remove the root of t' and its right subtree becomes the new t's root.

  * */
  def solution(t: Option[Tree[Int]], queries: Array[Int]): Option[Tree[Int]] = queries.foldLeft(t)(deleteFromBST)

  private def mostRightNode(tree: Tree[Int]): (Option[Tree[Int]], Int) = {
    tree.right match
      case Some(right) =>
        val (node, value) = mostRightNode(right)
        tree.right = node
        (Some(tree), value)
      case None => (tree.left, tree.value)
  }

  private def deleteFromBST(tree: Option[Tree[Int]], query: Int): Option[Tree[Int]] = {

    tree match
      case Some(node) =>

        if (node.value != query) {
          node.left = deleteFromBST(node.left, query)
          node.right = deleteFromBST(node.right, query)
          return Some(node)
        }

        node.left match
          case Some(left) =>
            val (newNode, value) = mostRightNode(left)
            node.value = value
            node.left = newNode
            Some(node)
          case None => node.right

      case None => tree
  }

}
