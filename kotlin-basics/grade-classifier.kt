fun main() {

    val score = 98

    when (score) {
        in 90..100 -> println("Grade: A")
        in 80..89 -> println("Grade: B")
        in 70..79 -> println("Grade: C")
        else -> println("Grade: F")
    }
}
