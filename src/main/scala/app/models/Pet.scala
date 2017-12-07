package app.models

sealed trait Pet {
  val name : String
  val age : Int
  def speak() : String = "hello"
}

final case class Dog(override val name : String, age : Int) extends Pet {
  override def speak(): String = "woof!"
}

final case class Cat(override val name : String, age: Int) extends Pet {
  override def speak(): String = "meow..."
}
