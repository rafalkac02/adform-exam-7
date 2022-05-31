# Challenge #7

Table of contents
1. [About The Project](#about-the-project)
    - [Adform's exam](#adforms-exam)
    - [Project description](#project-description)
2. [My thinking process](#my=-thinking-process)
3. [Usage](#usage)


## About the Project

### Adform's exam
This project is a part of a final exam after 3-months of Scala Academy at [Adform](https://site.adform.com/). The exam consists of 7 exercises. You can navigate to them in Exam TOC below.

<details>
  <summary>Exam TOC</summary>

1. [Challenge #1](https://github.com/rafalkac02/adform-exam-1)
2. [Challenge #2](https://github.com/rafalkac02/adform-exam-2)
3. [Challenge #3](https://github.com/rafalkac02/adform-exam-3)
4. [Challenge #4](https://github.com/rafalkac02/adform-exam-4)
5. [Challenge #5](https://github.com/rafalkac02/adform-exam-5)
6. [Challenge #6](https://github.com/rafalkac02/adform-exam-6)
7. [Challenge #7](https://github.com/rafalkac02/adform-exam-7)
</details>

### Project description
- **task description**

Fix a function that should return the middle list element. In case of list having even number of elements the left middle element should be returned, e.g. [1,2,3,4] should return 2
Include algorithm explanation

- **code** (to be repaired)
```scala
def findMiddleElement[T](xs: List[T]): Option[T] = {
   @tailrec
   def loop(ys: List[T], acc: List[T], cnt: Int): Option[T] = {
      ys match {
         case head :: tail if cnt % 2 == 0 => loop(tail, acc.tail, cnt + 1)
         case _ :: tail => loop(tail, acc, cnt + 1)
         case Nil => acc.headOption
      }
   }
   loop(xs, xs, 0)
}
```

## My thinking process
The code snippet I have fixed suggest that we need to pass two lists as parameters to recursive function. I did not change the shape of this function, but fixed the logic.

To get the middle element without using built-in functions, we use two lists and a counter. We drop the first element. Every time loop() is called we drop first element from one list. The other list is reduced every second time.

This way, as soon as we finish looping over first list, the head of the second list is the middle element. Taking first element from the left, solves the problem with lists of even length. It meets the task's requirements. 


My solution:
```scala
def findMiddleElement[T](xs: List[T]): Option[T] = {
 @tailrec
 def loop(ys: List[T], acc: List[T], cnt: Int): Option[T] = {
   ys match {
     case head :: Nil => acc.headOption
     case head :: tail if cnt % 2 == 0 => loop(tail, acc, cnt + 1)
     case _ :: tail => loop(tail, acc.tail, cnt + 1)
   }
 }
 loop(xs, xs, 0)
}
```

## Usage
- Clone the repository to the chosen directory with `git clone https://github.com/rafalkac02/adform-exam-1` command.
- Run the application with `sbt run` command in the same directory
- Test the application with `sbt test` command
