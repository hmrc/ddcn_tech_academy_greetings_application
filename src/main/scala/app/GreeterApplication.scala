package app

import models._
import app.repositories.PetRepository
import app.views.Prompt
import scala.util.{Failure, Success, Try}

object GreeterApplication extends App {

  def arguments: (String, Int) = {
    val name = Prompt.ask("What is your name? ")
    val age = Prompt.ask("What is your age? ")

     Try(age.toInt) match {
      case Success(a) => (name, a)
      case Failure(_) => arguments
    }
  }

  val (name, age) = arguments

  val cashisa = new CashISASavingsAccount("45676", 0.0, 1000.00)
  val deposited = cashisa.deposit(1000.00)
  val withdrawn = deposited.withdraw(200.00)

  val person = new Person(name, age, List(withdrawn, deposited))
  Prompt.reply(person.speak())
  Prompt.reply(person.totalBalance)
  Prompt.reply(person.sumAndMultipleBy(_ * 2))

  val normalAccount = new CashISASavingsAccount("12334", 100.00)
  val loyalAccountDeposited = normalAccount.deposit(300.00)

  val loyal = new Person("Loyal customer", 22, List(loyalAccountDeposited))

  Prompt.reply(loyal.speak())

  val dogs : List[Dog] = (for (p <- 1 to 10) yield Dog(s"Dog $p", p)).toList
  val cats : List[Cat] = (for (p <- 1 to 10) yield Cat(s"Cat $p", p)).toList

  Prompt.reply(s"Current pets in repo: ${PetRepository.all()}")

  PetRepository.add(dogs:_*)
  PetRepository.add(cats:_*)

  Prompt.reply(s"Current pets in repo: ${PetRepository.all()}")

  Prompt.reply(s"All dogs in the repository: ${PetRepository.dogs}")
  Prompt.reply(s"All cats in the repository: ${PetRepository.cats}")
  Prompt.reply(s"All other pets in the repository: ${PetRepository.other}")

  val petToFind = Prompt.ask(s"Which pet do you want to find? ")

  Prompt.reply(s"Pet found ${PetRepository.findByName(petToFind)}")

  // modify a pet
  val dog = Dog("Dog 11", 11)
  PetRepository.update(dogs(4), dog)
}