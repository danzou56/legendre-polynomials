open class Rational(private val a: Int, private val b: Int) {
    init {
        if (b == 0) {
            throw IllegalArgumentException("b cannot be zero")
        }
    }

    open operator fun plus(that: Rational): Rational = when {
        this.b == that.b -> Rational(this.a + that.a, b)
        else -> {
            val lcm = lcm(this.b, that.b)
            val thisFactor = this.b / lcm
            val thatFactor = that.b / lcm
            Rational(this.a * thisFactor + that.a * thatFactor, lcm)
        }
    }

    open operator fun plus(that: Integer): Rational = Rational(a + b, b)

    open operator fun times(that: Rational): Rational {
        val gcd = gcd(this.a, that.a)
        return Rational(this.a * that.a / gcd, this.b * that.b / gcd)
    }

    private fun gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
    private fun lcm(a: Int, b: Int) = a * b / gcd(a, b)

}