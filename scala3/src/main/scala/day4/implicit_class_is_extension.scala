package day4

case class System(uptime: Long, kernel: String)

extension (system: System)

  def startTimeInMillis: Long =
    java.lang.System.currentTimeMillis() - system.uptime
