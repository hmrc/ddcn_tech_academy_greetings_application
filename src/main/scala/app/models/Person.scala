package app.models

class Person(name : String, age : Int, val bankAccounts: Seq[BankAccount] = Nil) {

  private val excluded = List("adam", "daniel")

  def this(name: String, age : Int) = this(name, age, List(new SavingsAccount("12345", 0.00)))

  private def years : String = if(age > 1) "years" else "year"

  def speak() : String = {

    if (excluded.contains(name.toLowerCase)) {
      s"You don't get a hello!"
    } else {
      s"Hello $name, you are $age $years old. \nYour account details are: $bankAccounts"
    }
  }

  def totalBalance = bankAccounts.map(_.balance).sum

  def sumAndMultipleBy(f: Double => Double) = bankAccounts.map(x => f(x.balance)).sum

}
