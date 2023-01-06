package com.github.fayezosaadi.scala.algorithms
package week2

object GradingStudents extends App {

  // Every student receives a grade in the inclusive range from 0 to 100.
  // Any grade less than 40 is a failing grade.
  // Round each student's grade according to these rules:
  //
  // If the difference between the grade and the next multiple of 5 is less than 3, round grade up to the next multiple of 5.
  // If the value of grade is less than 38, no rounding occurs as the result will still be a failing grade.

  /*
   *
   * The function is expected to return an INTEGER_ARRAY.
   * The function accepts INTEGER_ARRAY grades as parameter.
   */
  def gradingStudents(grades: Array[Int]): Array[Int] = {
    // Write your code here
    grades.map(grade => {
      if (grade < 38) grade
      else if (math.ceil(grade / 5f).toInt * 5 - grade < 3) math.ceil(grade / 5f).toInt * 5
      else grade
    })
  }

}
