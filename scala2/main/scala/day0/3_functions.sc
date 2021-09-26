// Simple Function
def sum(left: Int, right: Int): Int = {
  left + right
}

sum(10, 30)


// Functions with varargs
def varargs(args: String*): Unit = println(args)
varargs()
varargs("one")
varargs("one", "two")


// Curried Functions 1
// Named arguments, default values, multiple argument lists, call-by name arguments
def debug(before: String, after: String = 0)(body: => Unit): Unit = {
  println(before)
  body
  println(after)
}

debug("Hello", "World")(println("Beautiful"))

debug("Hello")(println("World"))

debug(after = "World", before = "Hello") {
  println("Beautiful")
}


// Curried function 2
// if then else function
def ifElse(pred: Boolean)(cons: => Unit)(alt: => Unit): Unit = if (pred) cons else alt

ifElse(true) {
  println("In truth we trust")
} {
  println("Or not")
}


// Anonymous Functions
def isEmpty(arg: String): Boolean = arg.isEmpty // type is Function1[String, Boolean]
val isEmpty2 = (arg: String) => arg.isEmpty // also can be written as (String => Boolean)

val isEmpty3 = new Function1[String, Boolean] {
  override def apply(v1: String): Boolean = v1.isEmpty
}

val isEmpty3Short: String => Boolean = v1 => v1.isEmpty


val isEmpty4 = isEmpty _ // eta expansion

isEmpty("") == isEmpty2("") == isEmpty3("") == isEmpty4("")
