import scala.annotation.tailrec

def findMiddleElement[T](xs: List[T]): Option[T] = {

  @tailrec
  def loop(ys: List[T], acc: List[T], cnt: Int): Option[T] = {
    ys match {
      case head :: tail if cnt % 2 == 0 => loop(tail, acc, cnt + 1)
      case head :: Nil => acc.headOption
      case _ :: tail => loop(tail, acc.tail, cnt + 1)
      case Nil => acc.headOption
    }
  }

  loop(xs, xs, 0)
}

val s1 = List(1) // shouldbe 1
val s2 = List(1, 2) // shouldbe 1
val s3 = List(1, 2, 3) // shouldbe 2
val s4 = List(1, 2, 3, 4) // shouldbe 2
val s5 = List(1, 2, 3, 4, 5) // shouldbe 3
val s6 = List(1, 2, 3, 4, 5, 6) // shouldbe 3

//findMiddleElement(s1)
//findMiddleElement(s2)
//findMiddleElement(s3)
//findMiddleElement(s4)
//findMiddleElement(s5)
findMiddleElement(s6)

List(3) match {
  case head :: tail => tail
  case _ => "no tail"
}

def findMiddleElement[T](xs: List[T]): Option[T] = {

  @tailrec
  def loop(ys: List[T], acc: List[T], cnt: Int): Option[T] = {
    println(s"ys: $ys | acc: $acc")
    ys match {
      case h1 :: h2 :: h3 :: tail if cnt % 2 == 0 => loop(tail, acc, cnt + 1)
      case _ :: tail => loop(tail, acc.tail, cnt + 1)
      case Nil => acc.headOption
    }
  }

  loop(xs, xs, 0)
}
