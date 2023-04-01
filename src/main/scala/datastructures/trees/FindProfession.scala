package datastructures.trees

object FindProfession extends App {


  /*

    Consider a special family of Engineers and Doctors. This family has the following rules:
      - Everybody has two children.
      - The first child of an Engineer is an Engineer and the second child is a Doctor.
      - The first child of a Doctor is a Doctor and the second child is an Engineer.
      - All generations of Doctors and Engineers start with an Engineer.

      Given the level and position of a person in the ancestor tree above, find the profession of the person.
      Note: in this tree first child is considered as left child, second - as right.

  * */

  def solution(level: Int, pos: Int): String = {

    def ops(profession: String): String = {
      profession match
        case "Engineer" => "Doctor"
        case "Doctor" => "Engineer"
    }

    def solutionAux(level: Int, pos: Int): String = {
      if (pos == 1) return "Engineer"
      val positions = math.pow(2, level).toInt
      val half = positions / 2
      if (pos > half) ops(solutionAux(level - 1, pos - half)) else solutionAux(level - 1, pos)
    }

    solutionAux(level, pos)
  }
  
}
