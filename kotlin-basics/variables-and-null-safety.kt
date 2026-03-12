fun main() {
    val name: String = "Gina"
    val nickname: String? = null  
    val age: Int = 20

     if (nickname != null) {
        println("Nickname: $nickname")
    } else {
        println("No nickname provided.")
    }
    println("Name: $name")

    if (age >= 18) {
        println("$name is an adult.")
    } else {
        println("$name is a minor.")
    }
}
