/**
  * Created by a on 16/06/24.
  */
package object studyscala {


  def timeOf[A](f: => A): A = {
    val start = System.currentTimeMillis
    val result = f
    val end = System.currentTimeMillis
    println("[Time] %s ms".format(end - start))
    result
  }

}
