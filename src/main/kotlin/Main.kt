fun main(args: Array<String>) {
    println("Hello World!")
    println("Program arguments: ${args.joinToString()}")
    printMessageWithPrefix("Eggbert")
    printMessageWithPrefix("Englebert", "Hello")
    printMessageWithPrefix( prefix = "My dear ", message = "Delores")
    println("=== Try Reflect ====")
    var result = reflect(10, { z -> z*z })
    println("1st result = " + result)
    result = reflect(10) { z -> z*z }
    println("2nd result = " + result)
    result = reflect( 10 ) { it * it }
    println("3rd result = " + result)

    result = reflect( 10 , ::pow)
    println("result = " + result)

    result = reflect( 5 , ::twopow)
    println("result = " + result)

    trial("Hello")
    //val add = { a, b -> a+b }   will not compile - can't infer type!
}
fun printMessageWithPrefix(message: String, prefix: String = "Info") {  // 2
    println("[$prefix] $message")
}
fun reflect(    a: Int,  f: (Int) -> Int    ): Int {
    return f(a)
}
fun pow( x:Int): Int {
    return x*x
}
fun twopow(  x:Int): Int {
    var product = 1
    var xx = x
    while( xx > 0 ) {
        product *= 2
        xx--
    }
    return product
}
fun trial(x: Any) : Unit {
    println("x = $x")
}
