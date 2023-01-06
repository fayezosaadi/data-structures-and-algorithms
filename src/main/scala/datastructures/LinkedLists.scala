package com.github.fayezosaadi.scala.algorithms
package datastructures

import scala.annotation.targetName


// A linked list is a data structure that represents a sequence of nodes. In a singly linked list, each node
// points to the next node in the linked list. A doubly linked list gives each node pointers to both the next
// node and the previous node.

// Unlike an array, a linked list does not provide constant time access to a particular "index" within the list.
// This means that if you'd like to find the Kth element in the list, you will need to iterate through K elements.
// The benefit of a linked list is that you can add and remove items from the beginning of the list in constant
// time. For specific applications, this can be useful.

// creating a Linked List
// basic singly linked list
abstract class LinkedList[+A] {

  /**
   * singly linked list
   * head = first element of the list
   * tail = reminder of the list (the pointer of the reminder of the list)
   *
   * implement method signatures in sub-types
   *
   */
  def head: A

  def tail: LinkedList[A] // the remainder of the linked list

  def isEmpty: Boolean

  def add[B >: A](element: B): LinkedList[B] // new list with the element added

  @targetName("appendToTail")
  def ++[B >: A](list: LinkedList[B]): LinkedList[B]

  def delete[B >: A](element: B): LinkedList[B]

}

case object Empty extends LinkedList[Nothing] {
  override def head: Nothing = throw new NoSuchElementException

  override def tail: LinkedList[Nothing] = throw new NoSuchElementException

  override def isEmpty: Boolean = false

  override def add[A >: Nothing](element: A): LinkedList[A] = Cons(element, Empty)

  @targetName("appendToTail")
  override def ++[B >: Nothing](list: LinkedList[B]): LinkedList[B] = list

  def delete[A >: Nothing](element: A): Nothing = throw new NoSuchElementException
}

case class Cons[+A](h: A, t: LinkedList[A]) extends LinkedList[A] {
  def head: A = h

  def tail: LinkedList[A] = t

  def isEmpty: Boolean = false

  def add[B >: A](node: B): LinkedList[B] = Cons(node, this)

  @targetName("appendToTail")
  def ++[B >: A](node: LinkedList[B]): LinkedList[B] = Cons(head, tail ++ node)

  def delete[B >: A](node: B): LinkedList[B] = if (node == head) tail else Cons(head, tail.delete(node))

}

object LinkedLists extends App {
  private val listOfIntegers: LinkedList[Int] = Cons(2, Cons(5, Cons(2, Empty)))
}
