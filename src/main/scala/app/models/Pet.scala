package app.models

sealed trait Pet {
  val name : String
  def speak() : String = "hello"
}

final class Dog(override val name : String) extends Pet {
  override def speak(): String = "woof!"
}

final class Cat(override val name : String) extends Pet {
  override def speak(): String = "meow..."
}
