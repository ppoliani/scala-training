
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
}