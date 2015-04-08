package week_3

trait List[T] {
    def isEmpty: Boolean
    def head: T
    def tail: List[T]
}

/*
* !!!!! val makes the two parameters fields of the class; In scala field definitions are special
* cases of classes methods; they can override methods and implement abstract methods. The only difference
* is how they are being evaluated using the substitution model. The `def` definitions are evaluated
* `by name` (they are evaluated ever every time they're referenced) whereas `val` definitions are evaluated
* `by value` (when the object is initialized) !!!!!
*/
class Cons[T](val head: T, val tail: List[T]) extends List[T]{
    def isEmpty = false

    val head: T =
}
