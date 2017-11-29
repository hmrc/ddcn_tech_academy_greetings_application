package app.models

class Person(name : String, age : Int, val bankAccount: BankAccount) {

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
