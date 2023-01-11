package datastructures

import java.util.EmptyStackException

abstract class Stack[+A] {
  // stack of data
  // last in first out (LIFO)

  def pop: Stack[A] // Remove the top item from the stack.

  def push[B >: A](item: B): Stack[B] // Add an item to the top of the stack.

  def peek: A // Return the top of the stack.

  def isEmpty: Boolean
}

case object Empty extends Stack[Nothing] {
  def pop: Stack[Nothing] = throw new EmptyStackException

  def push[A](data: A): Stack[A] = StackNode(data, Empty)

  def peek: Nothing = throw new EmptyStackException

  def isEmpty: Boolean = true
}

case class StackNode[+A](data: A, next: Stack[A]) extends Stack[A] {
  def pop: Stack[A] = next

  def push[B >: A](data: B): Stack[B] = StackNode(data, this)

  def peek: A = data

  def isEmpty: Boolean = false
}