
object listOps {
    def init[T](xs: List[T]): List[T] = xs match {
        case List() => throw new Error("init of empty list")
        case List(x) => Nil
        case y :: ys => y :: init(ys)
    }

    val initPartial: PartialFunction[List[Int], List[Int]] =  {
        case List() => throw new Error("init of empty list")
        case List(x) => Nil
        case y :: ys => y :: init(ys)
    }

    init(List(1, 2, 3))
    initPartial(List(1, 2, 3))

    def concat[T](xs: List[T], ys: List[T]): List[T] = xs match {
        case List() => ys
        case z :: zs => z :: concat(zs, ys)
    }

    // n*n complexity
    def reverse[T](xs: List[T]): List[T] = xs match {
        case Nil => Nil
        case y :: ys => reverse(ys) ++ List(y)
    }

    reverse(List(1, 2, 3))

    def removeAt[T](n: Int, xs: List[T]) = {
        def _removeAt[T](i: Int, xs: List[T]): List[T] = xs match {
            case Nil => Nil
            case List(x) => List(x)
            case y :: ys => if(i == n) _removeAt(i + 1, ys) else y :: _removeAt(i + 1, ys)
        }

        _removeAt(0, xs)
    }

    removeAt(1, List('a', 'b', 'c', 'd'))
}