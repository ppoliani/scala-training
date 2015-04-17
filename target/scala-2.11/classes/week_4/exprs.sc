import week_4._
object  exprs {
    def show(e: Expr) : String = e match {
        case Number(x) => x.toString
        case Sum(l, r) => show(l) + " + " + show(r)
    }

    show(Sum(Number(2), Number(5)))
}