package datastructures.trees

object IsSubtree extends App {


  /*
      Given two binary trees t1 and t2, determine whether the second tree is a subtree of the first tree. A subtree for
      vertex v in a binary tree t is a tree consisting of v and all its descendants in t. Determine whether or not there
      is a vertex v (possibly none) in tree t1 such that a subtree for vertex v (possibly empty) in t1 equals t2.

  * */

  def solution(t1: Option[Tree[Int]], t2: Option[Tree[Int]]): Boolean = {

    def preOrderTraversal(tree1: Option[Tree[Int]], tree2: Option[Tree[Int]]): Boolean = {
      (tree1, tree2) match
        case (Some(node1), Some(node2)) =>
          if (node1.value == node2.value) return preOrderTraversal(node1.left, node2.left) && preOrderTraversal(node1.right, node2.right)
          if (preOrderTraversal(node1.left, tree2)) true else preOrderTraversal(node1.right, tree2)
        case (None, None) => true
        case _ => false
    }

    if (t2.isEmpty) true else preOrderTraversal(t1, t2)

  }

}
