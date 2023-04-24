package datastructures.trees

import scala.annotation.tailrec

object FindSubstrings extends App {

  /*
     You have two arrays of strings, words and parts. Return an array that contains the strings from words, modified so
     that any occurrences of the substrings from parts are surrounded by square brackets [], following these guidelines:
     If several parts substrings occur in one string in words, choose the longest one. If there is still more than one
     such part, then choose the one that appears first in the string.

  */
  private def triInsert(trie: TrieNode, substring: String): TrieNode = {

    def trieInsertAux(root: TrieNode, substring: String): TrieNode = {
      if (substring.tail.isEmpty) return root.add(substring.head, TrieNode(Map(), true))

      root.getChild(substring.head) match
        case Some(child) => root.add(substring.head, triInsert(child, substring.tail))
        case None => root.add(substring.head, triInsert(TrieNode(Map(), false), substring.tail))
    }

    trieInsertAux(trie, substring)

  }

  private def getValidSubstring(trie: TrieNode, word: String): String = {

    @tailrec
    def getValidPrefix(word: String, prefix: String, trie: TrieNode, results: (String, String)): (String, String) = {
      if (word.isEmpty) return results

      val letter = word.head
      val pref = prefix + letter
      val (matching, _) = results

      trie.getChild(letter) match
        case Some(child) =>
          val result = if (child.terminal && pref.length > matching.length) (pref, word.tail) else results
          getValidPrefix(word.tail, pref, child, result)
        case None => results

    }

    @tailrec
    def getValidPrefixAux(str: String, results: (String, String)): String = {
      val (prefix, rest) = results
      val start = word.take(word.length - (prefix.length + rest.length))

      if (str.length <= prefix.length) if (prefix.isBlank) return rest else return start + s"[$prefix]" + rest
      if (str.isEmpty) return prefix

      getValidPrefixAux(str.tail, getValidPrefix(str, "", trie, results))
    }

    getValidPrefixAux(word, ("", word))
  }

  private def solution(words: Array[String], parts: Array[String]): Array[String] = {
    val trie = parts.foldRight(TrieNode(Map(), false))((part, acc) => triInsert(acc, part))
    words.map(word => getValidSubstring(trie, word))
  }

}