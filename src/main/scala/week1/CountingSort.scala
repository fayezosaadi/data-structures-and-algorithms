package com.github.fayezosaadi.scala.algorithms
package week1

import scala.annotation.tailrec

object CountingSort extends App {

  // Given a list of integers, count and return the number of times each value appears as an array of integers.

  /*
   *
   * The function is expected to return an INTEGER_ARRAY.
   * The function accepts INTEGER_ARRAY arr as parameter.
   */

  def countingSort(arr: Array[Int]): Array[Int] = {

    @tailrec
    def countingSortAux(i: Int, result: Array[Int]): Array[Int] = {
      if (i >= arr.length) result
      else {
        val value = arr(i)
        val first = result.take(value)
        val last = result.takeRight(result.length - (value + 1))
        val count = Array(result(value) + 1)
        countingSortAux(i + 1, first ++ count ++ last)
      }
    }

    countingSortAux(0, Array.fill(100)(0))
  }

}
