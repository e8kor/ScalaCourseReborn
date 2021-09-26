package day1

import scala.language.postfixOps

/**
 * Created by evgeniikorniichuk on 24/06/15.
 */
object lazylists extends App {

  import scala.io.Source

  def readStream(iterator: Iterator[Char]): LazyList[String] = {
    iterator span {
      char =>
        println(s"next char: $char")
        char != ','
    } match {
      case (head, tail) if !(head hasNext) && !(tail hasNext) => LazyList empty
      case (head, tail) if (head hasNext) && !(tail hasNext) => (head mkString) #:: (LazyList empty)
      case (head, tail) if !(head hasNext) && (tail hasNext) => readStream(tail drop 1)
      case (head, tail) /*if (head hasNext) && (tail hasNext)*/ => (head mkString) #:: readStream(tail drop 1)
    }

  }

  new StreamsTutorial(
    readStream(Source fromURL {
      println("open resource file")
      getClass getResource "/collection.data"
    })
  )
}

class StreamsTutorial(stream: LazyList[String]) {

  stream foreach {
    entry =>
      println(s"next value of stream: $entry")
  }

}
