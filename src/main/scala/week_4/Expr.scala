package week_4

/**
 * Created by brandview on 14/04/2015.
 */
trait Expr {

}

case class Number(n: Int) extends Expr
case class Sum(e1: Expr, e2: Expr) extends Expr
