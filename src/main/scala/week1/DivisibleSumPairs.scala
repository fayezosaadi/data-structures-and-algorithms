package com.github.fayezosaadi.scala.algorithms
package week1

object DivisibleSumPairs extends App {

  // Given an array of integers and a positive integer k, determine the number of (i, j) pairs where i < j and ar[i] + ar[j] is divisible by k.

  def divisibleSumPairs(n: Int, k: Int, ar: Array[Int]): Int = {

    def divisibleSumPairsAux(i: Int, j: Int, count: Int): Int = {
      if (i >= n) return count
      if (j >= n) return divisibleSumPairsAux(i + 1, i + 2, count)
      if ((ar(i) + ar(j)) % k == 0) return divisibleSumPairsAux(i, j + 1, count + 1)

      divisibleSumPairsAux(i, j + 1, count)
    }

    divisibleSumPairsAux(0, 1, 0)

  }

}
