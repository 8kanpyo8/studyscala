package studyscala

object SampleFunction {
  def main(args: Array[String]): Unit = {
  }

  //
  println("// 関数定義")
  def func1(x: Int,y:Int) = {
    println("Called func1") ; x + y
  }
  println(func1(1,2))

  //
  println("// 関数に関数を渡す")
  def func2( f:(Int,Int)=>Int ) = {
    println("Called func2") ; f(4,5) * 2
  }
  println(func2(func1))

  //
  println("// 関数リテラル(無名関数)")
  val val1 = (x:Int,y:Int) => {
    println("Called 関数リテラル1") ; x + y
  }
  println(val1(2,3))

  //
  println("// 関数に関数リテラルを渡す")
  def func3( f:(Int,Int)=>Int ) = {
    println("Called func3") ; f(3,4) * 2
  }
  println(func3(val1))

  //
  println("// 関数リテラルに関数リテラルを渡す")
  val val2 = (f:(Int,Int)=>Int) => {
    println("Called 関数リテラル2") ; f(3,5) * 3
  }
  println(val2(val1))

  //
  println("// 関数リテラルの返却で関数リテラルを返す(カリー化)")
  // val val3 = (x:Int)=>(y:Int)=>x+y
  val val3 = (x:Int)=> {
    println("Called 関数リテラル3") ; (y:Int)=> {
      println("Called 関数リテラル4") ;
      x+y
    }
  }
  println(val3(3)(8))
  println("// 複数のパラメータを持つ関数リテラルをカリー化")
  val val4 = ((x:Int,y:Int)=> x+y).curried //
  println(val4(3)(8))

  //
  println("// 高階関数の例")
  def func4 = (init:()=>Unit,execute:()=>Unit,fin:()=>Unit) => {
    init()
    try {
      execute()
    }catch{
      case e:Exception => println("catch " + e)
    } finally {
      fin()
    }
  }
  func4( ()=>println("前処理 ファイルを開くなど") ,
    ()=>println("本処理 ファイルへのアクセスなど") ,
    ()=>println("後処理 ファイルを閉じるなど") )

  func4( ()=>println("前処理 ファイルを開くなど") ,
    ()=> { println("本処理 ファイルへのアクセスなど、途中で例外発生") ; throw new Exception("例外発生！") } ,
    ()=>println("後処理 ファイルを閉じるなど") )

}

