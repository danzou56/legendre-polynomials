data class Polynomial(private val polynomial: ArrayList<Int>) {

    operator fun plus(that: Polynomial): Polynomial {
        val result = ArrayList<Int>()
        val shortList = when {
            this.polynomial.size >= that.polynomial.size -> this.polynomial
            else -> that.polynomial
        }
        val longList = when {
            this.polynomial.size >= that.polynomial.size -> that.polynomial
            else -> this.polynomial
        }

/*        for (i in 0 until shortList.size) {
            result.add(shortList.get(i) + longList[i])
        }*/

        (0 until shortList.size)
                .mapTo(result) { shortList.get(it) + longList[it] }
        (shortList.size until longList.size)
                .forEach { result.add(longList[it])}

        return Polynomial(result)
    }

    operator fun times(that: Polynomial): Polynomial {
        return Polynomial(this.polynomial)
    }

}