data class Integer(private val a: Int): Rational(a, 1) {
    override operator fun plus(that: Rational): Rational = that + this

    override operator fun plus(that: Integer): Integer = Integer(this.a + that.a)

    operator fun times(that: Integer): Integer = Integer(this.a * that.a)

    override operator fun times(that: Rational): Rational = that * this
}
