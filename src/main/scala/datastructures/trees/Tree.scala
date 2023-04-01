package datastructures.trees

class Tree[T](x: T) {
  var value: T = x
  var left: Option[Tree[T]] = None
  var right: Option[Tree[T]] = None
}
