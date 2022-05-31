import Algorithm.findMiddleElement
import org.scalatest._
import flatspec._
import matchers._

class AlgorithmSpec extends AnyFlatSpec with should.Matchers {

  behavior of "findMiddleElement() function"
  it should "return middle element of List" in {
    val s1 = List(1) // shouldbe 1
    val s2 = List(1, 2) // shouldbe 1
    val s3 = List(1, 2, 3) // shouldbe 2
    val s4 = List(1, 2, 3, 4) // shouldbe 2
    val s5 = List(1, 2, 3, 4, 5) // shouldbe 3
    val s6 = List(1, 2, 3, 4, 5, 6) // shouldbe 3

    findMiddleElement(s1) shouldBe Some(1)
    findMiddleElement(s2) shouldBe Some(1)
    findMiddleElement(s3) shouldBe Some(2)
    findMiddleElement(s4) shouldBe Some(2)
    findMiddleElement(s5) shouldBe Some(3)
    findMiddleElement(s6) shouldBe Some(3)

    findMiddleElement((1 to 100).toList) shouldBe Some(50)
    findMiddleElement((0 to 1000).toList) shouldBe Some(500)
  }

  it should "work with different types of lists" in {

    findMiddleElement(List("ala", "ma", "kota")) shouldBe Some("ma")
    findMiddleElement(('a' to 'e').toList) shouldBe Some('c')
  }
}