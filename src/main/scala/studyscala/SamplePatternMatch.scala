package studyscala

object SamplePatternMatch {
  def main(args: Array[String]): Unit = {
  }

  println("// 変数パターン(数値)")
  def f1 (p: Int): String = {
    p match {
      case 1 => "one"
      case _ => "other"
    }
  }
  println(f1(1))

  println("// 変数パターン(文字列)")
  def f2 (p: String): String = {
    p match {
      case "scala" | "java" => p
      case _ => "unknown lang"
    }
  }
  println(f2("scala"))
  println(f2("c++"))


  println("// 変数パターン(部分一致)")
  def f3 (p: Array[Int]): String = {
    p match {
      case Array(1,2,_) => "Case1. 1,2,?"
      case Array(_,2,_*) => "Case2. ?.2,?,?..."
      case Array(_,2|5,_*) => "Case3. ?.2or5,?,?..."
      case _ => "Case4. other"
    }
  }
  println(f3( Array(1,2,3) ))
  println(f3( Array(1,2,3,4) ))
  println(f3( Array(2,2) ))
  println(f3( Array(1,5,3,4) ))


  println("// パターンバインド、ガード")
  def f4 (p: Array[Int]): String ={
    p match {
      case Array(x,2,z) if x < z => "Case1. x=" + x + ",z="+z
      case Array(x,2,z) => "Case2. x=" + x + ",z="+z
      case Array(x,2,z@_*) => "Case3. x=" + x + ",z="+z
      case _ => "Case4. other"
    }
  }
  println(f4( Array(1,2,3) ))
  println(f4( Array(1,2,3,4) ))
  println(f4( Array(3,2,1) ))

  println("// パターンバインド(変数)")
  def f5 () = {
    val Array(ax, ay, az) = Array(1, 2, 3)
    println("ax=" + ax + ",ay=" + ay + ",az=" + az)
    val t@(sebangou, sei, mei) = (10, "大空", "翼")
    println("背番号" + sebangou + " " + sei + mei)
  }
  f5()

  println("// パターンバインド(caseクラス)")
  def f6 () = {
    case class Sensyu(_sebangou: Int, _sei: String, _mei: String)
    val kojirou = Sensyu(9, "日向", "小次郎")
    val Sensyu(sebangou, sei, mei) = kojirou
    println("背番号" + sebangou + " " + sei + mei)
  }
  f6()

  println("// パターンマッチバインド(caseクラス)")
  def f7 () = {
    case class Sensyu(_sebangou: Int, _sei: String, _mei: String)
    val tsubasa = Sensyu(10, "大空", "翼")
    val kojirou = Sensyu(9, "日向", "小次郎")
    def captain(p:Any):String = {
      p match {
        case Sensyu(10,sei,mei) => "Case1. " + sei + mei
        case Sensyu(sebangou,sei,mei) => "Case2. " + sei + mei
        case (10,sei,mei) => "Case3. " + sei + mei
        case (sebantou,sei,mei) => "Case4. " + sei + mei
        case _ => "Case5. other"
      }
    }
    println( captain(tsubasa) )
    println( captain(kojirou) )
    println( captain( (10,"リオネル","メッシ") ) )
  }
  f7()

  /*
  println("// パターンマッチバインド(XML)")
  def f8 () = {

    def zip2address(_zip:Int):String = {
      val query = "http://zip.cgis.biz/xml/zip.php" + "?zn=" + _zip
      val xml = scala.io.Source.fromURL(query,"utf-8").mkString
      import scala.xml.XML
      val x = scala.xml.XML.loadString(xml)
      scala.xml.Elem()

      println(xml)

      /*
      x match {
        case <ZIP_result>{ n }</ZIP_result> => println(n)  ; "a"
      }
      */

      xml
    }

    println(zip2address(2110053))


  }
  f8()
  */

}
