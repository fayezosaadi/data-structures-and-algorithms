package datastructures.trees

object IsTreeSymmetric extends App {

  /*

      Given a binary tree t, determine whether it is symmetric around its center, i.e. each side mirrors the other.
  * */

  def solution(t: Option[Tree[Int]]): Boolean = {

    def solutionAux(left: Option[Tree[Int]], right: Option[Tree[Int]]): Boolean = {
      (left, right) match
        case (Some(l), Some(r)) => if (l.value != r.value) false else solutionAux(l.left, r.right) && solutionAux(l.right, r.left)
        case (None, None) => true
        case _ => false
    }

    t match
      case Some(value) => solutionAux(value.left, value.right)
      case None => true
  }


}
