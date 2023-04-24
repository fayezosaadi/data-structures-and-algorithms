package datastructures.trees

import scala.annotation.tailrec

class Tree[T](x: T) {
  var value: T = x
  var left: Option[Tree[T]] = None
  var right: Option[Tree[T]] = None
}

case class TrieNode(children: Map[Char, TrieNode], terminal: Boolean) {

  def getChild(char: Char): Option[TrieNode] = children.get(char)

  def add(char: Char, node: TrieNode): TrieNode = {
    getChild(char) match
      case Some(child) => TrieNode(children ++ Map(char -> TrieNode(child.children ++ node.children, node.terminal)), terminal)
      case None => TrieNode(children ++ Map(char -> node), terminal)
  }
}