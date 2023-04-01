package com.github.fayezosaadi.scala.algorithms
package datastructures.trees

object HasPathWithGivenSum extends App {

  class Tree[T](x: T) {
    var value: T = x
    var left: Option[Tree[T]] = None
    var right: Option[Tree[T]] = None
  }

  def solution(t: Option[Tree[Int]], s: Int): Boolean = {

    // Binary Tree Traversal

    def search(node: Option[Tree[Int]], s: Int): Boolean = {
      if (node.isEmpty) return false // not a leaf node
      if (node.head.left.isEmpty && node.head.right.isEmpty) s == node.head.value // leaf node
      else search(node.head.left, s - node.head.value) || search(node.head.right, s - node.head.value)
    }

    search(t, s)

    //    def search(node: Option[Tree[Int]], s: Int): Boolean = {
    //
    //      node match
    //        case None => false
    //        case Some(n) => (n.left, n.right) match
    //          case (None, None) => s == n.value // this is a leaf node
    //          case _ => search(n.left, s - n.value) || search(n.right, s - n.value)
    //    }

    search(t, s)

  }

  //  val tree = new Tree[Int](1)
  //  val left = new Tree[Int](3)
  //  left.left = Some(new Tree[Int](11))
  //  left.right = Some(new Tree[Int](8))
  //  tree.left = Some(left)
  //  val right = new Tree[Int](2)
  //  right.left = Some(new Tree[Int](6))
  //  tree.right = Some(right)
  //  //
  //  println(s"solution(Some(tree), 3) = ${solution(Some(tree), 9)}")
}
