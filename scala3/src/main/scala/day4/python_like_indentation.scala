package day4

class User:

  def say(msg: String): Unit =
    if msg.length % 2 == 1 then
      println(
        s"""
          |$msg
          |${msg}
          |""".stripMargin
      )
    else
      println(msg)




@main def run(message: String): Unit =
  val user = new User
  user.say(message)
