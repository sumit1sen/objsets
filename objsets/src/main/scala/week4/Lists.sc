import objsets.Empty

trait List[+T] {
  def isEmpty:Boolean
  def head:T
  def tail:List[T]
  def prepend[U>:T](elem:U):List[U] = new Cons(elem, this)
}
class Cons[T](val head:T, val tail:List[T]) extends List[T] {
  override def isEmpty: Boolean = false
}
object Nil extends List[Nothing] {
  def isEmpty: Boolean = true

  def tail: Nothing = throw new NoSuchElementException("")

  def head: Nothing = throw new NoSuchElementException("")
}

object List {
  def apply[T](x1: T, x2: T):List[T] = new Cons(x1, new Cons(x2, Nil))
  def apply[T]():List[T] = Nil
  def apply[T](x1:T, x2:T, x3:T):List[T] = new Cons(x1, apply(x2,x3))


}

abstract class IntSet {

}
object Empty extends IntSet {

}
class NonEmpty(val head:Int, val left:IntSet, val right:IntSet) extends IntSet {

}

def f(xs:List[NonEmpty],x:Empty)= xs prepend x

val a: Array[NonEmpty] = Array(new NonEmpty(1, Empty, Empty))
//val b: Array[IntSet] = a
//b(0) = Empty
val s: NonEmpty = a(0)
val g = new Cons[Int](5,Nil)
val h = g.prepend(23)
f(h, new Empty )
