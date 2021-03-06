
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

    // my version
    def removeAt_my[T](n: Int, xs: List[T]) = {
        def _removeAt[T](i: Int, xs: List[T]): List[T] = xs match {
            case Nil => Nil
            case List(x) => List(x)
            case y :: ys => if(i == n) _removeAt(i + 1, ys) else y :: _removeAt(i + 1, ys)
        }

        _removeAt(0, xs)
    }

    removeAt_my(1, List('a', 'b', 'c', 'd'))

    def removeAt[T](n: Int, xs: List[T]) = (xs take n) ::: (xs drop n + 1)

    def flatten(xs: List[Any]): List[Any] = {
        def _innerFlatten(xxs: List[Any]): List[Any] = {
            xxs match {
                case Nil => Nil
                case y :: ys => y match {
                    case zs: List[Any] => flatten(zs)
                    case z => z :: _innerFlatten(ys)
                }
            }
        }

        xs match {
            case Nil => Nil
            case y :: ys => y match {
                case z: List[Any] => _innerFlatten(z) ++ flatten(ys)
                case z: Any => z :: _innerFlatten(ys)
            }
        }
    }

    flatten(List(List(1, 1), 2, List(3, List(5, 8))))
    assert(flatten(List(List(1, 1), 2, List(3, List(5, 8)))) == List(1, 1, 2, 3, 5, 8))
}