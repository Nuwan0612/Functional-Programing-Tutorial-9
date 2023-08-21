object Q2 {

  class Rational(numerator: Int, denominator: Int) {
    private val gcd = gcdFunc(numerator.abs, denominator.abs)
    val numer = numerator / gcd
    val denom = denominator / gcd

    def neg: Rational = new Rational(-numer, denom)

    private def gcdFunc(num1: Int, num2: Int): Int = {
      if (num2 == 0) num1 else gcdFunc(num2, num1 % num2)
    }

    def sub(next: Rational): Rational = {
      new Rational(numer*next.denom - denom*next.numer, denom*next.denom)
    }

    override def toString: String = s"$numer/$denom"
  }


  def main(args: Array[String]): Unit = {
    val x = new Rational(3, 4)
    val y = new Rational(5, 8)
    val z = new Rational(2, 7)

    val result = x.sub(y).sub(z)

    println("x: " + x)
    println("y: " + y)
    println("z: " + z)
    println("x - y - z: " + result)
  }
}
