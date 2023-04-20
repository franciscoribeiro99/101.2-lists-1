class Test {
  val names = List("Ibra", "Paul", "Kadabra", "Charles-Louis")
  println(names.mkString(", "))

  if (names.contains("Paul")) {
    println("Paul is in the list")
  } else {
    println("Paul is not in the list")
  }
  val updatedNames = names.filter(_ != "Paul")
  println(updatedNames.mkString(", "))
}

object testons extends App {
  val b = new Test()
}
