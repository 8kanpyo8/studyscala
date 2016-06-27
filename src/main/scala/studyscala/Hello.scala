package studyscala

object Hello {
  def main(args: Array[String]): Unit = {
    val i = for (x <- 1 to 10000; y <- 1 to 10000) x + y
    println("Hello, world!")
  }

  println("aaa")
  timeOf(main(Array()))

  println("aaa")
  timeOf(main(Array()))

  println("aaa")
  timeOf(main(Array()))
}
