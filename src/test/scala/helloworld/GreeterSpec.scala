package helloworld

import org.scalatest._

class GreeterSpec extends WordSpec with Matchers {
  "Greeter" should {
    "greet the world" in {
      Greeter.message shouldBe "Hello, world!"
    }
  }
}
