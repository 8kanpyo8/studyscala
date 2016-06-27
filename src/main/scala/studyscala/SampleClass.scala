package studyscala

object SampleClass {
  def main(args: Array[String]): Unit = {
  }

  //
  println("// クラス定義")
  class Cls1(val x: Int, val y: Int) {
    def addX(x: Int) = new Cls1(this.x + x, this.y)
    def addY(y: Int) = new Cls1(this.x, this.y + y)
    // コンストラクターの引数にvalをつけると公開される(c._xと触れる)
    def +(c:Cls1):Cls1 = new Cls1(this.x + c.x, this.y + c.y)
    def add(x: Int)(y: Int) = new Cls1(this.x + x, this.y + y)
    final def print() = println(getValues)
    protected def getValues:String = "x="+this.x+",y="+this.y
  }
  val val1_1 = new Cls1(3, 4)
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
  class Cls2(x: Int, y: Int, z: Int) extends Cls1(x,y) {
    override def getValues:String = "Cls2 "+super.getValues + ",z=" + z
  }
  new Cls2(1,2,3).print()


  //
  println("// 抽象クラス")
  // getNameのメソッドを子クラスに実装強要。抽象メソッド
  abstract class Cls3(x: Int, y: Int) extends Cls1(x,y) {
    protected def getName:String
    def printName():Unit = println(getName)
  }
  class Cls4(x: Int,y: Int) extends Cls3(x,y) {
    protected def getName = "Cls4"
  }
  new Cls4(6,7).printName()
  Array(1,2)


  //
  // 自分型アノテーション



}
