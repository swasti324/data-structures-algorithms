//Homework 1 Data Structures and Algorithms
package com.example

    /*
    Check whether or not a list is a palindrome (i.e., has the same sequence
    of values forwards or backwards).

    Args:
        iterable: A list to check.

    Returns:
        True if iterable is a palindrome, and false otherwise.
    */

fun palindrome(iterable: String):Boolean {
    val reverse = iterable.reversed()
    println(reverse)
    var t: Int = 0
    var final: Boolean = false
    for (letter in iterable) {
        if (letter == reverse[t]) {
            t += 1
            final = true
            continue
            }
        else
        {
            break
        }
    }
        println(final)
        return final
    }




/*
Original Code:
def is_palindrome(iterable):
  """
  Check whether or not a list is a palindrome (i.e., has the same sequence
  of values forwards or backwards).

  Args:
      iterable: A list to check.

  Returns:
      True if iterable is a palindrome, and false otherwise.
  """
  # Replace this line and your code with the implementation.
  iterable = str(iterable)
  reverse = iterable[::-1]
  t = 0
  for letter in iterable:
      if letter == reverse[t]:
          t += 1
          final = True
          continue
      else:
         final = False
         break
  return final

*/