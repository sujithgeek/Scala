
/* SOME BASICS
val are unchangeable and var are changeable
You can declare the type but it is not entirely necessary.
In Scala, the type of a variable or function is written
after the name of the variable or function. Say a: string
In Scala, semicolons are only required if you have multiple statements on the same line
Scala has seven numeric types: Byte, Char, Short, Int, Long, Float, and Double, and a Boolean type.
However, unlike Java, these types are class
es. ivalent
*/

/* Defining a function: def fn(input1: input1type, input2: input2type): fntype = {}
 */

def max(x:Int, y:Int): Int= {
  if (x>y) x
  else y
}
max(1,5)

def fn2(x:Int): Unit = {
  for(i<- 0 to x) (println(i))

}
fn2(5)