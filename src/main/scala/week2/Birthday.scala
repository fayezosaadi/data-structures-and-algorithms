package week2

import scala.annotation.tailrec

object Birthday extends App {

  /*
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER_ARRAY s
   *  2. INTEGER d
   *  3. INTEGER m
   */

  def birthday(s: Array[Int], d: Int, m: Int): Int = {

    @tailrec
    def birthdayAux(i: Int, j: Int, seg: Array[Int], result: Array[Array[Int]]): Int = {
      if (seg.sum == d && seg.length == m) return birthdayAux(i + 1, i + 1, Array(), result :+ seg)
      if (i >= s.length) return result.length
      if (j >= s.length) return birthdayAux(i + 1, i + 1, Array(), result)
      birthdayAux(i, j + 1, seg ++ Array(s(j)), result)
    }

    birthdayAux(0, 0, Array(), Array())
  }

  println(birthday(Array(1, 2, 1, 3, 2), 3, 2))

}
