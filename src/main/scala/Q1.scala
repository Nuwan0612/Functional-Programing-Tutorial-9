object Q1 {
  class Rational(numerator: Int, denominator: Int) {
    private val gcd = gcdFunc(numerator.abs, denominator.abs)
    val numer = numerator / gcd
    val denom = denominator / gcd

    def neg: Rational = new Rational(-numer, denom)

    private def gcdFunc(num1: Int, num2: Int): Int = {
      if(num2==0) num1 else gcdFunc(num2, num1%num2)
    }

    override def toString: String = s"$numer/$denom"
  }

  def main(args: Array[String]): Unit = {
      val x = new Rational(3, 4)
      val neg = x.neg

      println("x: " + x)
      println("-x: " + neg)
  }
}
