package com.endava

/**
 * 7.Flatten a nested list structure.
 * 
 * 8.Eliminate consecutive duplicates of list elements.
 * If a list contains repeated elements they should be replaced with a
 * single copy of the element.  The order of the elements should not be changed.
 * 
 * 9.Pack consecutive duplicates of list elements into sublists.
 * If a list contains repeated elements they should be placed in separate sublists. 
 * Run-length encoding of a list.
 * 
 * 10.Use the result of problem 9. to implement the so-called run-length encoding data compression method. 
 * Consecutive duplicates of elements are encoded as tuples (N, E) 
 * where N is the number of duplicates of the element E. 
 * @author ccheibas
 */

object Easy {
	def main(args: Array[String]) {
		var toflatten = List(List(1, 1), 2, List(3, List(5, 8)))
				var list = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
				println("7. " + flatten(toflatten))
				println("8. " + removeDuplicate(list))
				println("9. " + pack(list))
				println("10. " + rle(list))
				println("11. " + mrle(list))
	}
	/**
	 * Modified Run Length Encoding MRLE
	 * creates a map from the list with the in the form of (count, element)
	 * in case the element has no duplicates it remains untouched
	 */

	def mrle[A](ls: List[A]):List[Any] = {
			pack(ls).map { first => if(first.length==1)(first.head) 
					else (first.length, first.head) 
			}
	}

	/**
	 * Run Length Encoding RLE
	 * creates a map from the list with the in the form of (count, element)
	 */
	def rle[A](ls: List[A]):List[(Int,A)] = {
			pack(ls).map { first => (first.length, first.head) }
	}


	/**
	 * first case checks if its a list and flattens it if so
	 * second case checks if its flattened and breaks the recursivity if so
	 */

	def pack[A](ls: List[A]): List[List[A]] = {
			val (packed, rest) = ls.span{(_ == ls.head)}
			if (rest == Nil) List(packed)
			else packed::pack(rest)
	}

	/**
	 * folds the Generic list to the left(which is good for big arrays as well)
	 * checks if the element already exists in the new array. at the end reverses everything
	 * the reason for reverse is different implementations of the foldLeft and foldRight functions
	 * foldRight does not return anything near correct
	 */     

	def removeDuplicate[A] (list:List[A]):List[A] = {
			list.foldLeft(List[A]())((ls,first) => 
			if (!ls.contains(first)) first::ls
			else ls).reverse       
	}

	/**
	 * first case checks if its a list and flattens it if so
	 * second case checks if its flattened and breaks the recursivity if so
	 */

	def flatten[A] (list: List[A]): List[A] = list.flatten {
	case ls: List[A] => flatten(ls)
	case e => List(e)
	}
}