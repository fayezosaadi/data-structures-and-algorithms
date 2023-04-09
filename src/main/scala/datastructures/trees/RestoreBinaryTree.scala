package datastructures.trees

object RestoreBinaryTree extends App {
  /*

      Given the inorder and preorder traversals of a binary tree t, but not t itself, restore t and return it.

  * */
  def solution(inorder: Array[Int], preorder: Array[Int]): Option[Tree[Int]] = {

    def solutionAux(leftTree: Array[Int], rightTree: Array[Int], preorderIndex: Int): Option[Tree[Int]] = {
      if (leftTree.isEmpty && rightTree.isEmpty) return None

      val preorderRoot = preorder(preorderIndex)
      if (rightTree.head == preorderRoot) {
        val root = new Tree[Int](preorderRoot)
        root.left = solutionAux(Array(), leftTree, preorderIndex + 1)
        root.right = solutionAux(Array(), rightTree.tail, leftTree.length + preorderIndex + 1)
        return Some(root)
      }

      solutionAux(leftTree :+ rightTree.head, rightTree.tail, preorderIndex)
    }

    solutionAux(Array(), inorder, 0)

  }

}