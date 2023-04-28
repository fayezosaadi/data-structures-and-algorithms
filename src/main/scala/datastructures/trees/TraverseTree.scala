package datastructures.trees

import scala.annotation.tailrec
import scala.collection.immutable.Queue

object TraverseTree extends App {

  /*
    Given a binary tree of integers t, return its node values in the following format:

    - The first element should be the value of the tree root;
    - The next elements should be the values of the nodes at height 1 (i.e. the root children), ordered from the leftmost to the rightmost one;
    - The elements after that should be the values of the nodes at height 2 (i.e. the children of the nodes at height 1) ordered in the same way;
    - Etc.

  * */

  def solution(t: Option[Tree[Int]]): Array[Int] = {

    /*
    * Breadth-First Search (BFS)
    * */

    @tailrec
    def search(queue: Queue[Option[Tree[Int]]], result: Array[Int]): Array[Int] = {
      if (queue.isEmpty) return result

      val (node, newQueue) = queue.dequeue // Remove from the front of the queue (FIFO)
      node match
        case Some(n) => search(newQueue.enqueue(n.left).enqueue(n.right), result :+ n.value)
        case None => search(newQueue, result)
    }

    search(Queue().enqueue(t), Array())

  }

}
