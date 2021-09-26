1 -> "one" == (1, "one")
1 → "one".==(1, "one")

"1".toInt

val str = "abc"

str.charAt(0) == str(0)

val regex = "M | [IN]|B".r

val date = "([\\d]+)-([\\d]+)-([\\d]+)".r

"2021-09-25" match {
  case date(year, month, day) =>
    println(s"year: ${year}, month: ${month}, day: ${day}")
}