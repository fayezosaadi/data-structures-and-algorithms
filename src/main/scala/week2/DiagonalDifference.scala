package com.github.fayezosaadi.scala.algorithms
package week2

import scala.annotation.tailrec

object DiagonalDifference extends App {
  // Given a square matrix, calculate the absolute difference between the sums of its diagonals.

  /*
   *
   * The function is expected to return an INTEGER.
   * The function accepts 2D_INTEGER_ARRAY arr as parameter.
   */

  def diagonalDifference(arr: Array[Array[Int]]): Int = {

    @tailrec
    def diagDiffAux(i: Int, difference: Int): Int = if (i >= arr.length) Math.abs(difference) else diagDiffAux(i + 1, arr(i)(i) - arr(i)(arr.length - i - 1) + difference)

    diagDiffAux(0, 0)
  }
}
