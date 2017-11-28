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
                           val balance: AccountTypes.Balance) {

  def withdraw(amount : Double) : BankAccount
  def deposit(amount : Double) : BankAccount

  override def toString: AccountNumber = s"Account number: $accountNumber, balance : $balance"
}

final class SavingsAccount(accountNumber: AccountNumber,
                           balance: Balance) extends BankAccount(accountNumber, balance) {

  override def withdraw(amount: Balance): BankAccount = {
    if ((balance - amount) < 0) {
      println(s"You have insufficient funds")
      this
    } else {
      val deducted = balance - amount
      new SavingsAccount(accountNumber, deducted)
    }
  }

  override def deposit(amount: Balance): BankAccount = {
    new SavingsAccount(accountNumber, balance + amount)
  }

}

final class CashISASavingsAccount(accountNumber: AccountNumber,
                                  balance: Balance,
                                  private val depositThreshold : Double = 200.00) extends BankAccount(accountNumber, balance) {

  override def withdraw(amount: Balance): BankAccount = {
    println(s"You can't withdraw yet, your money is locked in for 3 years!!! And... we've reduced your APR to 0.2%!")
    this
  }

  override def deposit(amount: Balance): BankAccount = {
    if (amount > depositThreshold) {
      val difference = amount - depositThreshold
      println(s"You can't deposit more than £$depositThreshold. Excess: £$difference.")
      new CashISASavingsAccount(accountNumber, balance + depositThreshold)
    } else {
      new CashISASavingsAccount(accountNumber, balance + amount)
    }
  }

}

class Person(name : String, age : Int,   val bankAccount: BankAccount) {

  def this(name: String, age : Int) = this(name, age, new SavingsAccount("12345", 0.00))

  private def years : String = if(age > 1) "years" else "year"

  def speak() : String = {
    if (name.toLowerCase.contains("adam")) {
      s"You don't get a hello!"
    } else {
      s"Hello $name, you are $age $years old. \nYour account details are: $bankAccount"
    }
  }

}

object GreeterApplication extends App {
  val name = Prompt.ask("What is your name? ")
  val age = Prompt.ask("How old are you? ")

  val cashisa = new CashISASavingsAccount("45676", 0.0, 1000.00)
  val deposited = cashisa.deposit(1000.00)
  val withdrawn = deposited.withdraw(200.00)

  val normalAccount = new CashISASavingsAccount("12334", 100.00)
  val loyalAccountDeposited = normalAccount.deposit(300.00)

  val person = new Person(name, age.toInt, withdrawn)

  val loyal = new Person("Loyal customer", 22, loyalAccountDeposited)

  println(person.speak())
  println(loyal.speak())
}

