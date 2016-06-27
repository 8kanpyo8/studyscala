package studyscala

object SampleFor {
  def main(args: Array[String]): Unit = {
  }

  println("// ListとArrayの要素をひとつずつ処理する")
  for ( x <- List(1,2,3) ; y <- Array("a","b","c") )
    println( "x=" + x + ",y=" + y )

  println("// 1から5の総当り戦(条件付与)")
  println(
    for ( x <- 1 to 5 ; y <- 1 to 5 ; if x < y )
      yield (x , y)
  )

  println("// ジェネレータでパターンマッチも可能")
  val map = Map(1->"s",2->"c",3->"a",4->"l",5->"a")
  println(map)
  val ret = for ( m@(k,v)  <- map ; if v != "a" ) yield m
  println(ret)
}
