package helloworld

object HelloWorld extends App {
  println(Greeter.message)
}

object Greeter {
  def message = "Hello, world!"
}
