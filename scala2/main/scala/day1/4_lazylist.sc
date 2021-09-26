import scala.language.postfixOps

// STREAM
val stream = LazyList from 1

stream knownSize

stream length // error as not defined

(stream isEmpty) && stream.nonEmpty


val fibs: LazyList[BigInt] = BigInt(0) #:: BigInt(1) #:: fibs.zip(fibs.tail).map {
  case (head, previous) =>
    println("Adding %d and %d".format(head, previous))
    head + previous
}

fibs length

fibs take 5 foreach println
fibs take 6 foreach println