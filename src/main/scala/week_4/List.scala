package week_4

trait List[T] {
    def isEmpty: Boolean
    def head: T
    def tail: List[T]
}

/*
* !!!!! val makes the two parameters fields of the class; In scala field definitions are special
* cases of class methods; they can override methods and implement abstract methods. The only difference
* is how they are being evaluated using the substitution model. The `def` definitions are evaluated
* `by name` (they are evaluated ever every time they're referenced) whereas `val` definitions are evaluated
* `by value` (when the object is initialized) !!!!!
*/
class Cons[T](val head: T, val tail: List[T]) extends List[T]{
    def isEmpty = false
}

class Nil[T] extends List[T] {
    def isEmpty: Boolean = true

    def head: Nothing = throw new NoSuchElementException("Nil.head")

    def tail: Nothing = throw new NoSuchElementException("Nil.head")
}


object List {
    def apply[T](x1: T, x2: T): List[T] = new Cons(x1, new Cons(x2, new Nil))
    def apply[T]() = new Nil
}