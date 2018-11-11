
// Program for generating the generating the value of pi using monte carlo simulation

/* Rough steps are
1) Create a bounded region (square) and generate random points in it.
2) Make sure one of the vertices is the center of the circle and one of the smaller edges is the radius
3) Area under the circle is basically (pi)*sq(edge)/4
4)...which is equal to Area of sq * Nbelow/Ntotal
5) so pi=4*Nbelow/Ntotal (Area method)
6) ..or take an average of dist (from center) of randomly generataed numbers. and multiply it by 4 (average method).
https://blogs.sas.com/content/iml/2016/03/14/monte-carlo-estimates-of-pi.html
https://www.youtube.com/watch?v=xODdBSGOly8
Integral of (1-x^2)^1/2dx over 1,0= pi/4
 */

//Generate a function which will generate a coordinate within a banded region defined by (xi,y1) and (x2,y2)
import scala.io.StdIn._

//this is bit over the real need. the number can be generated very easily by just assuming a radius of 1 and origin
def ptCheckr(ctr:BigInt,x1:Float,y1:Float,radius:Float,newNum:Float, newDen:Float,sumDist:Float): (Float,Float,Float)={
  var num:Float=newNum
  var denom=newDen
  var distanceSum=sumDist
  if (ctr>0) {
    val pt :(Float,Float)=(x1+scala.util.Random.nextFloat*math.sqrt(radius).toFloat,y1+scala.util.Random.nextFloat*math.sqrt(radius).toFloat)
    denom+=1
    distanceSum=distanceSum+math.sqrt(1-(math.pow(pt._1-x1,2)+math.pow(pt._2-y1,2))/radius/2).toFloat
    //println(distanceSum)
    if (math.pow(pt._1-x1,2)+math.pow(pt._2-y1,2) < radius)  num+=1
    ptCheckr(ctr-1,x1,y1,radius,num,denom,distanceSum)

  }
  else (num,denom, distanceSum)

}
def piValue: (Float,Float, Int)={
  println(
    """This is a program to print the value for pi using Monte Carlo Simulation
      |Please input the number of random numbers to be generated
    """.stripMargin)
  val i=readInt()
  println(
  """This is a program to print the value for pi using Monte Carlo Simulation
    |Please input the x coordinate of first point
  """.stripMargin)
  val c1=readFloat()
  println(
    """This is a program to print the value for pi using Monte Carlo Simulation
      |Please input the y coordinate of first point
    """.stripMargin)
  val r1=readFloat()

  println(
    """This is a program to print the value for pi using Monte Carlo Simulation
      |Please input the x coordinate of second point
    """.stripMargin)
  val c2=readFloat()
  println(
    """This is a program to print the value for pi using Monte Carlo Simulation
      |Please input the y coordinate of second point
    """.stripMargin)
  val r2=readFloat()
  val diag: Float=math.sqrt(2*(math.pow(c2-c1,2)+math.pow(r2-r1,2))).toFloat
  val rad: Float=math.pow(c2-c1,2).toFloat+math.pow(r2-r1,2).toFloat
  val res=ptCheckr(i,c1,r1,rad,0,0,0)
  (res._1/res._2*4, res._3/i*4, i)

}
val results=piValue
println("The value of pi for "+ results._3+ " iterations as determined by Area Method "+results._1+" and the value of pi determined  by Average Method "+results._2)
println("The deviation from actual is "+math.abs(+results._1-3.1415926535897)+" and "+math.abs(results._2-3.1415926535897)+" respectively")