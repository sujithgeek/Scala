
// Program for generating the generating the value of pi using monte carlo simulation

/* Rough steps are
1) Create a bounded region (square) and generate random points in it.
2) Make sure one of the vertices is the center of the circle and one of the smaller edges is the radius
3) Area under the circle is basically (pi)*sq(edge)/4
4)...which is equal to Area of sq * Nbelow/Ntotal
5) so pi=4*Nbelow/Ntotal
 */

//Generate a function which will generate a coordinate within a banded region defined by (xi,y1) and (x2,y2)
import scala.io.StdIn._

//this is bit over the real need. the number can be generated very easily by just assuming a radius of 1 and origin
def ptCheckr(ctr:Int,x1:Double,y1:Double,radius:Double,diagonal:Double,newNum:Double, newDen:Double): (Double,Double)={
  var num:Double=newNum
  var denom=newDen
  if (ctr>0) {
    var pt :(Double,Double)=(x1+scala.util.Random.nextDouble*(diagonal/math.sqrt(2)),y1+scala.util.Random.nextDouble*(diagonal/math.sqrt(2)))
    denom+=1
    if (math.pow(pt._1-x1,2)+math.pow(pt._2-y1,2) < radius)  num+=1
    ptCheckr(ctr-1,x1,y1,radius,diagonal,num,denom)

  }
  else (num,denom)

}
def piValue: Double={
  println(
    """This is a program to print the value for pi using Monte Carlo Simulation
      |Please input the number of random numbers to be generated
    """.stripMargin)
  val i=readInt()
  println(
  """This is a program to print the value for pi using Monte Carlo Simulation
    |Please input the x coordinate of first point
  """.stripMargin)
  val c1=readDouble()
  println(
    """This is a program to print the value for pi using Monte Carlo Simulation
      |Please input the y coordinate of first point
    """.stripMargin)
  val r1=readDouble()

  println(
    """This is a program to print the value for pi using Monte Carlo Simulation
      |Please input the x coordinate of second point
    """.stripMargin)
  val c2=readDouble()
  println(
    """This is a program to print the value for pi using Monte Carlo Simulation
      |Please input the y coordinate of second point
    """.stripMargin)
  val r2=readDouble()
  val diag: Double=math.sqrt(2*(math.pow(c2-c1,2)+math.pow(r2-r1,2)))
  val rad: Double=math.pow(c2-c1,2)+math.pow(r2-r1,2)
  val res=ptCheckr(i,c1,r1,rad,diag,0,0)
  res._1/res._2*4

}
println("The value of pi determined is  the value of num is "+piValue)