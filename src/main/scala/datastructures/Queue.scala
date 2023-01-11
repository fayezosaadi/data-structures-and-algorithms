package datastructures

abstract class Queue[+A] {

  // last in first out (FIFO)

  /**
   *
   * One place where queues are often used is in breadth-first search or in implementing a cache.
   * In breadth-first search, for example, we used a queue to store a list of the nodes that we need to process.
   * Each time we process a node, we add its adjacent nodes to the back of the queue. This allows us
   * to process nodes in the order in which they are viewed.
   */

  def add[B >: A](node: B): Queue[B] // Add an item to the end of the list.

  def remove: Queue[A] // Remove the first item in the list.

  def peek: A // Return the top of the queue.

  def isEmpty: Boolean // Return true if and only if the queue is empty.

}

case object EmptyQueue extends Queue[Nothing] {
  override def add[B >: Nothing](node: B): Queue[B] = QueueNode(node, EmptyQueue)

  def remove: Queue[Nothing] = throw new NoSuchElementException()

  def peek: Nothing = throw new NoSuchElementException()

  def isEmpty: Boolean = true

}

case class QueueNode[+A](h: A, t: Queue[A]) extends Queue[A] {

  def add[B >: A](node: B): Queue[B] = QueueNode(h, t.add(node))

  def remove: Queue[A] = t

  def peek: A = h

  def isEmpty: Boolean = false

}