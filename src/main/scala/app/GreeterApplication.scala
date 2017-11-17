package app

import app.AccountTypes.{AccountNumber, Balance}

import scala.io.StdIn

object Prompt {

  def ask(message: String) = StdIn.readLine(message)

}

object AccountTypes {
  type AccountNumber = String
  type Balance = Double
}

abstract class BankAccount(accountNumber : AccountTypes.AccountNumber,
                           balance: AccountTypes.Balance) {

  def withdraw(amount : Double) : AccountTypes.Balance
  def deposit(amount : Double) : AccountTypes.Balance
}

final class SavingsAccount(accountNumber: AccountNumber,
                           balance: Balance) extends BankAccount(accountNumber, balance) {

  override def withdraw(amount: Balance): Balance = {
    0.00
  }

  override def deposit(amount: Balance): Balance = {
    0.00
  }

}

class Person(name : String, age : Int) {

  private def years : String = if(age > 1) "years" else "year"

  def speak() : String = {
    if (name.toLowerCase.contains("adam")) {
      s"You don't get a hello!"
    } else {
      s"Hello $name, you are $age $years old"
    }
  }

}

object GreeterApplication extends App {
  val name = Prompt.ask("What is your name? ")
  val age = Prompt.ask("How old are you? ")

  val person = new Person(name, age.toInt)
  println(person.speak())
}

