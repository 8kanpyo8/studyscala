package studyscala

object SampleClass {
  def main(args: Array[String]): Unit = {
  }

  //
  println("// クラス定義")
  class cls1(val _x: Int,val _y: Int) {
    def addX(x: Int) = new cls1(_x+x, _y)
    def addY(y: Int) = new cls1(_x,_y+y)
    // コンストラクターの引数にvalをつけると公開される(c._xと触れる)
    def +(c:cls1):cls1 = new cls1(_x+c._x,_y+c._y)
    def add(x: Int)(y: Int) = new cls1(_x+x,_y+y)
    final def print() = println(getValues)
    protected def getValues:String = "x="+_x+",y="+_y
  }
  val val1_1 = new cls1(3, 4)
  val1_1.print()
  val1_1.addX(4).print()
  (val1_1 + val1_1.addY(2)).print()
  val1_1.add(1)(2).print()
  val val1_2 = val1_1.add(1) _
  val1_2(2).print()
  val1_2(3).print()

  //
  println("// クラス継承")
  // 親クラスのメソッド getValues をオーバーライド。親クラスのgetValueを使用
  class cls2(_x:Int,_y:Int,_z:Int) extends cls1(_x,_y) {
    override def getValues:String = "cls2 "+super.getValues + ",z=" + _z
  }
  new cls2(1,2,3).print()


  //
  println("// 抽象クラス")
  // getNameのメソッドを子クラスに実装強要。抽象メソッド
  abstract class cls3(_x:Int,_y:Int) extends cls1(_x,_y) {
    protected def getName:String
    def printName():Unit = println(getName)
  }
  class cls4(_x:Int,_y:Int) extends cls3(_x,_y) {
    protected def getName = "cls4"
  }
  new cls4(6,7).printName()
  Array(1,2)


  //
  // 自分型アノテーション



}
