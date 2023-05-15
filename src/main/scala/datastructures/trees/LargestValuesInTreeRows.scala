package datastructures.trees

import scala.annotation.tailrec
import scala.collection.immutable.Queue

object LargestValuesInTreeRows extends App {

  /*
  *
  * You have a binary tree t. Your task is to find the largest value in each row of this tree. In a tree, a row is a set
  * of nodes that have equal depth. For example, a row with depth 0 is a tree root, a row with depth 1 is composed of
  * the root's children, etc.
  *
  *
  * Return an array in which the first element is the largest value in the row with depth 0, the second element is the
  * largest value in the row with depth 1, the third element is the largest element in the row with depth 2, etc.
  * */
  def solution(t: Option[Tree[Int]]): Array[Int] = {

    @tailrec
    def search(queue: Queue[(Option[Tree[Int]], Int)], result: Map[Int, Int]): Map[Int, Int] = {
      if (queue.isEmpty) return result

      val ((node, level), newQueue) = queue.dequeue // Remove from the front of the queue (FIFO)

      node match
        case Some(n) =>
          val updatedResult = result.get(level) match
            case Some(value) => if (n.value > value) result ++ Map(level -> n.value) else result
            case None => result ++ Map(level -> n.value)
          val updatedQueue = newQueue.enqueue((n.left, level + 1)).enqueue((n.right, level + 1))
          search(updatedQueue, updatedResult)

        case None => search(newQueue, result)

    }

    search(Queue().enqueue((t, 0)), Map()).toArray.sortBy(_._1).map(_._2)
  }

}
