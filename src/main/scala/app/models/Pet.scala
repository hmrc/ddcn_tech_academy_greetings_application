package app.models

import java.util.UUID

sealed trait Pet {

  protected val _uuid = UUID.randomUUID()

  def id = _uuid

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
