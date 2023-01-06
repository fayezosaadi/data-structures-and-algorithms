package com.github.fayezosaadi.scala.algorithms

import scala.annotation.tailrec

object StringsXOR extends App {

  // Given two strings consisting of digits 0 and 1 only, find the XOR of the two strings.
  private def stringsXOR(s: String, t: String) = {

    @tailrec
    def xorAux(i: Int, result: String): String = if (i >= s.length) result else xorAux(i + 1, result + (s(i) ^ t(i)))

    xorAux(0, "")
  }
}
