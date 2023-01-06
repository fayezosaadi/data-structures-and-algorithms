package com.github.fayezosaadi.scala.algorithms
package week1

object MatchingStrings extends App {

  // There is a collection of input strings and a collection of query strings. For each query string, determine how
  // many times it occurs in the list of input strings. Return an array of the results.

  /*
   *
   * The function is expected to return an INTEGER_ARRAY.
   * The function accepts following parameters:
   *  1. STRING_ARRAY strings
   *  2. STRING_ARRAY queries
   */

  def matchingStrings(strings: Array[String], queries: Array[String]): Array[Int] = queries.map(qr => strings.count(_ == qr))
  
}
