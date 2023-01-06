package com.github.fayezosaadi.scala.algorithms
package week2

import javax.xml.transform.Result

object FlippingBits extends App {


  // You will be given a list of 32 bit unsigned integers. Flip all the bits and return the result as an unsigned integer.
  /*
   *
   * The function is expected to return a LONG_INTEGER.
   * The function accepts LONG_INTEGER n as parameter.
   */
  def flippingBits(n: Long): Long = {

    def getBit(i: Int): Int = if ((n & (1 << i)) != 0) 1 else 0

    def flipBit(i: Int): Int = if (i == 1) 0 else 1

    def flippingBitsAux(i: Int, result: Long): Long = if (i >= 32) result else flippingBitsAux(i + 1, result + (flipBit(getBit(i)) * math.pow(2, i).toLong))

    flippingBitsAux(0, 0)
  }
  
}
