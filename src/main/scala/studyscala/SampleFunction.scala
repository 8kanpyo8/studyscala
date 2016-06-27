package studyscala

object SampleFunction {
  def main(args: Array[String]): Unit = {
  }

  //
  println("// 関数定義")
  def f1(x: Int,y: Int) = {
    println("Called f1") ; x + y
  }
  println(f1(1,2))
  // ↓こう書ける
  def f5:(Int,Int) => Int = { _ + _ }
  println(f5(1,2))

  //
  println("// 関数に関数を渡す")
  def f2( f:(Int,Int)=>Int ) = {
    println("Called f2") ; f(4,5) * 2
  }
  println(f2(f1))

  //
  println("// 関数リテラル(無名関数)")
  val v1 = (x:Int,y:Int) => {
    println("Called 関数リテラル1") ; x + y
  }
  println(v1(2,3))
  // ↓こう書ける
  val v5:(Int,Int) => Int = { _ + _ }
  println(v5(2,3))

  //
  println("// 関数に関数リテラルを渡す")
  def f3( f:(Int,Int)=>Int ) = {
    println("Called f3") ; f(3,4) * 2
  }
  println(f3(v1))

  //
  println("// 関数リテラルに関数リテラルを渡す")
  val v2 = (f:(Int,Int)=>Int) => {
    println("Called 関数リテラル2") ; f(3,5) * 3
  }
  println(v2(v1))

  //
  println("// 関数リテラルの返却で関数リテラルを返す(カリー化)")
  // val v3 = (x:Int)=>(y:Int)=>x+y
  val v3 = (x:Int)=> {
    println("Called 関数リテラル3") ; (y:Int)=> {
      println("Called 関数リテラル4") ;
      x+y
    }
  }
  println(v3(3)(8))
  println("// 複数のパラメータを持つ関数リテラルをカリー化")
  val v4 = ((x:Int,y:Int)=> x+y).curried //
  println(v4(3)(8))

  //
  println("// 高階関数の例")
  def f4 = (init:()=>Unit,execute:()=>Unit,fin:()=>Unit) => {
    init()
    try {
      execute()
    }catch{
      case e:Exception => println("catch " + e)
    } finally {
      fin()
    }
  }
  f4( ()=>println("前処理 ファイルを開くなど") ,
    ()=>println("本処理 ファイルへのアクセスなど") ,
    ()=>println("後処理 ファイルを閉じるなど") )

  f4( ()=>println("前処理 ファイルを開くなど") ,
    ()=> { println("本処理 ファイルへのアクセスなど、途中で例外発生") ; throw new Exception("例外発生！") } ,
    ()=>println("後処理 ファイルを閉じるなど") )

}

