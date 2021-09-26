package day1

import scala.language.postfixOps

/**
 * Created by evgeniikorniichuk on 23/06/15.
 */

object Application extends App {

  import scala.io.Source.fromInputStream

  val resourceData = (fromInputStream(getClass getResourceAsStream "collection.data") mkString) split ","
  new CollectionsTutorial(args ++ resourceData)
}

// Only difference between mutable and immutable collections is
// mutable -> modify itself
// immutable -> produce new collection for each operation
class CollectionsTutorial(args: Seq[String]) {

  // Safe
  def filterOnlyNumbers(): Seq[Int] = {
    args filter {
      entry =>
        entry forall (Character isDigit)
    } map {
      entry =>
        entry toInt
    }
  }

  // Safe
  def filterNonNumbers(): Seq[String] = {
    args filter {
      entry =>
        // String is also collection
        entry exists (Character isLetter)
    }
  }

  // Safe
  def filterNonNumbers2(): Seq[String] = {
    import scala.util.control.Exception.allCatch
    args filter {
      entry =>
        allCatch opt (entry toLong) isDefined
    }
  }

  // Not safe
  def filterNonNumbers3(): Seq[Long] = {
    args map (_ toLong)
  }

  def sum: Int = {
    // No collection sugar:
    // filterOnlyNumbers() reduce (_ + _)
    filterOnlyNumbers() sum
  }
}
