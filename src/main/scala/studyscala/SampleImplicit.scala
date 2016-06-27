/*
暗黙変換 implicit conversion
    pimp my libraryパターン

--------
scala> class M(val n:Int) {
     |   def zzz() = "zzz" + n
     | }
defined class M

scala> implicit def int2m(n:Int) = new M(n)
int2m: (n: Int)M

scala> 123.zzz()
res1: java.lang.String = zzz123


---------------------
//StringにisUpper()メソッドを追加する
scala> implicit def stringIsUpper(s:String) = new{ def isUpper() = s.forall(_.isUpper) }
stringIsUpper: (s: String)java.lang.Object{def isUpper(): Boolean}

scala> "abc".isUpper
res1: Boolean = false

scala> "ABC".isUpper
res2: Boolean = true


---------------------
暗黙クラス(pimp my libraryパターンを使わなくて良い書き方)
implicit class MyString(val s: String) extends AnyVal {
  def toMyClass() = new MyClass(s.toInt)

  def isUpper() = s.forall(_.isUpper)
}

---------------------
暗黙引数  ...使いドコロがわからん
view bound
//


 */