package app.models

import java.util.UUID

sealed trait Pet {

  protected val _uuid = UUID.randomUUID()

  def id = _uuid

  val name : String
  def speak() : String = "hello"
}

final class Dog(override val name : String) extends Pet {
  override def speak(): String = "woof!"
}

final class Cat(override val name : String) extends Pet {
  override def speak(): String = "meow..."
}
