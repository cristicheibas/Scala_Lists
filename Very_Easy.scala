package com.endava

/**
 * 1.Find the last element of a list.
 * 
 * 2.Find the last but one element of a list.
 * 
 * 3.Find the Kth element of a list.
 * 
 * 4.Find the number of elements of a list.
 * 
 * 5.Reverse a list.
 * 
 * 6.Find out whether a list is a palindrome.
 * 
 * @author ccheibas
 */

object Very_Easy {
	def main(args: Array[String]) {
		var list = List(1,2,3,4,5,6,7,8,9,10)
				println("1. " + list.last)
				println("2. " + list.dropRight(1).last)
				println("Introduce the Position of the Element you would like displayed: ")
				println("3. " + list(readInt))
				println("4. " + list.size)
				println("5. " + list.reverse)
        println("6. " + isPalindrome(list))
	}
  
  def isPalindrome(ls: List[Any]):Boolean = {
  ls==ls.reverse
  }

}