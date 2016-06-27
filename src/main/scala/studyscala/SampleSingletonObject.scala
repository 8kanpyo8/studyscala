package studyscala

object SampleSingletonObject {
  def main(args: Array[String]): Unit = {
  }

  //
  println("// シングルトンオブジェクト")
  object Obj1 {
    def myName = "Obj1"
  }
  println(Obj1.myName)

  //
  println("// コンパニオンオブジェクト")
  class Cls2 (private val x: Int, private val y: Int) {
    def myName = "Cls2 x=" + x + ",y=" + y
  }
  object Cls2 {
    def apply(x: Int, y: Int): Cls2 = new Cls2(x,y)
    def unapply(arg: Cls2) = Option((arg.x, arg.y))
  }
  println(Cls2(3,2).myName)
  // apply により new なしでインスタンス化可能
  val obj2 = Cls2(1,1)
  println(obj2.myName)
  // unapply により値の抽出
  val Cls2(x,y) = obj2
  println("x=" + x + ",y=" + y)

  //
  println("// implicit")
  println("// staticな関数の置き場所")



}

