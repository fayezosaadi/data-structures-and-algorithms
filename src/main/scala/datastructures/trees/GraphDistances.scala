package datastructures.trees

import scala.annotation.tailrec

object GraphDistances extends App {

  /*

      You have a strongly connected directed graph that has positive weights in the adjacency matrix g.
      The graph is represented as a square matrix, where g[i][j] is the weight of the edge (i, j),
      or -1 if there is no such edge.

      Given g and the index of a start vertex s, find the minimal distances between the start vertex s and each of the
      vertices of the graph.
  * */

  // Implementation of Dijkstra’s algorithm for finding the shortest path in a directed graph

  private def solution(g: Array[Array[Int]], s: Int): Array[Int] = {

    def findLowestCostNode(costs: Map[Int, Double], processed: Set[Int]): Option[Int] = {

      @tailrec
      def findLowestCostNodeAux(costs: Map[Int, Double], lowestCostNode: Option[Int], lowestCost: Double): Option[Int] = {
        if (costs.isEmpty) return lowestCostNode
        val node = costs.head._1
        val cost = costs.head._2
        if (cost < lowestCost && !processed.contains(node)) findLowestCostNodeAux(costs.tail, Some(node), cost)
        else findLowestCostNodeAux(costs.tail, lowestCostNode, lowestCost)
      }

      findLowestCostNodeAux(costs, None, Double.PositiveInfinity)
    }

    @tailrec
    def updateCosts(i: Int, node: Int, edge: Array[Double], costs: Map[Int, Double]): Map[Int, Double] = {
      if (i >= edge.length) return costs
      val cost = costs(node)
      val newCost = cost + edge(i)
      if (costs(i) > newCost) updateCosts(i + 1, node, edge, costs ++ Map(i -> newCost))
      else updateCosts(i + 1, node, edge, costs)
    }

    @tailrec
    def findShortedPath(costs: Map[Int, Double], processed: Set[Int]): Array[Int] = {
      findLowestCostNode(costs, processed) match
        case None => costs.toArray.sortBy(_._1).map(_._2.toInt)
        case Some(node) =>
          val edge = g(node).map(a => if (a < 0) Double.PositiveInfinity else a.toDouble)
          val newCosts = updateCosts(0, node, edge, costs)
          findShortedPath(newCosts, processed + node)
    }

    val initialCosts: Map[Int, Double] = g(s)
      .zipWithIndex
      .map((cost, i) => if (i == s) (i, 0.toDouble) else if (cost < 0) (i, Double.PositiveInfinity) else (i, cost.toDouble))
      .toMap
    val processed: Set[Int] = Set(s)
    findShortedPath(initialCosts, processed)
  }

}