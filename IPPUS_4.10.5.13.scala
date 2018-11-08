/* Data assumptions
Food Menu:
  Hamburgers: $5
  Samosa:$3
  Pakora: $6
  Sandwich: $7
Drinks Menu:
  Beer: $6
  Whiskey: $8
  LIT: $6

Table: 5 Tables
  Table 1: 4
  Table 2: 2
  Table 3: 3
  Table 4: 6
  Table 5: 8
  Tzble 6: 9
tip mount of 15% levied on if # of people served >6
Tax: 7% on Food, 9% on Drinks
 */
import io.StdIn._

def table: (Int,Int)={
  println("Please Enter the table number")
  val tableNo=readInt()
  val tSeating =Map(1->4,2->2,3->3,4->6,5->8,6->9)
  (tableNo,tSeating(tableNo))
}

def orderPersonFood: Double ={
  val foodPrice =Map(1->5,2->3,3->6,4->7,0->0)
  println(

    """Please Enter the menu item
      |  No Food:     ----> Enter 0
      |  Hamburgers:$5----> Enter 1
      |  Samosa:    $3----> Enter 2
      |  Pakora:    $6----> Enter 3
      |  Sandwich:  $7----> Enter 4
    """.stripMargin)
  println("Please Enter the Food item number")
  val foodItem=readInt()
  foodPrice(foodItem)
}
def orderPersonDrink: Double ={
  val drinkPrice =Map(1->4,2->8,3->9,4->7,0->0)
  println(

    """Please Enter the menu item
      |  No Drink :    ----> Enter 0
      |  Beer     :  $4----> Enter 1
      |  Whiskey  :  $8----> Enter 2
      |  LIT      :  $9----> Enter 3
      |  Vodka    :  $7----> Enter 4
    """.stripMargin)
  println("Please Enter the Drink item number")
  val drinkItem=readInt()
  drinkPrice(drinkItem)
}
def orderTotal(pplCount:Int): Double={
  var totalFoodValue: Double=0.0
  var totalDrinkValue: Double =0.0
  for(i<-1.to(pplCount)) {
    totalFoodValue += orderPersonFood * 1.07
    totalDrinkValue += orderPersonDrink * 1.09
  }
  if(pplCount>6) (totalFoodValue+ totalDrinkValue)*1.15 else totalFoodValue+ totalDrinkValue
}
println("Welcome to Happy House Cafe")
val tblnm=table
println("The total receipt for Table "+tblnm._1+" is "+orderTotal(tblnm._2))

