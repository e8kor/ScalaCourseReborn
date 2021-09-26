package day4

trait Meme

trait CanFly:

  def fly( to: (Int, Int, Int)): Unit

  def walk( to: (Int, Int)): Unit

trait Human:

  def makeMeme(): Meme

  def walk(from: (Int, Int), to: (Int, Int)): Unit

object Example:

  val x: Human & CanFly = ???

  val r1 = x.walk(3 -> 3)
  val r2 = x.makeMeme()
