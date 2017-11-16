package app

object GreeterApplication extends App {

  def sayHello(name : String) : Unit = println(s"Hello $name")

  val name = "Adam"

  sayHello(name)
}

