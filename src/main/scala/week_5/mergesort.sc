object mergesort {
    def msort(xs: List[Int]): List[Int] = {
        val n = xs.length / 2

        if(n == 0) xs
        else {
            val (fst, snd) = xs splitAt n
            merge(msort(fst), msort(snd))
        }
    }

    def merge(xs: List[Int], ys: List[Int]): List[Int] = (xs, ys) match {
        case (Nil, ys) => ys
        case (xs, Nil) => xs
        case (x :: xs1, y :: ys1) =>
            if(x < y) x :: merge(xs1, ys)
            else y :: merge(xs, ys1)
    }

    val nums = List(2, -4, 5, 7, 1)
    msort(nums)

    // parametized version

    /**
     * We cannot simple use type parameters of T because in the merge function there
     * is a function call to the < method i.e. x < y but x is of generic type T which doesn't have
     * that function. Thus we pass a comparer function
     */
    def msortParam[T](xs: List[T])(ls: (T, T) => Boolean): List[T] = {
        val n = xs.length / 2

        if(n == 0) xs
        else {
            def mergeParam(xs: List[T], ys: List[T]): List[T] = (xs, ys) match {
                case (Nil, ys) => ys
                case (xs, Nil) => xs
                case (x :: xs1, y :: ys1) =>
                    if(ls(x, y)) x :: mergeParam(xs1, ys)
                    else y :: mergeParam(xs, ys1)
            }

            val (fst, snd) = xs splitAt n
            mergeParam(msortParam(fst)(ls), msortParam(snd)(ls))
        }
    }

    msortParam(nums)((x: Int, y: Int) => x < y)
}